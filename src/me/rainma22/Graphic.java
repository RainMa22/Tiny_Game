package me.rainma22;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import me.rainma22.utils.*;

public class Graphic extends JPanel {
    private container c;
    public Graphic(container c){
        this.c=c;
        this.setBounds(0,0,c.frame.getWidth(),c.frame.getHeight());
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(c.player,c.playerCord.x,c.playerCord.y, this);
        g2d.drawImage(c.player,c.playerCord.x+c.frame.getWidth(),c.playerCord.y, this);
        g2d.drawImage(c.player,c.playerCord.x-c.frame.getWidth(),c.playerCord.y, this);
        for (coords cs:c.bulletCords) {
            g2d.drawImage(c.bullet,cs.x,cs.y,null);
        }
        for (coords cs:c.enemyCords){
            g2d.drawImage(c.enemy,cs.x,cs.y,null);
        }
        for(coords cs:c.ebulletCords){
            g2d.drawImage(c.ebullet,cs.x,cs.y,null);
        }
        new gThread(this);
    }
}
