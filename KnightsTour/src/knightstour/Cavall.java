/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

/**
 * Classe que representa un cavall situat a un tauler
 * @author Jiménez Sánchez, Pablo
 */
public class Cavall {

    private static Vector[] mov;
    private Vector pos;
    
    /**
     * Constructor de la clase Cavall que initzialitza l'array de moviments i
     * situa al cavall a una posició x,y
     * @param x posició inicial del cavall respecte a x
     * @param y posició inicial del cavall respecte a y
     */
    public Cavall(int x, int y) {
        mov = new Vector[8];
        mov[0] = new Vector(-1, -2);
        mov[1] = new Vector(-1, 2);
        mov[2] = new Vector(1, -2);
        mov[3] = new Vector(1, 2);
        mov[4] = new Vector(-2, -1);
        mov[5] = new Vector(-2, 1);
        mov[6] = new Vector(2, -1);
        mov[7] = new Vector(2, 1);
        pos = new Vector(x, y);
    }
    
    /**
     * Getter del vector de moviments del cavall
     * @return Vector[] mov
     */
    public static Vector[] getMov() {
        return mov;
    }

    /**
     * Getter de la posició del cavall
     * @return Vector pos
     */
    public Vector getPos() {
        return pos;
    }

    /**
     * Setter de la posició del cavall
     * @param pos la nova posició del cavall
     */
    public void setPos(Vector pos) {
        this.pos = pos;
    }

}
