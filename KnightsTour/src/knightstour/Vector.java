/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

/**
 * Clase que representa un vector en dues dimensions
 *
 * @author Jiménez Sánchez, Pablo
 */
public class Vector {

    private int x;
    private int y;

    /**
     * Constructor del vector
     * @param x posició x del vector
     * @param y posició y del vector
     */
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Getter d'x
     * @return x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Setter d'x
     * @param x nova x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter d'y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter d'y
     * @param y nova y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Mètpde que realitza una suma de dos vectors i retorna la suma com un nou vector
     * @param v1
     * @param v2
     * @return 
     */
    public static Vector sumVector(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

}
