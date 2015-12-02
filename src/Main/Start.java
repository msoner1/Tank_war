package Main;

import javax.swing.*;

/**
 * Created by sono on 18.11.2015.
 */
public class Start {

    public static void main(String[] args){

        JFrame window = new JFrame("Tank War"); //pencerenin yarat�lmas�.

        window.add(new GamePanel()); // Jframe i�ine Jpanel ekledik.
        window.setIconImage(new ImageIcon("img/icon.png").getImage());//favicon ayarlanmas�

        window.setResizable(false); //oyunun penceresi yeniden boyutland�r�lamayacak.
        window.pack();//paket boyut ayarlama

        window.setLocationRelativeTo(null); //pencereyi ortalar
        window.setVisible(true); //pencereyi g�sterir.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
