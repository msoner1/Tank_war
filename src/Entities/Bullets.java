package Entities;

import Manager.JukeBox;
import Map.Map;
import States.Play;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Mermi varlıklarını temsil eder ve mermi çarpışmalarını algılar.
 */
public class Bullets extends Entity{

    private BufferedImage bullet_effect_sprite_sheet;
    private BufferedImage[] bullet_effects_sprites;
    private BufferedImage explosion_effect_sprite_sheet;
    private BufferedImage[] explosion_effect_sprites;
    public BufferedImage bullet_1;

    public int bullet_1_x_cordinate;
    public int bullet_1_y_cordinate;

    public static double bullet_1_speed = 10;
    private final double gravity = 2;
    private double gravity_loop = 1;

    public static boolean bullet_is_moving;

    private final int bullet_effect_width = 24;
    private final int bullet_effect_height = 24;

    private final int explosion_effect_width = 73;
    private final int explosion_effect_height = 53;

    private Rectangle tank;

    private int explosion_effect_frame_loop = 0; //patlama animasyonunu bir kere oyatmaya yarayacak değişken


    public Bullets(){

        bullet_1_x_cordinate = 1000;
        bullet_1_y_cordinate = 1000;

        bullet_is_moving=false;
        try {
            bullet_effect_sprite_sheet = ImageIO.read(new FileInputStream("img/entities/fire.png"));
            explosion_effect_sprite_sheet = ImageIO.read(new FileInputStream("img/entities/explosion_area.png"));
            bullet_1 = ImageIO.read(new FileInputStream("img/entities/bullet.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        bullet_effects_sprites = super.set_frames(bullet_effect_sprite_sheet,bullet_effect_width,bullet_effect_height);
        explosion_effect_sprites = super.set_frames(explosion_effect_sprite_sheet,explosion_effect_width,explosion_effect_height);

    }

    public void fire_bullet_1(Graphics2D g, Tank tank){

        bullet_1_x_cordinate = tank.barrel_front_cordinate_x;
        bullet_1_y_cordinate = tank.barrel_front_cordinate_y;
        JukeBox.play("fire");
        bullet_is_moving=true;

        for (int i = 0; i<12; i++){

            super.set_animation(1,g,bullet_effects_sprites,tank.barrel_front_cordinate_x,tank.barrel_front_cordinate_y-10);
        }

    }
    public void draw(Graphics2D g , Tank tank_fire ,Tank victim){

        int tank_barrel_rotate;
        tank_barrel_rotate = 10 * tank_fire.barrel_rotate;
        tank = new Rectangle(victim.tank_back_cordinate, Play.map_cordinates_y[victim.tank_back_cordinate+23] - 23,46,23);

        if(bullet_is_moving){

            explosion_effect_frame_loop = 0;

            bullet_1_x_cordinate += bullet_1_speed * Math.cos(Math.toRadians(tank_barrel_rotate));
            bullet_1_y_cordinate -= bullet_1_speed * Math.sin(Math.toRadians(tank_barrel_rotate)) - gravity*gravity_loop;

            gravity_loop+=0.1;

            g.drawImage(bullet_1,bullet_1_x_cordinate,bullet_1_y_cordinate,null);

            if(bullet_1_x_cordinate > 750 || bullet_1_x_cordinate < -30 || bullet_1_y_cordinate < -30 || Play.map_poly.intersects(bullet_1_x_cordinate,bullet_1_y_cordinate,1,1)  || tank.intersects(bullet_1_x_cordinate,bullet_1_y_cordinate,5,5)){//bullet_1_y kordinatı

                /**
                 * @param random_fall merminin açacağı deliğin derinliğini tutan değişkendir.
                 * @param random_fall_optimization merminin açacağı deliğin çok keskin olmasını engellemek ve o deliğe tırtıklı doku kazandırmak için oluşturulmuş değişkendir.
                 */

                JukeBox.play("explosion");
                bullet_is_moving = false;
                gravity_loop=1;
                if(Play.map_poly.intersects(bullet_1_x_cordinate,bullet_1_y_cordinate,1,1) && bullet_1_x_cordinate < 720){
                    Random r = new Random();
                    int random_fall = r.nextInt(10);
                    for(int i=0;i<15;i++){
                        int random_fall_optimization = r.nextInt(3);
                        if(i == 14){
                            Play.map_cordinates_y[bullet_1_x_cordinate] = Play.map_cordinates_y[bullet_1_x_cordinate] + random_fall;
                        }
                        else{
                            Play.map_cordinates_y[bullet_1_x_cordinate-i] = Play.map_cordinates_y[bullet_1_x_cordinate] + random_fall+random_fall_optimization-i;
                            Play.map_cordinates_y[bullet_1_x_cordinate+i] = Play.map_cordinates_y[bullet_1_x_cordinate] + random_fall+random_fall_optimization-i;
                        }
                    }
                }

            }

        }
        else {
            if(explosion_effect_frame_loop < 21){
                if(Math.abs(tank_fire.tank_back_cordinate - bullet_1_x_cordinate) < 20 || Math.abs(tank_fire.tank_front_cordinate - bullet_1_x_cordinate) < 20){
                    tank_fire.tank_health-=1;
                }
                else if(Math.abs(victim.tank_back_cordinate - bullet_1_x_cordinate) < 20 || Math.abs(victim.tank_front_cordinate - bullet_1_x_cordinate) < 20){//kendini vurma
                    victim.tank_health-=1;
                }
                explosion_effect_frame_loop++;
                super.set_animation(2, g, explosion_effect_sprites, bullet_1_x_cordinate - explosion_effect_width / 2, bullet_1_y_cordinate - explosion_effect_height);
            }


        }
    }
}
