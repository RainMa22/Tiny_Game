package me.rainma22;
import me.rainma22.utils.coords;

import java.util.ArrayList;

public class gameTickThread extends Thread{
public byte TICK_SPEED=24;
private container c;
public gameTickThread(container c){
    this.c=c;
    start();
}
    byte b=0;
    @Override
    public void run() {
        super.run();
        double d=(1000/TICK_SPEED);
        long currentTime=System.currentTimeMillis();
        long pastTime=currentTime;
        System.out.println(d);
        while (true){
            currentTime=System.currentTimeMillis();
            while (currentTime-pastTime>=d){
                pastTime+=d;
                for (coords cs:c.bulletCords) {
                    cs.y -= 10;
                }
                for (coords cs:c.ebulletCords){
                    cs.y+=10;

                }
                if (b==TICK_SPEED){
                    for (coords cs:c.enemyCords){
                        cs.y+=10;
                    }
                }
                b++;
            }
        }
    }
}
