package Main;

import javax.swing.*;

/**
 * Created by sono on 18.11.2015.
 */
public class Start {

    public static void main(String[] args){

        JFrame window = new JFrame("Tank War"); //pencerenin yaratılması.

        window.add(new GamePanel()); // Jframe içine Jpanel ekledik.
        window.setIconImage(new ImageIcon("img/icon.png").getImage());//favicon ayarlanması

        window.setResizable(false); //oyunun penceresi yeniden boyutlandırılamayacak.
        window.pack();//paket boyut ayarlama

        window.setLocationRelativeTo(null); //pencereyi ortalar
        window.setVisible(true); //pencereyi gösterir.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
