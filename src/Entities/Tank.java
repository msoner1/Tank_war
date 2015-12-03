package Entities;

import Manager.Keys;
import States.Play;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by soner on 22.11.2015.
 */
public class Tank extends Entity {

    private BufferedImage tank_sprite_sheet;
    private BufferedImage[] barrel;
    private BufferedImage[] tank_sprites;

    private final int width = 46;
    private final int height = 23;

    private final int tank_speed = 1;

    public int barrel_rotate = 0;
    private int barrel_x_cordinate;
    private int barrel_y_cordinate;

    private int[] map_cordinates_x;
    private int[] map_cordinates_y;

    private int tank_front_cordinate;
    private int tank_back_cordinate;

    public int barrel_front_cordinate_x;
    public int barrel_front_cordinate_y;

    private int animation_frame_speed = 3;

    public Tank(int[] map_cordinates_x,int[] map_cordinates_y){

        this.map_cordinates_x =map_cordinates_x;
        this.map_cordinates_y=map_cordinates_y;
        try {
            this.tank_sprite_sheet = ImageIO.read(new FileInputStream("img/entities/tank.png"));
            this.barrel = super.set_frames(ImageIO.read(new FileInputStream("img/entities/barrel.png")),46,46);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tank_sprites = super.set_frames(tank_sprite_sheet,width,height);
        Random random = new Random();

        tank_front_cordinate = random.nextInt(600)+50; //Tankýn belireceði kordinat


    }
    public void update(){
        tank_back_cordinate = tank_front_cordinate-width;
        barrel_y_cordinate = map_cordinates_y[tank_front_cordinate]-63;

        if(barrel_rotate == 0){
            barrel_x_cordinate = tank_back_cordinate + 28;
            barrel_front_cordinate_x=barrel_x_cordinate + 40;
            barrel_front_cordinate_y=barrel_y_cordinate + 40;

        }
        else if(barrel_rotate == 1){
            barrel_x_cordinate = tank_back_cordinate + 25;
            barrel_front_cordinate_x=barrel_x_cordinate + 38;
            barrel_front_cordinate_y=barrel_y_cordinate + 33;

        }
        else if(barrel_rotate == 2){
            barrel_x_cordinate = tank_back_cordinate + 24;
            barrel_front_cordinate_x=barrel_x_cordinate + 38;
            barrel_front_cordinate_y=barrel_y_cordinate + 26;

        }
        else if(barrel_rotate == 3){
            barrel_x_cordinate = tank_back_cordinate + 23;
            barrel_front_cordinate_x=barrel_x_cordinate + 33;
            barrel_front_cordinate_y=barrel_y_cordinate + 19;

        }
        else if(barrel_rotate == 4){
            barrel_x_cordinate = tank_back_cordinate + 22;
            barrel_front_cordinate_x=barrel_x_cordinate + 28;
            barrel_front_cordinate_y=barrel_y_cordinate + 12;

        }
        else if(barrel_rotate == 5){
            barrel_x_cordinate = tank_back_cordinate + 21;
            barrel_front_cordinate_x=barrel_x_cordinate + 20;
            barrel_front_cordinate_y=barrel_y_cordinate + 5;

        }
        else if(barrel_rotate == 6){
            barrel_x_cordinate = tank_back_cordinate + 20;
            barrel_front_cordinate_x=barrel_x_cordinate + 15;
            barrel_front_cordinate_y=barrel_y_cordinate - 2;

        }
        else if(barrel_rotate == 7){

            barrel_x_cordinate = tank_back_cordinate + 19;
            barrel_front_cordinate_x=barrel_x_cordinate + 10;
            barrel_front_cordinate_y=barrel_y_cordinate - 9;
        }
        else if(barrel_rotate == 8){
            barrel_x_cordinate = tank_back_cordinate + 18;
            barrel_front_cordinate_x=barrel_x_cordinate + 3;
            barrel_front_cordinate_y=barrel_y_cordinate - 13;

        }
        else if(barrel_rotate == 9){
            barrel_x_cordinate = tank_back_cordinate + 17;
            barrel_front_cordinate_x=barrel_x_cordinate - 7;
            barrel_front_cordinate_y=barrel_y_cordinate - 13;

        }
        else if(barrel_rotate == 10){
            barrel_x_cordinate = tank_back_cordinate + 10;
            barrel_front_cordinate_x=barrel_x_cordinate - 12;
            barrel_front_cordinate_y=barrel_y_cordinate - 13;

        }
        else if(barrel_rotate == 11){
            barrel_x_cordinate = tank_back_cordinate+2;
            barrel_front_cordinate_x=barrel_x_cordinate - 18;
            barrel_front_cordinate_y=barrel_y_cordinate - 9;

        }
        else if(barrel_rotate == 12){
            barrel_x_cordinate = tank_back_cordinate -8;
            barrel_front_cordinate_x=barrel_x_cordinate - 14;
            barrel_front_cordinate_y=barrel_y_cordinate - 2;

        }
        else if(barrel_rotate == 13){
            barrel_x_cordinate = tank_back_cordinate -15;
            barrel_front_cordinate_x=barrel_x_cordinate - 17;
            barrel_front_cordinate_y=barrel_y_cordinate + 5;

        }
        else if(barrel_rotate == 14){
            barrel_x_cordinate = tank_back_cordinate - 20;
            barrel_front_cordinate_x=barrel_x_cordinate - 22;
            barrel_front_cordinate_y=barrel_y_cordinate + 10;

        }
        else if(barrel_rotate == 15){
            barrel_x_cordinate = tank_back_cordinate - 25;
            barrel_front_cordinate_x=barrel_x_cordinate - 22;
            barrel_front_cordinate_y=barrel_y_cordinate + 16;

        }
        else if(barrel_rotate == 16){
            barrel_x_cordinate = tank_back_cordinate - 28;
            barrel_front_cordinate_x=barrel_x_cordinate - 15;
            barrel_front_cordinate_y=barrel_y_cordinate + 26;

        }
        else if(barrel_rotate == 17){
            barrel_x_cordinate = tank_back_cordinate - 32;
            barrel_front_cordinate_x=barrel_x_cordinate - 22;
            barrel_front_cordinate_y=barrel_y_cordinate + 33;

        }
        else if(barrel_rotate == 18){
            barrel_x_cordinate = tank_back_cordinate - 35;
            barrel_front_cordinate_x=barrel_x_cordinate - 20;
            barrel_front_cordinate_y=barrel_y_cordinate + 40;

        }

    }

    public void draw(Graphics2D g){
        g.drawImage(tank_sprites[0], tank_back_cordinate, map_cordinates_y[tank_front_cordinate] - height, null);
        draw_barrel(g);
    }

    public void move(Graphics2D g){ //animasyon oluþturur.

        if(!Bullets.bullet_is_moving) {
            if (!Keys.isDown(Keys.LEFT) && !Keys.isDown(Keys.RIGHT)) {
            } else {
                super.set_animation(0,g, tank_sprites, tank_back_cordinate, map_cordinates_y[tank_front_cordinate] - height);
            }
        }
    }
    public void set_Right(Tank tank){

            if (map_cordinates_x[720] < barrel_front_cordinate_x || map_cordinates_x[720] < tank_back_cordinate || map_cordinates_x[720] < tank_front_cordinate) {
            } else {
                if (barrel_front_cordinate_x == tank.tank_back_cordinate) {
                } else {
                    tank_front_cordinate+=tank_speed;
                }
            }

    }
    public void set_Left(Tank tank){
            if (map_cordinates_x[0] > barrel_front_cordinate_x || map_cordinates_x[0] > tank_back_cordinate || map_cordinates_x[0] > tank_front_cordinate) {
            } else {
                if (tank_back_cordinate == tank.barrel_front_cordinate_x) {
                }
                else {
                    tank_front_cordinate-=tank_speed;
                }
            }

    }
    private void draw_barrel(Graphics2D g){

        g.drawImage(barrel[barrel_rotate],barrel_x_cordinate,barrel_y_cordinate,null);

    }
    public void set_Up(){
            if (barrel_rotate == 18) {

            } else {
                barrel_rotate++;
            }

    }
    public void set_Down(){
            if (barrel_rotate == 0) {

            } else {
                barrel_rotate--;
            }
    }

}
