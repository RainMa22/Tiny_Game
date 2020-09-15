package me.rainma22;

import javax.swing.*;

public class gThread extends Thread {
    private JPanel p;
    private long currentTime,pastTime;
    public gThread(JPanel p){
        this.p=p;
        currentTime=System.currentTimeMillis();
        pastTime=currentTime;
        start();
    }

    @Override
    public void run() {
        super.run();
        while(true){
            currentTime=System.currentTimeMillis();
            while (currentTime-pastTime>=(100/6)){
                p.repaint();
                pastTime+=(100/6);
            }
            try {
                sleep((pastTime+100/6)-currentTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
