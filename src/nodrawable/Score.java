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

    private Integer score;
    private String  id;

    public Score() {
        this.score = 0;
        this.id = "Sin asignar";
    }

    public Integer getScore() {
        return score;
    }

    public String getScoreId() {
        return id;
    }

    public void setScoreId(String id) {
        this.id = id;
    }
}
