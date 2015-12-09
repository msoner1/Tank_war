package Manager;

import States.Finish;
import States.GameState;
import States.Intro;
import States.Menu;
import States.Play;

import java.awt.*;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Oyunun mevcut sahnesini tutan ve sahne geçişlerinden sorumlu sınıf.Mevcut sahneyi tutması sayesinde o sahnenin gerekli metotlarına(update() , draw())
 * erişebiliyoruz.
 */
public class GameStateManager {

    /**
     * @param gameStates sahneleri barındıran dizidir.
     * @param currentState mevcut sahneyi tutan değişkendir.
     * @param previousState Bir önceki sahneyi tutan değişken.
     * @param NUM_STATES Kaç adet sahne olduğunu tutan değişken
     */

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

    /**
     *Sahnelerin geçişini ayarlayan fonksiyondur.
     */
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
