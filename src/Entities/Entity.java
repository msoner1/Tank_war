package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by soner on 22.11.2015.
 */
public abstract class Entity {

    private BufferedImage[] sprites;

    private int animation_frame_speed = 1;
    private int animation_frame_img = 0;

    private int animation_frame_img_2 = 0;

    public BufferedImage[] set_frames(BufferedImage sprite_sheet,int width , int height){

        int sub_image_number = sprite_sheet.getWidth()/width;

        sprites= new BufferedImage[sub_image_number];
        for (int i = 0; i<sub_image_number; i++){
            this.sprites[i] = sprite_sheet.getSubimage(i*width , 0 ,width ,height);
        }
        return sprites;
    }

    public void set_animation(Graphics2D g,BufferedImage[] sprites,int animation_speed,int cordinates_x ,int cordinates_y){ //istenilen animasyonu yaratmasý için yenilenmeli(recursive) çalýþmalýdýr.

        if (animation_frame_speed== animation_speed) {
            if(animation_frame_img == sprites.length ){animation_frame_img=0;}
            else {

                animation_frame_speed = 1;
                g.drawImage(sprites[animation_frame_img], cordinates_x, cordinates_y, null);
                animation_frame_img++;

            }
        } else {
            animation_frame_speed++;
        }

    }

    public boolean set_animation(Graphics2D g,BufferedImage[] sprites,int cordinates_x ,int cordinates_y){ //bu metot bir defa çaðrýldýðýnda istenilen animasyonu yaratýr.

        g.drawImage(sprites[animation_frame_img_2], cordinates_x, cordinates_y, null);
        animation_frame_img_2++;
        if(animation_frame_img_2 == sprites.length){animation_frame_img_2=0;return true;}
        return set_animation(g, sprites, cordinates_x, cordinates_y);
    }

}
