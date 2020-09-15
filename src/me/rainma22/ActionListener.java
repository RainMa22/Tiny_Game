package me.rainma22;

import me.rainma22.utils.coords;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionListener implements KeyListener, MouseListener {
    private container c;
    public ActionListener(container c){
        this.c=c;
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down Pressed");
            c.playerCord.y += 10;
            if (c.playerCord.y > c.frame.getHeight() - 40 - c.player.getHeight())
                c.playerCord.y = c.frame.getHeight() - 40 - c.player.getHeight();
        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up Pressed");
            c.playerCord.y -= 10;
            if (c.playerCord.y < 0 + c.player.getHeight()) c.playerCord.y = 0 + c.player.getHeight();
        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("left Pressed");
            c.playerCord.x -= 10;
            if(c.playerCord.x<0)c.playerCord.x+=c.frame.getWidth();
        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("right Pressed");
            c.playerCord.x += 10;
            if(c.playerCord.x>c.frame.getWidth()-c.player.getWidth()/2)c.playerCord.x-=c.frame.getWidth();
    } else if (keyEvent.getExtendedKeyCode()==KeyEvent.VK_SPACE){
            c.bulletCords.add(new coords(c.playerCord.x+c.player.getWidth()/2-15,c.playerCord.y));
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
