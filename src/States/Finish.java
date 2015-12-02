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
 * Created by soner on 19.11.2015.
 * Oyun bitiþi ekraný kimin kazandýðýnýn gösterilmesi.
 */
public class Finish extends GameState {

    private BufferedImage player1_win;
    private BufferedImage player2_win;

    private BufferedImage developer;
    private int developer_position_x = 0;
    private int developer_position_y = 0;


    public Finish(GameStateManager gsm) {
        super(gsm);
        JukeBox.load("music/victory.mp3", "victory");
        JukeBox.setVolume("victory", +5);

        try {
            player1_win = ImageIO.read(new FileInputStream("img/player1_win.png"));
            player2_win = ImageIO.read(new FileInputStream("img/player2_win.png"));
            developer = ImageIO.read(new FileInputStream("img/developer.png"));
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

<<<<<<< HEAD
        if(developer_position_y != -2080 ){developer_position_y--;}
        if(developer_position_y != -1580 ){developer_position_y--;}

=======
        if(developer_position_y != -1580 ){developer_position_y--;}
>>>>>>> parent of d99e091... Bug fix ve mermi modifiye edilmek Ã¼zere eklendi.
    }

    @Override
    public void draw(Graphics2D g) {
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
