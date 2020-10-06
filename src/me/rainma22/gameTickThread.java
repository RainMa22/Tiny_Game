package me.rainma22;
import me.rainma22.utils.coords;

import java.util.ArrayList;

public class gameTickThread extends Thread{
public byte TICK_SPEED=24;
private container c;
private HitDetection hd;
public gameTickThread(container c){
    this.c=c;
    hd=new HitDetection(c);
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
                temp=(ArrayList<coords>) c.enemyCords.clone();
                for (coords cs:c.enemyCords){
                    cs.y+=2;
                    if (cs.y>=c.frame.getHeight()-c.enemy.getHeight()) temp.remove(cs);
                }
                c.enemyCords= (ArrayList<coords>) temp.clone();

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
                if (b==TICK_SPEED/2||b==TICK_SPEED){
                    double rand=Math.random();
                    if (rand<=5){
                        temp= (ArrayList<coords>) c.enemyCords.clone();
                        temp.add(new coords((int)(Math.random()*c.frame.getWidth()),0));
                        c.enemyCords= (ArrayList<coords>) temp.clone();
                    }

                    temp= (ArrayList<coords>) c.ebulletCords.clone();
                    for (coords cs:c.enemyCords){
                        temp.add(new coords(cs.x+ c.enemy.getWidth()/2,cs.y+c.enemy.getHeight()/2));
                    }
                    c.ebulletCords= (ArrayList<coords>) temp.clone();
                }
                hd.detect();
                if (b==TICK_SPEED){
                    b=0;
                }
                b++;
            }
        }
    }
}
