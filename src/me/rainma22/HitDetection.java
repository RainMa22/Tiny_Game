package me.rainma22;
import me.rainma22.utils.coords;
import java.util.ArrayList;

public class HitDetection{
    private container c;
    public HitDetection(container c){
        this.c=c;
    }
    private ArrayList<coords> temp,temp1;
    public void detect() {
        temp= (ArrayList<coords>) c.bulletCords.clone();
        temp1= (ArrayList<coords>) c.enemyCords.clone();
        for (coords cs:c.bulletCords){
            for (coords css:c.enemyCords){
                if (cs.x<=css.x+c.enemy.getWidth()/2&&cs.y<=css.y+c.enemy.getHeight()/2&&cs.x>=css.x-c.enemy.getWidth()/2&&cs.y>=css.y-c.enemy.getHeight()/2){
                    temp.remove(cs);
                    temp1.remove(css);
                }
                c.bulletCords= (ArrayList<coords>) temp.clone();
                c.enemyCords= (ArrayList<coords>) temp1.clone();
            }
        }

    }
}
