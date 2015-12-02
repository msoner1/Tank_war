package Main;

import Manager.GameStateManager;
import Manager.Keys;
import Manager.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by soner on 18.11.2015.
 */
public class GamePanel extends JPanel implements Runnable,KeyListener,MouseListener,MouseMotionListener {

    // �l��ler
    //Height pencere y�ksekli�i
    //Width pencere geni�li�i

    public static final int WIDTH = 720;
    public static final int HEIGHT = 420;

    //oyun d�ng�s�nde kullan�lacak de�i�kenler.
    private Thread thread;
    private boolean running;
    private final int FPS = 30;
    private final int TARGET_TIME = 1000 / FPS;

    // grafik �izimlerinde kullan�lan de�i�kenler
    private BufferedImage image;
    private Graphics2D g;

    // game state manager
    private GameStateManager gsm;

    public static int game_loop_tick=0;//oyun d�ng�s� her tickledi�inde artan de�i�ken.

    public GamePanel(){ //Jpanel yarat�yoruz.kurucumuz
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true); //default de�eride true olur.pencerenin odaklanabilirli�ini ayarlar.
        requestFocus();
    }

    // thread'e pencere haz�r oldu�unda ba�latma yollar.
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            addKeyListener(this);
            addMouseListener(this);
            addMouseMotionListener(this);
            thread = new Thread(this);
            thread.start();
        }
    }

    // add notifyde tan�mlanan therad burada �al���r.
    public void run() {

        init();

        long start;
        long elapsed;
        long wait;

        // game loop
        while(running) {

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = TARGET_TIME - elapsed / 1000000;
            if(wait < 0) wait = TARGET_TIME;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        }
        game_loop_tick++;

    }

    // initializes fields
    private void init() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, 1);
        g = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager();
    }

    // updates game
    private void update() {
        gsm.update();
        Keys.update();
    }

    // draws game
    private void draw() {
        gsm.draw(g);
    }

    // copy buffer to screen
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH , HEIGHT , null);
        g2.dispose();
    }

    // key event and mouse
    public void keyTyped(KeyEvent key) {}
    public void keyPressed(KeyEvent key) {
        Keys.keySet(key.getKeyCode(), true);
    }
    public void keyReleased(KeyEvent key) {
        Keys.keySet(key.getKeyCode(), false);
    }
    public void mouseClicked(MouseEvent e) {
        if(GameStateManager.currentState==1){
            Mouse.clicked(e,gsm);
        }
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {if(GameStateManager.currentState==1){
        try {
            Mouse.moved(e);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }}
}
