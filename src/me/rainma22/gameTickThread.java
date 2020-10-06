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
                if (c.al.up){
                    c.playerCord.y -= 10;
                    if (c.playerCord.y < 0 + c.player.getHeight()) c.playerCord.y = 0 + c.player.getHeight();
                }
                if (c.al.down){
                    c.playerCord.y += 10;
                    if (c.playerCord.y > c.frame.getHeight() - 40 - c.player.getHeight())
                        c.playerCord.y = c.frame.getHeight() - 40 - c.player.getHeight();
                }
                if (c.al.left){
                    c.playerCord.x -= 10;
                    if(c.playerCord.x<0)c.playerCord.x+=c.frame.getWidth();
                }
                if (c.al.right){
                    c.playerCord.x += 10;
                    if(c.playerCord.x>c.frame.getWidth()-c.player.getWidth()/2)c.playerCord.x-=c.frame.getWidth();
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
