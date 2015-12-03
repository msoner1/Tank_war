package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by soner on 22.11.2015.
 */
public abstract class Entity {

    private BufferedImage[] sprites;

    private int animation_frame_speed[] = {1,1,1};
    private int animation_frame_img[] = {0,0,0};



    public BufferedImage[] set_frames(BufferedImage sprite_sheet,int width , int height){

        int sub_image_number = sprite_sheet.getWidth()/width;
        int colon = sprite_sheet.getHeight()/height;

        sprites= new BufferedImage[sub_image_number * colon];
        int k = 0;
        for(int j = 0; j<colon;j++) {

            for (int i = 0; i < sub_image_number; i++) {
                this.sprites[k] = sprite_sheet.getSubimage(i * width, j * height, width, height);
                k++;
            }
        }
        return sprites;
    }

    public void set_animation(int animation_number,Graphics2D g,BufferedImage[] sprites,int cordinates_x ,int cordinates_y){ //istenilen animasyonu yaratmasý için yenilenmeli(recursive) çalýþmalýdýr.

            if(animation_frame_img[animation_number] == sprites.length ){animation_frame_img[animation_number]=0;}
            else {

                animation_frame_speed[animation_number] = 1;
                g.drawImage(sprites[animation_frame_img[animation_number]], cordinates_x, cordinates_y, null);
                animation_frame_img[animation_number]++;

            }
            animation_frame_speed[animation_number]++;
    }
/*
    public boolean set_animation_once(Graphics2D g,BufferedImage[] sprites,int animation_speed , int cordinates_x ,int cordinates_y){ //bu metot bir defa çaðrýldýðýnda istenilen animasyonu yaratýr.

            g.drawImage(sprites[animation_frame_img_2], cordinates_x, cordinates_y, null);
            animation_frame_img_2++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (animation_frame_img_2 == sprites.length) {
                animation_frame_img_2 = 0;
                return true;
            }
            else {
            return set_animation_once(g, sprites,animation_speed, cordinates_x, cordinates_y);
            }
    }
*/
}
