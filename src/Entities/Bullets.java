package Entities;

import Manager.JukeBox;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by soner on 22.11.2015.
 */
public class Bullets extends Entity{

    private BufferedImage fire_effect_sprite_sheet;
    public BufferedImage bullet_1;
    private BufferedImage[] fire_effects_sprites;

    public int bullet_1_x_cordinate;
    public int bullet_1_y_cordinate;

    public static boolean bullet_is_moving;

    private final int fire_effect_width = 24;
    private final int fire_effect_height = 24;


    public Bullets(){
        bullet_is_moving=false;
        try {
            fire_effect_sprite_sheet = ImageIO.read(new FileInputStream("img/entities/fire.png"));
            bullet_1 = ImageIO.read(new FileInputStream("img/entities/bullet.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        fire_effects_sprites = super.set_frames(fire_effect_sprite_sheet,fire_effect_width,fire_effect_height);

    }

    public boolean fire_bullet_1(Graphics2D g, Tank tank){

            bullet_1_x_cordinate = tank.barrel_front_cordinate_x;
            bullet_1_y_cordinate = tank.barrel_front_cordinate_y;
            JukeBox.play("fire");
            bullet_is_moving=true;

        return super.set_animation(g,fire_effects_sprites,tank.barrel_front_cordinate_x,tank.barrel_front_cordinate_y-10);

    }
    public void draw(Graphics2D g , Tank tank){

        if(bullet_is_moving){

           if(tank.barrel_rotate == 0){
                bullet_1_x_cordinate+=10;
                bullet_1_y_cordinate+=1;
            }
            else if(tank.barrel_rotate == 18){   //tanklarýn rotate deðerleri static olunca ikiside deðiþiyor.
                bullet_1_x_cordinate-=10;
                bullet_1_y_cordinate+=1;
            }
            else {
                bullet_1_x_cordinate+=3;
                bullet_1_y_cordinate-=2;
            }

            g.drawImage(bullet_1,bullet_1_x_cordinate,bullet_1_y_cordinate,null);
            if(bullet_1_x_cordinate > 720 || bullet_1_x_cordinate < 0 || bullet_1_y_cordinate > 420 || bullet_1_y_cordinate < 0){//bullet_1_y kordinatý
                JukeBox.play("explosion");
                bullet_is_moving = false;
            }

        }
    }
}
