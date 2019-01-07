/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

/**
 *
 * @author USUARIO
 */
public class Vector {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static Vector sumVector(Vector v1, Vector v2){
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }
    
}
