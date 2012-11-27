/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nodrawable;

import java.io.Serializable;

/**
 *
 * @author davidsantiagobarrera
 */
public class Score implements Serializable {

    private String  id;
    private double time;
    private String modo;

    public Score() {
        this.time = 0;
        this.id = "Sin asignar";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
}
