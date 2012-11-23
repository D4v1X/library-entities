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
public class Ball extends Figura implements Movable {

    private int balldx, balldy;
    private int radio;
    private Color color;

    public Ball(int balldx, int balldy, int radio, Color color, Position position) {
        super(position, 2*radio, 2*radio);
        this.balldx = balldx;
        this.balldy = balldy;
        this.radio = radio;
        this.color = color;
    }

    public int getBalldx() {
        return balldx;
    }

    public void setBalldx(int balldx) {
        this.balldx = balldx;
    }

    public int getBalldy() {
        return balldy;
    }

    public void setBalldy(int balldy) {
        this.balldy = balldy;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
    //Operaciones()

    @Override
    public void move() {
        this.setPosition(new Position(this.getPosition().getX()+this.getBalldx(), 
                                      this.getPosition().getY()+this.getBalldy()));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(this.color);
        g.fillOval(
                this.getPosition().getX(), this.getPosition().getY(),
                this.getWidth(), this.getHeight());
    }

    @Override
    public void add(Drawable d) {
        System.out.println("add: Una bola no puede tener Drawable");
    }

    @Override
    public void remove(Drawable d) {
        System.out.println("remove: Una bola no puede tener Drawable");
    }

    @Override
    public Drawable getChild(int i) {
        System.out.println("getChild: Una bola no puede tener Drawable");
        return null;
    }

    @Override
    public Drawable colision(Drawable d) {
        Ball ball;
        ball = (Ball) d;
        int dx1 = ball.getBalldx();
        int dy1 = ball.getBalldy();
        int dx2 = this.getBalldx();
        int dy2 = this.getBalldy();
        int dx = ball.getPosition().getX() - this.getPosition().getX();
        int dy = ball.getPosition().getY() - this.getPosition().getY();
        int radio1 = ball.getRadio();
        int radio2 = this.getRadio();
        int radioTotal = radio1 + radio2;

        if (Math.pow(dx, 2) + Math.pow(dy, 2) <= Math.pow(radioTotal, 2)) {
            ball.setBalldx(dx2);
            ball.setBalldy(dy2);
            this.setBalldx(dx1);
            this.setBalldy(dy1);
            return null;
        }
        return null;
    }
}
