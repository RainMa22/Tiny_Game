package me.rainma22;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Main {
    public static void main(String[] args) {
	container c=new container();
    }
    class container{
        public BufferedImage player= new BufferedImage(3,2,BufferedImage.TYPE_INT_RGB);
        public BufferedImage bullet= new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        public container(){
            player.setRGB(2,1,new Color(255,255,255).getRGB());
            player.setRGB(1,2,new Color(255,255,255).getRGB());
            player.setRGB(3,2,new Color(255,255,255).getRGB());
            bullet.setRGB(1,1,new Color(255,255,255).getRGB());
        }
    }
}
