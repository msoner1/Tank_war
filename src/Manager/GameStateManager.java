package Manager;

import States.Finish;
import States.GameState;
import States.Intro;
import States.Menu;
import States.Play;

import java.awt.*;

/**
 * Created by soner on 20.11.2015.
 */
public class GameStateManager {


    private GameState[] gameStates;
    public static int currentState;
    private int previousState;

    public static final int NUM_STATES = 4;
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int PLAY = 2;
    public static final int FINISH = 3;

    public GameStateManager() {

        JukeBox.init();

        gameStates = new GameState[NUM_STATES];
        setState(INTRO);

    }

    public void setState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        if(i == INTRO) {
            gameStates[i] = new Intro(this);
            gameStates[i].init();
        }
        else if(i == MENU) {
            gameStates[i] = new Menu(this);
            gameStates[i].init();
        }
        else if(i == PLAY) {
            gameStates[i] = new Play(this);
            gameStates[i].init();
        }
        else if(i == FINISH) {
            gameStates[i] = new Finish(this);
            gameStates[i].init();
        }
    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }


    public void update() {

        if(gameStates[currentState] != null) {
            gameStates[currentState].update();
        }

    }

    public void draw(Graphics2D g , Graphics2D g2) {

        if(gameStates[currentState] != null) {
            gameStates[currentState].draw(g,g2);
        }
    }
}
