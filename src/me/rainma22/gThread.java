package me.rainma22;

import javax.swing.*;

public class gThread extends Thread {
    private JPanel p;
    public gThread(JPanel p){
        this.p=p;
        start();
    }

    @Override
    public void run() {
        super.run();
        p.repaint(100/6);
    }
}
