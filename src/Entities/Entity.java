package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Soyut sýnýftýr.Varlýklara miras vererek kullanýlýr.Varlýklara ait animasyon ve resim parçalama gibi iþlemlerde kullanýlýr.
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
}
