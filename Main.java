package de.kalman.tibimeter;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){
        initUI();
    }

    private void initUI() {
        MyPanel myPanel = new MyPanel();
        add(myPanel);
        setTitle("Tibimeter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(760, 840);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        System.out.println("1");

        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}