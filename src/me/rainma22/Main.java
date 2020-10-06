package me.rainma22;
import me.rainma22.utils.ImageResize;
import me.rainma22.utils.coords;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
	container c=new container();
    }

}
class container{
    public JFrame frame=new JFrame("Tiny_Game");
    private Dimension avaliableSpace=Toolkit.getDefaultToolkit().getScreenSize();
    public BufferedImage player= new BufferedImage(3,2,BufferedImage.TYPE_INT_ARGB);
    public coords playerCord;
    public BufferedImage bullet= new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
    public ArrayList<coords> bulletCords=new ArrayList<>(0);
    public BufferedImage enemy=new BufferedImage(3,2,BufferedImage.TYPE_INT_ARGB);
    public ArrayList<coords> enemyCords=new ArrayList<>(0);
    public BufferedImage ebullet= new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
    public ArrayList<coords> ebulletCords=new ArrayList<>(0);
    public Graphic gRender=new Graphic(this);
    public ActionListener al;
    public container() throws IOException {
        player.setRGB(1,0,new Color(0, 0, 0).getRGB());
        player.setRGB(0,1,new Color(0,0,0).getRGB());
        player.setRGB(1,1,new Color(0,0,0).getRGB());
        player.setRGB(2,1,new Color(0,0,0).getRGB());
        enemy.setRGB(1,0,new Color(255,0,0).getRGB());
        enemy.setRGB(0,0,new Color(255,0,0).getRGB());
        enemy.setRGB(1,1,new Color(255,0,0).getRGB());
        enemy.setRGB(2,0,new Color(255,0,0).getRGB());
        bullet.setRGB(0,0,new Color(0,0,0).getRGB());
        ebullet.setRGB(0,0,new Color(255,0,0).getRGB());
        frame.setBounds(avaliableSpace.width/2-avaliableSpace.width/5,0,(avaliableSpace.width/5)*2,avaliableSpace.height-40);
        player= ImageResize.Scaled(player,frame.getWidth()/10,frame.getWidth()/15);
        playerCord=new coords(frame.getWidth()/2-(player.getWidth()/2),frame.getHeight()-40-player.getHeight());
        enemy=ImageResize.Scaled(enemy,frame.getWidth()/10,frame.getWidth()/15);
        bullet= ImageResize.Scaled(bullet,frame.getWidth()/30,frame.getWidth()/30);
        ebullet= ImageResize.Scaled(ebullet,frame.getWidth()/30,frame.getWidth()/30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(gRender);
        al=new ActionListener(this);
        frame.addKeyListener(al);
        frame.addMouseListener(al);
        new gameTickThread(this);
    }
}