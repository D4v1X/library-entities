/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawable;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author davidsantiagobarrera
 */
public class Chronometer implements Drawable {

    double time; //in seconds
    double starttime;

    public Chronometer() {
        time = 0.0;
        starttime = -1;
    }

    public void start() {
        starttime = System.currentTimeMillis();
    }

    public double getTime() {
        if (starttime >= 0) {
            return (time + (System.currentTimeMillis() - starttime)) / 1000;
        } else {
            return time / 1000;
        }
    }

    public void stop() {
        if (starttime >= 0) {
            time = time + (System.currentTimeMillis() - starttime);
            starttime = -1;
        }
    }

    public void reset() {
        stop();
        time = 0.0;
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("LucidaSans", Font.PLAIN, 10));
        g.setColor(Color.WHITE);
        g.drawString("Tiempo: "+getTime()+"", 225, 10);
    }

    @Override
    public void add(Drawable d) {
    }

    @Override
    public void remove(Drawable d) {
    }

    @Override
    public Drawable getChild(int i) {
        return null;
    }

    @Override
    public Drawable colision(Drawable d) {
        return null;
    }
}
