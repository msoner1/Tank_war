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

    Graphics2D g2;

    private BufferedImage fire_effect_sprite_sheet;
    public BufferedImage bullet_1;
    private BufferedImage[] fire_effects_sprites;

    public int bullet_1_x_cordinate;
    public int bullet_1_y_cordinate;

    public final int bullet_1_speed=5;

    private final int fire_effect_width = 24;
    private final int fire_effect_height = 24;


    public Bullets(){
        try {
            fire_effect_sprite_sheet = ImageIO.read(new FileInputStream("img/entities/fire.png"));
            bullet_1 = ImageIO.read(new FileInputStream("img/entities/bullet.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        fire_effects_sprites = super.set_frames(fire_effect_sprite_sheet,fire_effect_width,fire_effect_height);

    }

    public boolean fire_bullet_1(Graphics2D g, Tank tank){
            g2=g;
            bullet_1_x_cordinate = tank.barrel_front_cordinate_x;
            bullet_1_y_cordinate = tank.barrel_front_cordinate_y;
            JukeBox.play("fire");
        return super.set_animation(g,fire_effects_sprites,tank.barrel_front_cordinate_x,tank.barrel_front_cordinate_y-10);

    }

}
