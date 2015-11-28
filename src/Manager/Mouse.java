package Manager;

import States.Menu;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by soner on 20.11.2015.
 * bu class sadece menu ekraný için özel yaratýlmýþtýr.Gamepanelden emir alýr.
 */
public class Mouse {

    private static boolean play_menu_option_sound=true;

    public static void clicked(MouseEvent e,GameStateManager gsm) {
        int x = e.getX();
        int y = e.getY();
        if(x<452 && x>268 && y<248 && y>200) { //play
            JukeBox.stop("menu_background");
            gsm.setState(GameStateManager.PLAY);
        }
        else if(x<452 && x>268 && y<302 && y>260) { //exit
            System.exit(0);
        }
    }

    public static void moved(MouseEvent e) throws IOException {
        int x = e.getX();
        int y = e.getY();
        if(x<452 && x>268 && y<248 && y>200) { //play
            if (play_menu_option_sound == true) {
                Menu.set_button_img(new FileInputStream("img/play_hover.png"),"play");
                JukeBox.play("menu_option");
                play_menu_option_sound = false;
            }
        }

        else if(x<452 && x>268 && y<302 && y>260) { //exit
            if (play_menu_option_sound == true) {
                Menu.set_button_img(new FileInputStream("img/exit_hover.png"),"exit");
                JukeBox.play("menu_option");
                play_menu_option_sound = false;
            }
        }
        else {
            Menu.set_button_img(new FileInputStream("img/exit.png"),"exit");
            Menu.set_button_img(new FileInputStream("img/play_button.png"),"play");
            play_menu_option_sound=true;
        }
    }

}
