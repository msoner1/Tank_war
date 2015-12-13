package States;

import Manager.GameStateManager;
import java.awt.*;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Tüm sahnelerin ortak fonksiyonlarını bulunduran soyut sınıf.
 */
public abstract class GameState {
    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics2D g , Graphics2D g2);
    public abstract void handleInput();
}
