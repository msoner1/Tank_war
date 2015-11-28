package Entities;

import Manager.JukeBox;
import Manager.Keys;
import States.Play;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by soner on 22.11.2015.
 */
public class Tank extends Entity {

    private BufferedImage sprite_image;
    private BufferedImage barrel;
    private BufferedImage[] sprites;

    private final int width = 46;
    private final int height = 23;

    private double barrel_rotate = 0.0;
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
            this.sprite_image = ImageIO.read(new FileInputStream("img/entities/tank.png"));
            this.barrel = ImageIO.read(new FileInputStream("img/entities/barrel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sprites = super.set_frames(sprite_image,width,height);
        Random random = new Random();

        tank_front_cordinate = random.nextInt(600)+50; //Tankýn belireceði kordinat


    }
    public void update(){
        tank_back_cordinate = tank_front_cordinate-width;
        barrel_x_cordinate = tank_back_cordinate + 28;
        barrel_y_cordinate = map_cordinates_y[tank_front_cordinate - 2] - 20;
        barrel_front_cordinate_x=tank_front_cordinate+22;
        barrel_front_cordinate_y=barrel_y_cordinate;
    }

    public void draw(Graphics2D g){
        g.drawImage(sprites[0], tank_back_cordinate, map_cordinates_y[tank_front_cordinate - 2] - height, null);
        draw_barrel(g);
    }

    public void move(Graphics2D g){ //animasyon oluþturur.

        if(!Keys.isDown(Keys.LEFT) && !Keys.isDown(Keys.RIGHT)){}
        else{
            super.set_animation(g,sprites,animation_frame_speed,tank_back_cordinate,map_cordinates_y[tank_front_cordinate-2] - height);
        }
    }
    public void set_Right(Tank tank){

        if(Play.fire == 0) {
            if (map_cordinates_x[720] < tank_front_cordinate + 30) {
            } else {
                if (barrel_front_cordinate_x == tank.tank_back_cordinate || barrel_front_cordinate_x == tank.tank_back_cordinate + 1) {
                } else {
                    tank_front_cordinate += 2;
                }
            }
        }

    }
    public void set_Left(Tank tank){
        if(Play.fire == 0) {
            if (map_cordinates_x[0] > tank_back_cordinate) {
            } else {
                if (tank_back_cordinate == tank.barrel_front_cordinate_x || tank_back_cordinate == tank.barrel_front_cordinate_x + 1) {
                }//kordinatlarý 2þer olarak deðiþtirdiðimiz için tek gelirse tutmasý için 1 ekledik
                else {
                    tank_front_cordinate -= 2;
                }
            }
        }
    }
    private void draw_barrel(Graphics2D g){
        BufferedImage img = new BufferedImage(46,46,BufferedImage.TYPE_INT_ARGB_PRE);
        AffineTransform transform=new AffineTransform();
        transform.rotate(Math.toRadians(barrel_rotate));
        AffineTransformOp op=new AffineTransformOp(transform,null);
        g.drawImage(op.filter(barrel,img),barrel_x_cordinate,barrel_y_cordinate,null);
    }
    public void set_Up(){
        if(Play.fire == 0) {
            if (barrel_rotate == -180) {

            } else {
                barrel_rotate -= 3;
            }
        }
    }
    public void set_Down(){
        if(Play.fire == 0) {
            if (barrel_rotate == 0) {

            } else {
                barrel_rotate += 3;
            }
        }
    }

}
