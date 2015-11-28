package States;

import Manager.GameStateManager;
import Manager.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by soner on 19.11.2015.
 * Oyun bitiþi ekraný kimin kazandýðýnýn gösterilmesi.
 */
public class Finish extends GameState {

    private BufferedImage player1_win;
    private BufferedImage player2_win;


    public Finish(GameStateManager gsm) {
        super(gsm);

        try {
            player1_win = ImageIO.read(new FileInputStream("img/player1_win.png"));
            player2_win = ImageIO.read(new FileInputStream("img/player2_win.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics2D g) {
        if(Play.who_win == 1){
            g.drawImage(player1_win,0,0,null);
        }
        else {
            g.drawImage(player2_win,0,0,null);
        }

    }

    @Override
    public void handleInput() {

        if(Keys.isPressed(Keys.ENTER)){
            gsm.setState(GameStateManager.MENU);
        }

    }
}
