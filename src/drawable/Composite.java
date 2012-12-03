/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawable;

import drawable.movable.Ball;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author David
 */
@SuppressWarnings("serial")
public class Composite implements Drawable {

    private List<Drawable> childDrawable = Collections.synchronizedList(new ArrayList<Drawable>());
    private int numBalls = 0;

    @Override
    public void render(Graphics g) {
        synchronized (childDrawable) {
            for (Drawable drawable : childDrawable) {
                drawable.render(g);
            }
        }
        //numero de Bolas
        g.setFont(new Font("LucidaSans", Font.PLAIN, 10));
        g.setColor(Color.WHITE);
        g.drawString("Num Balls = "+numBalls+"", 325, 10);
    }

    @Override
    public void add(Drawable drawable) {
        childDrawable.add(drawable);
        if (drawable instanceof Ball) {
            numBalls++;
        }
    }

    @Override
    public void remove(Drawable drawable) {
        childDrawable.remove(drawable);
        if (drawable instanceof Ball){
            numBalls--;
        }
    }

    @Override
    public Drawable getChild(int i) {
        return childDrawable.get(i);
    }

    @Override
    public Drawable colision(Drawable d) {
        Drawable objC = null;
        synchronized (childDrawable) {
            for (Drawable draw : childDrawable) {
                objC = draw.colision(d);
                if (objC != null){
                    return objC;
                }
            }
        }
        return objC;
    }

    public List<Drawable> getChildDrawable() {
        return childDrawable;
    }

    public void setChildDrawable(List<Drawable> childDrawable) {
        this.childDrawable = childDrawable;
    }
}
