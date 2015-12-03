package Entities;

import Manager.JukeBox;
import Map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by soner on 22.11.2015.
 */
public class Bullets extends Entity{

    private BufferedImage bullet_effect_sprite_sheet;
    private BufferedImage[] bullet_effects_sprites;
    private BufferedImage explosion_effect_sprite_sheet;
    private BufferedImage[] explosion_effect_sprites;
    public BufferedImage bullet_1;

    public int bullet_1_x_cordinate;
    public int bullet_1_y_cordinate;

    public static boolean bullet_is_moving;

    private final int bullet_effect_width = 24;
    private final int bullet_effect_height = 24;

    private final int explosion_effect_width = 73;
    private final int explosion_effect_height = 53;


    public Bullets(){

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
    public void draw(Graphics2D g , Tank tank){

        if(bullet_is_moving){

           if(tank.barrel_rotate == 0){
                bullet_1_x_cordinate+=10;
                bullet_1_y_cordinate+=1;
            }
           else if(tank.barrel_rotate == 1){

               if(tank.barrel_front_cordinate_x + 150 > bullet_1_x_cordinate){
                   bullet_1_x_cordinate+=15;
                   bullet_1_y_cordinate-=3;
               }
               else {
                   if(tank.barrel_front_cordinate_x + 200 > bullet_1_x_cordinate){
                       bullet_1_x_cordinate+=10;
                       bullet_1_y_cordinate-=1;
                   }
                   else {
                       if(tank.barrel_front_cordinate_x + 250 > bullet_1_x_cordinate){
                           bullet_1_x_cordinate+=5;
                           bullet_1_y_cordinate+=1;
                       }
                       else {
                           bullet_1_x_cordinate+=10;
                           bullet_1_y_cordinate+=3;
                       }

                   }
               }
           }
           else if(tank.barrel_rotate == 2){
               bullet_1_x_cordinate+=10;
               bullet_1_y_cordinate+=1;
           }
           else if(tank.barrel_rotate == 3){
               bullet_1_x_cordinate+=10;
               bullet_1_y_cordinate+=10;
           }
            else if(tank.barrel_rotate == 18){
                bullet_1_x_cordinate-=10;
                bullet_1_y_cordinate+=1;
            }


            g.drawImage(bullet_1,bullet_1_x_cordinate,bullet_1_y_cordinate,null);

            if(bullet_1_x_cordinate > 720 || bullet_1_x_cordinate < 0 || bullet_1_y_cordinate > 420 || bullet_1_y_cordinate == Map.cordinates_y[bullet_1_y_cordinate]){//bullet_1_y kordinatý
            JukeBox.play("explosion");
            bullet_is_moving = false;
        }

        }
        else {
            super.set_animation(2,g,explosion_effect_sprites,bullet_1_x_cordinate-explosion_effect_width/2,bullet_1_y_cordinate-explosion_effect_height);

        }
    }
}
