/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawable;

import drawable.movable.Ball;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
@SuppressWarnings("serial")
public class Boundary extends Figura implements Drawable {

    public Boundary(Position position, int width, int height) {
        super(position, width, height);
    }

    //Operaciones
    @Override
    public void render(Graphics g) {
        ImageIcon fondo = new ImageIcon(getClass().getResource("/images/fondo.png"));
        g.drawImage(fondo.getImage(), 0, 0, null);
    }

    @Override
    public void add(Drawable d) {
        System.out.println("add: Una contorno no puede tener Drawable");
    }

    @Override
    public void remove(Drawable d) {
        System.out.println("remove: Una contorno no puede tener Drawable");
    }

    @Override
    public Drawable getChild(int i) {
        System.out.println("getChild: Una contorno no puede tener Drawable");
        return null;

    }

    @Override
    public Drawable colision(Drawable d) {
        Ball ball;
        ball = (Ball) d;
        int centroX = ball.getPosition().getX() + ball.getRadio();
        int centroY = ball.getPosition().getY() + ball.getRadio();
        int radio = ball.getRadio();

        if (centroX - radio <= this.getPosition().getX()) {
            // La pelota se salió a la izquierda del rectángulo 
            // ball.setBalldx(-ball.getBalldx());
            return d;
        }
        if (centroX + radio >= this.getWidth()) {
            // La pelota se salió a la derecha del rectángulo 
            // ball.setBalldx(-ball.getBalldx());
            return d;
        }
        if (centroY - radio <= this.getPosition().getY()) {
            // La pelota se salió por arriba del rectángulo 
            ball.setBalldy(-ball.getBalldy());
            return null;
        }
        if (centroY + radio >= this.getHeight()) {
            // La pelota se salió por abajo del rectángulo 
            ball.setBalldy(-ball.getBalldy());
            return null;
        }
        return null;
    }
}
