package me.rainma22.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageResize {
    public static BufferedImage Scaled(BufferedImage bi,int newWidth,int newHeight){
        double scaleX=newWidth/bi.getWidth(),scaleY=newHeight/bi.getHeight();
        BufferedImage bi1=new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g= bi1.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g.scale(scaleX,scaleY);
        g.drawImage(bi,0,0,null);
        g.dispose();
        return bi1;
    }
}
