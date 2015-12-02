package Main;

import javax.swing.*;

/**
 * Created by soner on 18.11.2015.
 *
 * main fonksiyonumuz burada yer alýr ve ana baþlangýç classýmýz bu classdýr.
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
