package States;

import Entities.Bullets;
import Entities.Tank;
import Manager.GameStateManager;
import Manager.JukeBox;
import Manager.Keys;
import Map.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Genel Oyun ekranýný Temsil Eder.
 */
public class Play extends GameState{

    private BufferedImage playing_image;
    private BufferedImage map_area_texture_img;
    private TexturePaint map_texture;

    public static Polygon map_poly;

    private BufferedImage dot;

    private BufferedImage Player1;
    private BufferedImage Player2;

    public static int who_win=0;

    private Tank tank1;
    private Tank tank2;

    private  Bullets bullets;

    private int sira;
    private boolean change_sira = false;
    private int fire = 0;

    private int[] map_cordinates_x;
    public static int[] map_cordinates_y;

    private int random_area;

    NumberFormat formatter = new DecimalFormat("#0.0");

    public Play(GameStateManager gsm) {
        super(gsm);
        init();
    }

    public void init() {

        Random random = new Random();
        random_area = random.nextInt(2)+2;//minumum 1 max 2

        JukeBox.load("music/playing_back.mp3", "battle_background");
        JukeBox.setVolume("battle_background", -10);
        JukeBox.loop("battle_background");

        JukeBox.load("sfx/fire.mp3", "fire");
        JukeBox.load("sfx/tank_move.mp3", "move");
        JukeBox.load("sfx/barrel_move.mp3", "barrel_move");
        JukeBox.load("sfx/explosion.mp3", "explosion");
        JukeBox.load("sfx/big_explosion.mp3", "big_explosion");
        JukeBox.setVolume("fire", +5);
        JukeBox.setVolume("explosion", +5);


        try {
            playing_image = ImageIO.read(new FileInputStream("img/playing_areas/area"+random_area+".jpg"));
            map_area_texture_img = ImageIO.read(new FileInputStream("img/playing_areas/map"+random_area+".png"));
            Player1 = ImageIO.read(new FileInputStream("img/player1.png"));
            Player2 = ImageIO.read(new FileInputStream("img/player2.png"));
            dot = ImageIO.read(new FileInputStream("img/dot.png"));
            map_texture = new TexturePaint(map_area_texture_img,new Rectangle(64,64));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (random_area == 2){
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
        tank2 = new Tank(map_cordinates_x,map_cordinates_y,tank1);

        bullets = new Bullets();

        sira = 1;
        change_sira = false;
    }

    public void update() {
        handleInput();
        tank1.update();
        tank2.update();
        if(tank1.tank_health == 0 || tank2.tank_health == 0 || tank1.tank_health < 0 || tank2.tank_health < 0){
            JukeBox.stop("battle_background");
            JukeBox.stop("barrel_move");
            JukeBox.stop("move");
            JukeBox.play("big_explosion");
            if(tank1.tank_health == 0 || tank1.tank_health < 0){who_win = 2;}
            else {who_win = 1;}
            gsm.setState(GameStateManager.FINISH);
        }

        map_poly = new Polygon(map_cordinates_x,map_cordinates_y,720);
        map_poly.addPoint(720, 420);
        map_poly.addPoint(0,420);
    }

    public void draw(Graphics2D g , Graphics2D g2) {

        g.setFont(new Font("Serif", Font.PLAIN, 18));

        g.drawImage(playing_image, 0, 0, null);
        g.setColor(Color.black);
        g2.setColor(Color.black);
        g2.setPaint(map_texture);
        g2.fill(map_poly);

        g.drawImage(Player1, 550, 25, null);
        g.drawImage(Player2, 550, 45, null);
        g.drawString(String.valueOf(tank1.tank_health), 635, 39);
        g.drawString(String.valueOf(tank2.tank_health), 635, 59);
        g.drawString("Your Bullet Speed = ", 10, 39);
        g.drawString("Your Selected Bullet = ", 10, 65);
        g.drawString(formatter.format(Bullets.bullet_speed), 160, 39);
        if(Bullets.selected_bullet == 1){
            g.drawString(Bullets.bullet_1_name, 175, 64);
        }
        else {
            g.drawString(Bullets.bullet_2_name, 175, 64);
        }

        tank1.draw(g);
        tank2.draw(g);

        if(change_sira && !Bullets.bullet_is_moving){
            if(sira == 1){sira=2;}
            else {sira=1;}
            change_sira = false;
        }

        if(sira == 1){

            g.drawImage(dot, 530, 25, 15, 15, null); //sýra belirten nokta

            bullets.draw(g,tank1,tank2);
            tank1.move(g);

            int previus_fire = fire; //fire deðerinin deðiþip deðiþmeyeceðini anlamak için burda o deðeri alýyoruz.

            if(fire==1){
                bullets.fire_bullet_1(g,tank1);
                fire = 0;
            }

            if(previus_fire != fire){ //fire deðeri deðiþmiþ demektir yani mermi ateþ aldý.
                change_sira = true;//sirayi deðiþtirmek için komut verdik;
            }

        }
        else {

            g.drawImage(dot, 530, 45, 15, 15, null); //sýra belirten nokta

            bullets.draw(g,tank2,tank1);
            tank2.move(g);
            int previus_fire = fire;  //fire deðerinin deðiþip deðiþmeyeceðini anlamak için burda o deðeri alýyoruz.

            if(fire==1){
                bullets.fire_bullet_1(g,tank2);
                fire = 0;
            }

            if(previus_fire != fire){  //fire deðeri deðiþmiþ demektir yani mermi ateþ aldý.
                change_sira = true;    //sirayi deðiþtirmek için komut verdik.
            }
        }
    }

    public void handleInput() {

        if(Keys.isDown(Keys.ADD) && !Bullets.bullet_is_moving){
            if(Bullets.bullet_speed < 20){
                Bullets.bullet_speed +=0.1;
            }


        }
        if(Keys.isDown(Keys.SUBTRACT) && !Bullets.bullet_is_moving){

            if(Bullets.bullet_speed > 3){
                Bullets.bullet_speed -=0.1;
            }
        }
        if(Keys.isPressed(Keys.SPACE) && !Bullets.bullet_is_moving){

            if(fire==0){fire=1;}
        }

        if(Keys.isDown(Keys.UP) && !Bullets.bullet_is_moving){
            if(!JukeBox.isPlaying("barrel_move")){JukeBox.play("barrel_move");}
            if(sira==1){tank1.set_Up();}
            else {tank2.set_Up();}
        }

        else if(Keys.isDown(Keys.DOWN) && !Bullets.bullet_is_moving){
            if(!JukeBox.isPlaying("barrel_move")){JukeBox.play("barrel_move");}
            if(sira==1){tank1.set_Down();}
            else {tank2.set_Down();}
        }

        else {
            JukeBox.stop("barrel_move");

        }

        if (Keys.isDown(Keys.LEFT) && !Bullets.bullet_is_moving){
            if(!JukeBox.isPlaying("move")){JukeBox.play("move");}
            if(sira==1){tank1.set_Left(tank2);}
            else {tank2.set_Left(tank1);}
        }

        else if (Keys.isDown(Keys.RIGHT) && !Bullets.bullet_is_moving){
            if(!JukeBox.isPlaying("move")){JukeBox.play("move");}
            if(sira==1){tank1.set_Right(tank2);}
            else {tank2.set_Right(tank1);}
        }

        else {
            JukeBox.stop("move");
        }
        if(Keys.isPressed(Keys.V) && !Bullets.bullet_is_moving){
            if(Bullets.selected_bullet == 1){
                Bullets.selected_bullet = 2;
            }
            else{
                Bullets.selected_bullet = 1;
            }
        }

    }
}
