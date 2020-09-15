package me.rainma22;
import javax.swing.*;
import java.awt.*;

import me.rainma22.utils.*;
public class Graphic extends JPanel {
    private container c;
    public Graphic(container c){
        this.c=c;
        this.setBounds(0,0,c.frame.getWidth(),c.frame.getHeight());
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(c.player,c.playerCord.x,c.playerCord.y, this);
        g.drawImage(c.player,c.playerCord.x+c.frame.getWidth(),c.playerCord.y, this);
        g.drawImage(c.player,c.playerCord.x-c.frame.getWidth(),c.playerCord.y, this);
        for (coords cs:c.bulletCords) {
            g.drawImage(c.bullet,cs.x,cs.y,null);
        }
        for (coords cs:c.enemyCords){
            g.drawImage(c.enemy,cs.x,cs.y,null);
        }
        for(coords cs:c.ebulletCords){
            g.drawImage(c.ebullet,cs.x,cs.y,null);
        }
        new gThread(this);
    }
}
