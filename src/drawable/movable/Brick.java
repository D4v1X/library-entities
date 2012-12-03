/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawable.movable;

import drawable.Drawable;
import drawable.Figura;
import drawable.Position;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author David
 */
@SuppressWarnings("serial")
public class Brick extends Figura implements Movable {

    private int dureza;
    private Color color;

    public Brick(int dureza, Position position, int width, int height) {
        super(position, width, height);
        this.dureza = dureza;
    }

    public int getDureza() {
        return dureza;
    }

    public void setDureza(int dureza) {
        this.dureza = dureza;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void render(Graphics g) {
        if (dureza == 1) {
            g.setColor(Color.WHITE);
        }
        if (dureza == 2) {
            g.setColor(Color.BLUE);
        }
        g.fillRect(this.getPosition().getX(), this.getPosition().getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void add(Drawable d) {
        System.out.println("add: Una brick no puede tener Drawable");
    }

    @Override
    public void remove(Drawable d) {
        System.out.println("remove: Una brick no puede tener Drawable");
    }

    @Override
    public Drawable getChild(int i) {
        System.out.println("getChild: Una brick no puede tener Drawable");
        return null;
    }

    @Override
    public Drawable colision(Drawable d) {
        Ball ball;
        ball = (Ball) d;

        // Por la Izquierda
        if ((ball.getBalldx() > 0) &&//Bola direccion derecha
                ((ball.getPosition().getX() + ball.getRadio() * 2) == this.getPosition().getX()) &&//Esta en el borde izquierdo o lo a rebasado
                ((ball.getPosition().getY() + ball.getRadio() * 2) >= this.getPosition().getY() &&//Esta mas abajo del borde superior
                (ball.getPosition().getY() <= (this.getPosition().getY() + this.getHeight())))) {//Esta mas arriba del borde inferior
            ball.setBalldx(-ball.getBalldx());
            return null;
        }
        // Por la derecha
        if ((ball.getBalldx() < 0) &&//Bola direccion izquierda
                ball.getPosition().getX() == (this.getPosition().getX() + this.getWidth()) &&//Esta en el borde derecho o lo a rebasado
                ((ball.getPosition().getY() + ball.getRadio() * 2) >= this.getPosition().getY()) &&//Esta por debajo de borde superior
                (ball.getPosition().getY() <= (this.getPosition().getY() + this.getHeight()))) {//Esta por encima del borde inferior
            ball.setBalldx(-ball.getBalldx());
            return null;
        }
        // Por abajo
        if ((ball.getBalldy() < 0) && //Bola direccion arriba
                (ball.getPosition().getY() == (this.getPosition().getY() + this.getHeight())) &&//Esta en el borde inferior o lo a rebasado
                ((ball.getPosition().getX() + ball.getRadio() * 2) >= this.getPosition().getX()) &&//Esta mas a la derecha del borde izquierdo
                (ball.getPosition().getX() <= (this.getPosition().getX() + this.getWidth()))) {//Esta mas a la izquierda del borde derecho
            ball.setBalldy(-ball.getBalldy());
            return null;
        }// Por Encima
        if (ball.getBalldy() > 0 && //Bola direccion abajo
                ((ball.getPosition().getY() + ball.getRadio() * 2) == this.getPosition().getY()) &&//Esta en el borde superior o lo ha rebasado
                ((ball.getPosition().getX() + ball.getRadio() * 2) >= this.getPosition().getX()) &&//Esta mas a la derecha que el borde izquierdo
                (ball.getPosition().getX() <= (this.getPosition().getX() + this.getWidth()))) {//Esta mas a la izquierda que el borde derecho
            ball.setBalldy(-ball.getBalldy());
            return null;
        }
        return null;
    }

    public void moveUp() {
        this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY() + 4));
    }

    public void moveDown() {
        this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY() - 4));
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
