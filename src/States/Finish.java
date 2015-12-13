package States;

import Manager.GameStateManager;
import Manager.JukeBox;
import Manager.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Oyunun bitiş ekranı ve credit kısmı.
 */
public class Finish extends GameState {

    /**
     * @param player1_win 1. playerın kazanması durumunda ekrana çizilecek resimi temsil etmektedir.
     * @param player2_win 2. playerın kazanması durumunda ekrana çizilecek resimi temsil etmektedir.
     * @param developer Credit resmini temsil eder.
     * @param developer_position_x Credit resminin kaydırılması için x kordinatını tutar.
     * @param developer_position_y Credit resminin kaydırılması için y kordinatını tutar.
     */
    private BufferedImage player1_win;
    private BufferedImage player2_win;

    private BufferedImage developer;
    private int developer_position_x = 0;
    private int developer_position_y = 0;


    public Finish(GameStateManager gsm) {
        super(gsm);
        JukeBox.load("/music/victory.mp3", "victory");
        JukeBox.setVolume("victory", +5);

        try {
            player1_win = ImageIO.read(getClass().getResource("/img/player1_win.png"));
            player2_win = ImageIO.read(getClass().getResource("/img/player2_win.png"));
            developer = ImageIO.read(getClass().getResource("/img/developer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        JukeBox.play("victory");

    }

    @Override
    public void update() {
        handleInput();
        /**
         * Credit resminin kaydırılması.
         */
        if(developer_position_y != -2080 ){developer_position_y--;}
    }

    @Override
    public void draw(Graphics2D g , Graphics2D g2) {
        if(Play.who_win == 1){
            g.drawImage(player1_win,0,0,null);
        }
        else {
            g.drawImage(player2_win,0,0,null);
        }
        g.drawImage(developer,developer_position_x,developer_position_y,null);

    }

    @Override
    public void handleInput() {

        if(Keys.isPressed(Keys.ENTER)){
            JukeBox.stop("victory");
            gsm.setState(GameStateManager.MENU);
        }

    }
}
