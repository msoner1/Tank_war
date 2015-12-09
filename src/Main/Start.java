package Main;

import javax.swing.*;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Ana main baþlmama sýnýfýmýzdýr.
 */
public class Start {

    public static void main(String[] args){

        JFrame window = new JFrame("Tank War"); //pencerenin yaratýlmasý.

        window.add(new GamePanel()); // Jframe içine Jpanel ekledik.
        window.setIconImage(new ImageIcon("img/icon.png").getImage());//favicon ayarlanmasý

        window.setResizable(false); //oyunun penceresi yeniden boyutlandýrýlamayacak.
        window.pack();//paket boyut ayarlama

        window.setLocationRelativeTo(null); //pencereyi ortalar
        window.setVisible(true); //pencereyi gösterir.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
