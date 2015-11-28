package States;

import Entities.Bullets;
import Entities.Tank;
import Main.GamePanel;
import Manager.GameStateManager;
import Manager.JukeBox;
import Manager.Keys;
import Map.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by soner on 19.11.2015.
 * Genel oyun ekraný
 */
public class Play extends GameState{

    private BufferedImage playing_image;
    private BufferedImage map_area;

    private Tank tank1;
    private Tank tank2;

    private  Bullets bullets;

    private int sira = 1;
    public static int fire = 0;

    private int[] map_cordinates_x;
    private int[] map_cordinates_y;

    private int random_area;

    public Play(GameStateManager gsm) {
        super(gsm);
        init();
    }

    public void init() {

        Random random = new Random();
        random_area = random.nextInt(3)+1;//minumum 1 max 3

        //load music
        JukeBox.load("music/playing_back.mp3", "battle_background");
        JukeBox.setVolume("battle_background", -10);
        JukeBox.loop("battle_background");

        //load sfx
        JukeBox.load("sfx/fire.mp3", "fire");
        JukeBox.load("sfx/tank_move.mp3", "move");
        JukeBox.load("sfx/barrel_move.mp3", "barrel_move");
        JukeBox.load("sfx/explosion.mp3", "explosion");
        JukeBox.setVolume("fire", +5);
        JukeBox.setVolume("explosion", +5);


        try {
            playing_image = ImageIO.read(new FileInputStream("img/playing_areas/area"+random_area+".jpg"));
            map_area = ImageIO.read(new FileInputStream("img/playing_areas/map"+random_area+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (random_area == 1){
            Map1 map = new Map1();
            map_cordinates_x = map.get_map_cordinates_x();
            map_cordinates_y = map.get_map_cordinates_y();
        }
        else if (random_area == 2){
            Map2 map = new Map2();
            map_cordinates_x = map.get_map_cordinates_x();
            map_cordinates_y = map.get_map_cordinates_y();
        }
        else if (random_area == 3){
            Map3 map = new Map3();
            map_cordinates_x = map.get_map_cordinates_x();
            map_cordinates_y = map.get_map_cordinates_y();
        }

        tank1 = new Tank(map_cordinates_x,map_cordinates_y);
        tank2 = new Tank(map_cordinates_x,map_cordinates_y);

        bullets = new Bullets();

    }

    public void update() {
        handleInput();
        tank1.update();
        tank2.update();

    }

    public void draw(Graphics2D g) {
        if(fire != 1) {
            g.drawImage(playing_image, 0, 0, null);
            g.drawImage(map_area, 0, 248, null);
            tank1.draw(g);
            tank2.draw(g);
        }

        if(sira == 1){
            tank1.move(g);
            if(fire==1){
                if(bullets.fire_bullet_1(g,tank1)){fire=0;sira=2;}
            }

        }
        else {
            tank2.move(g);
            if(fire==1){
                if(bullets.fire_bullet_1(g, tank2)){fire=0;sira=1;}
            }
        }
    }

    public void handleInput() {

        if(Keys.isPressed(Keys.SPACE)){

            if(fire!=1){fire=1;}
        }

        if(Keys.isDown(Keys.UP)){
            if(!JukeBox.isPlaying("barrel_move")){JukeBox.play("barrel_move");}
            if(sira==1){tank1.set_Up();}
            else {tank2.set_Up();}
        }

        else if(Keys.isDown(Keys.DOWN)){
            if(!JukeBox.isPlaying("barrel_move")){JukeBox.play("barrel_move");}
            if(sira==1){tank1.set_Down();}
            else {tank2.set_Down();}
        }

        else {
            JukeBox.stop("barrel_move");

        }

        if (Keys.isDown(Keys.LEFT)){
            if(!JukeBox.isPlaying("move")){JukeBox.play("move");}
            if(sira==1){tank1.set_Left(tank2);}
            else {tank2.set_Left(tank1);}
        }

        else if (Keys.isDown(Keys.RIGHT)){
            if(!JukeBox.isPlaying("move")){JukeBox.play("move");}
            if(sira==1){tank1.set_Right(tank2);}
            else {tank2.set_Right(tank1);}
        }

        else {
            JukeBox.stop("move");
        }
    }
}
