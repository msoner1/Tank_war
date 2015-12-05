package Manager;

import java.awt.event.KeyEvent;

/**
 * Created by soner on 20.11.2015.
 */
public class Keys {
    public static final int NUM_KEYS = 9;

    public static boolean keyState[] = new boolean[NUM_KEYS];
    public static boolean prevKeyState[] = new boolean[NUM_KEYS];

    public static int UP = 0;
    public static int LEFT = 1;
    public static int DOWN = 2;
    public static int RIGHT = 3;
    public static int SPACE = 4;
    public static int ENTER = 5;
    public static int V = 6;//silah deðiþtirme tuþu
    public static int ADD = 7;
    public static int SUBTRACT = 8;

    public static void keySet(int i, boolean b) {
        if(i == KeyEvent.VK_UP) keyState[UP] = b;
        else if(i == KeyEvent.VK_LEFT) keyState[LEFT] = b;
        else if(i == KeyEvent.VK_DOWN) keyState[DOWN] = b;
        else if(i == KeyEvent.VK_RIGHT) keyState[RIGHT] = b;
        else if(i == KeyEvent.VK_SPACE) keyState[SPACE] = b;
        else if(i == KeyEvent.VK_ENTER) keyState[ENTER] = b;
        else if(i == KeyEvent.VK_V) keyState[V] = b;
        else if(i == KeyEvent.VK_ADD) keyState[ADD] = b;
        else if(i == KeyEvent.VK_SUBTRACT) keyState[SUBTRACT] = b;
    }

    public static void update() {
        for(int i = 0; i < NUM_KEYS; i++) {
            prevKeyState[i] = keyState[i];
        }
    }

    public static boolean isPressed(int i) {
        return keyState[i] && !prevKeyState[i];
    }

    public static boolean isDown(int i) {
        return keyState[i];
    }

}
