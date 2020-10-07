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
        temp1= (ArrayList<coords>) c.ebulletCords.clone();
        for (coords cs:c.bulletCords){
            for (coords css:c.ebulletCords){
                if (cs.x<=css.x+c.ebullet.getWidth()&&cs.y<=css.y+c.ebullet.getHeight()/2&&cs.x>=css.x-c.ebullet.getWidth()&&cs.y>=css.y-c.ebullet.getHeight()/2){
                    temp.remove(cs);
                    temp1.remove(css);
                }
            }
        }
        c.bulletCords= (ArrayList<coords>) temp.clone();
        c.ebulletCords= (ArrayList<coords>) temp1.clone();
        temp= (ArrayList<coords>) c.bulletCords.clone();
        temp1= (ArrayList<coords>) c.enemyCords.clone();
        for (coords cs:c.bulletCords){
            for (coords css:c.enemyCords){
                if (cs.x<=css.x+c.enemy.getWidth()/2+c.bullet.getWidth()&&cs.y<=css.y+c.enemy.getHeight()/2&&cs.x>=css.x-c.enemy.getWidth()/2&&cs.y>=css.y-c.enemy.getHeight()/2){
                    temp.remove(cs);
                    temp1.remove(css);
                }
            }
        }
        c.bulletCords= (ArrayList<coords>) temp.clone();
        c.enemyCords= (ArrayList<coords>) temp1.clone();
        temp= (ArrayList<coords>) c.ebulletCords.clone();
        for (coords cs:c.ebulletCords){
            coords css=c.playerCord;
                if (cs.x<=css.x+c.player.getWidth()/2+c.bullet.getWidth()&&cs.y<=css.y+c.player.getHeight()/2&&cs.x>=css.x-c.player.getWidth()/2&&cs.y>=css.y-c.player.getHeight()/2){
                    temp.remove(cs);
                    System.out.println("hit!");
                }
                c.ebulletCords= (ArrayList<coords>) temp.clone();
        }

    }
}
