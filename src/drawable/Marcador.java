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
public class Marcador implements Drawable {

    public static final int MAX_PUNT = 9;
    private int puntosIzda;
    private int puntosDcha;

    public final void initMarcador() {
        puntosIzda = 0;
        puntosDcha = 0;
    }

    public Marcador() {
        initMarcador();
    }

    public int getPuntosIzda() {
        return puntosIzda;
    }

    public int getPuntosDcha() {
        return puntosDcha;
    }

    public void addPuntoIzda() {
        puntosIzda++;
    }

    public void addPuntoDcha() {
        puntosDcha++;
    }

    public boolean acabado() {
        return puntosDcha >= MAX_PUNT || puntosIzda >= MAX_PUNT;
    }

    @Override
    public void render(Graphics g) {
        //marcador
        g.setFont(new Font("LucidaSans", Font.PLAIN, 40));
        g.setColor(Color.WHITE);
        g.drawString(""+getPuntosIzda()+"", 600 / 2 - 50, 50);
        g.drawString(""+getPuntosDcha()+"", 600 / 2 + 25, 50);
        int w = 5;
        int h = 15;
        int gap = 10;
        int ini = gap / 2; // por estetica, si no seria 0
        for (int i = 0; i < 500 / (h + gap); i++) {
            g.fillRect(600 / 2 - w / 2, ini, w, h);
            ini += h + gap;
        }
    }

    @Override
    public void add(Drawable d) {
        System.out.println("add: Un Marcador no puede tener Drawable");
    }

    @Override
    public void remove(Drawable d) {
        System.out.println("remove: Un Marcador no puede tener Drawable");
    }

    @Override
    public Drawable getChild(int i) {
        System.out.println("getChild: Un Marcador no puede tener Drawable");
        return null;
    }

    @Override
    public Drawable colision(Drawable d) {
        //System.out.println("colision: Un Marcador no colisiona");
        return null;
    }
}
