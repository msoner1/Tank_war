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
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Oyun döngüsünün yer aldığı sınıftır.Oyun paneli oluşturulur.
 */
public class GamePanel extends JPanel implements Runnable,KeyListener,MouseListener,MouseMotionListener {

    /**
    * @param WIDTH oluşturulan pencere genişliğimizdir.
    * @param HEIGHT oluşturulan pencere yüksekliğimizdir.
    * @param running oyun döngüsünün sürekli dönmesini sağlayan değişken false değeri alması durumunda döngü işlemez.
    * @param FPS oyun döngüsünün yenilenme(döngü) süresini azaltan yada artıran değişken.Bu değişken artıkça oyun döngüsü hızlanır.Bakınız:(Frame Per Second)
    * @param TARGET_TIME 1 saniyeyi(1000 ms) FPS değişkenine bölerek oyun döngüsünü kaç milisaniye bekleteceğini anlayan değişken.
     */

    public static final int WIDTH = 720;
    public static final int HEIGHT = 420;

    //oyun döngüsünde kullanılacak değişkenler.
    private Thread thread;
    private boolean running;
    private final int FPS = 30;
    private final int TARGET_TIME = 1000 / FPS;

    // grafik çizimlerinde kullanılan değişkenler
    private BufferedImage image;
    private Graphics2D g;
    private Graphics2D g2;

    // sahnelerimizi kontrol eden sınıf
    private GameStateManager gsm;


    public GamePanel(){ //Jpanel yaratıyoruz.kurucumuz
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true); //default değeride true olur.pencerenin odaklanabilirliğini ayarlar.
        requestFocus();
    }

    //Jpanel hazır olduğunda bu fonksiyona gider.
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

    public void run() {

        /**
         * @param start her bir oyun döngüsünde işlemlere başlamadan önceki sistem saatini alan değişken.
         * @param elapsed her bir oyun döngüsünde işlemler bittikten sonraki sistem saatinden start değişkenini çıkarak işlemlerde ne kadar vakit harcandığını bulan değişken.
         * @param wait oyun döngüsünün bekletilme süresini diğer değişkenler vasıtasıyla bulan değişken.
         */

        init();

        long start;
        long elapsed;
        long wait;

        // oyun döngüsü
        while(running) {

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = TARGET_TIME - elapsed / 1000000; //nanotime türünü milisaniyeye çevirmek amacıyla 1000000 sayısına böldük.
            if(wait < 0) wait = TARGET_TIME;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * Genel olarak tüm sınıflarda kullanılan init() fonksiyonu bir kurucu fonksiyon gibi değişkenlerin atamalarını yapan gerekli dosyaları yükleyen işlevli
     * bir fonksiyondur.
     */
    private void init() {

        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, 1);
        g = (Graphics2D) image.getGraphics();
        g2 = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager();
    }

    /**
     * Oyunun değişkenlerini değiştirmek, klavye hareketlerini algılamak,resimleri değiştirmek gibi güncellenmesi gereken değerleri
     * sürekli kontrol ederek değiştiren fonksiyon.
     *
     * Buradaki kullanım game state manager'ın update fonksiyonuna gitmek üzere ayarlandı.Bunun sebebi ise o andaki aktif sahnenin update fonksiyonuna
     * gidilmek istenmesinden ötürüdür.
     */
    private void update() {
        gsm.update();
        Keys.update();
    }

    /**
     * Oyunun ekrana nesne çizdirmek amacıyla kullanılan fonksiyonu.
     *
     * Buradaki kullanım game state manager'ın draw fonksiyonuna gitmek üzere ayarlandı.Bunun sebebi ise o andaki aktif sahnenin draw fonksiyonuna
     * gidilmek istenmesinden ötürüdür.
     */
    private void draw() {
        gsm.draw(g,g2);
    }

    /**
     * Oyunun asıl ekrana nesne çizdiren fonksiyonu.
     *
     * Graphics2D değişkenleri ile verdiğimiz çiz komutlarını bir graphics değişkeninde toplayarak ekrana basar.
     */
    private void drawToScreen() {
        Graphics g3 = getGraphics();
        g3.drawImage(image, 0, 0, WIDTH , HEIGHT , null);
        g3.dispose();
    }

    /**
     * Implemente edilen klavye ve mause fonksiyonları
     */
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
