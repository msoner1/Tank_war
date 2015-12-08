package States;

import Manager.GameStateManager;

import java.awt.*;

/**
 * Created by soner on 19.11.2015.
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
