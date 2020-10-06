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
        ArrayList<coords> temp;
        System.out.println(d);
        while (true){
            currentTime=System.currentTimeMillis();
            while (currentTime-pastTime>=d){
                pastTime+=d;
                temp= (ArrayList<coords>) c.bulletCords.clone();
                for (coords cs:c.bulletCords) {
                    cs.y -= 10;
                    if (cs.y<=0-c.bullet.getHeight()) temp.remove(cs);
                }
                c.bulletCords= (ArrayList<coords>) temp.clone();
                temp= (ArrayList<coords>) c.ebulletCords.clone();
                for (coords cs:c.ebulletCords){
                    cs.y+=10;
                    if (cs.y>=c.frame.getHeight()+c.ebullet.getHeight()) temp.remove(cs);
                }
                c.ebulletCords= (ArrayList<coords>) temp.clone();
                if (c.al.up){
                    c.playerCord.y -= 10;
                    if (c.playerCord.y < 0 + c.player.getHeight()) c.playerCord.y = 0 + c.player.getHeight();
                }
                if (c.al.down){
                    c.playerCord.y += 10;
                    if (c.playerCord.y > c.frame.getHeight() - 30-c.player.getHeight())
                        c.playerCord.y = c.frame.getHeight() -30- c.player.getHeight();
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
                    temp= (ArrayList<coords>) c.enemyCords.clone();
                    for (coords cs:c.enemyCords){
                        cs.y+=10;
                        if (cs.y>=c.frame.getHeight()+c.enemy.getHeight()) temp.remove(cs);
                    }
                    c.enemyCords= (ArrayList<coords>) temp.clone();
                    b=0;
                }
                b++;
            }
        }
    }
}
