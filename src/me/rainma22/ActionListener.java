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
    public boolean up=false,down=false,left=false,right=false;
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_DOWN||keyEvent.getExtendedKeyCode()==KeyEvent.VK_S) {
            //System.out.println("Down Pressed");
            down=true;

        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_UP||keyEvent.getExtendedKeyCode()==KeyEvent.VK_W) {
            //System.out.println("Up Pressed");
            up=true;

        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_LEFT||keyEvent.getExtendedKeyCode()==KeyEvent.VK_A) {
            //System.out.println("left Pressed");
            left=true;

        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_RIGHT||keyEvent.getExtendedKeyCode()==KeyEvent.VK_D) {
            right=true;
            //System.out.println("right Pressed");

    } else if (keyEvent.getExtendedKeyCode()==KeyEvent.VK_SPACE){
            c.bulletCords.add(new coords(c.playerCord.x+c.player.getWidth()/2-c.bullet.getWidth()/2,c.playerCord.y ));
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_DOWN||keyEvent.getExtendedKeyCode()==KeyEvent.VK_S) {
            //System.out.println("Down Pressed");
            down=false;

        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_UP||keyEvent.getExtendedKeyCode()==KeyEvent.VK_W) {
            //System.out.println("Up Pressed");
            up=false;

        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_LEFT||keyEvent.getExtendedKeyCode()==KeyEvent.VK_A) {
            //System.out.println("left Pressed");
            left=false;

        } else if (keyEvent.getExtendedKeyCode() == KeyEvent.VK_RIGHT||keyEvent.getExtendedKeyCode()==KeyEvent.VK_D) {
            right=false;
            //System.out.println("right Pressed");

        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
            if (mouseEvent.getButton()==MouseEvent.BUTTON1){
                c.bulletCords.add(new coords(c.playerCord.x+c.player.getWidth()/2-15,c.playerCord.y));
            }
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
