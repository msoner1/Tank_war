package States;

import Manager.GameStateManager;
import Manager.JukeBox;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Menu Sahnesi
 */
public class Menu extends GameState{

    private BufferedImage background_img;
    private static BufferedImage play_button_img;
    private static BufferedImage exit_button_img;


    public Menu(GameStateManager gsm) {super(gsm);}

    public void init() {

        // arkaplan muzik yükleme
        JukeBox.load("/music/main_menu.mp3", "menu_background");
        JukeBox.load("/sfx/menu_option.mp3", "menu_option");
        JukeBox.setVolume("menu_background", -5);
        JukeBox.setVolume("menu_option", -10);
        JukeBox.loop("menu_background");

        try {
            background_img = ImageIO.read(getClass().getResource("/img/main_back.jpg"));
            play_button_img = ImageIO.read(getClass().getResource("/img/play_button.png"));
            exit_button_img = ImageIO.read(getClass().getResource("/img/exit.png"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void set_button_img(String img,String button) throws IOException {
        if(button.equals("exit")){
            exit_button_img = ImageIO.read(Menu.class.getClass().getResource(img));
        }
        else if(button.equals("play")){
            play_button_img = ImageIO.read(Menu.class.getClass().getResource(img));
        }

    }


    public void update() {
        handleInput();
    }


    public void draw(Graphics2D g , Graphics2D g2) {
        g.drawImage(background_img,0,0,null);
        g.drawImage(play_button_img,268,200,null);
        g.drawImage(exit_button_img,268,260,null);

    }


    public void handleInput() {}

}
