package States;

import Main.GamePanel;
import Manager.GameStateManager;
import Manager.JukeBox;
import Manager.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Intro Sahnesi
 */
public class Intro extends GameState {

    /**
     * @param logo logo resmini içerir.
     * @param alpha þeffaflýk derecesidir.Her döngüde hesaplanarak bir animasyon oluþturulur.
     * @param ticks Oyun döngüsünün her dönüþünde artýrýlan deðiþkendir.
     * @param FADE_IN logonun ekranda belirirken bu sürenin kaç oyun döngüsü olacaðýný temsil eder.
     * @param LENGTH logonun ekranda kalma süresinin kaç oyun döngüsü olacaðýný temsil eder.
     * @param FADE_OUT logonun ekrandan kaybolurken bu sürenin kaç oyun döngüsü olacaðýný temsil eder.
     */

    private BufferedImage logo;

    private int alpha;
    private int ticks;

    private final int FADE_IN = 75;
    private final int LENGTH = 50;
    private final int FADE_OUT = 75;

    public Intro(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        ticks = 0;
        // load sfx
        JukeBox.load("sfx/intro_back.mp3", "intro");
        try {
            JukeBox.play("intro");
            logo = ImageIO.read(new FileInputStream("logo/logo.jpg"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        handleInput();
        ticks++;
        if(ticks < FADE_IN) {
            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
            if(alpha < 0) alpha = 0;
        }
        if(ticks > FADE_IN + LENGTH) {
            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if(alpha > 255) alpha = 255;
        }
        if(ticks > FADE_IN + LENGTH + FADE_OUT) {
            JukeBox.stop("intro");
            gsm.setState(GameStateManager.MENU);
        }
    }

    public void draw(Graphics2D g , Graphics2D g2) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.drawImage(logo, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }

    public void handleInput() {
        if(Keys.isPressed(Keys.ENTER)) {
            JukeBox.stop("intro");
            gsm.setState(GameStateManager.MENU);
        }
    }

}
