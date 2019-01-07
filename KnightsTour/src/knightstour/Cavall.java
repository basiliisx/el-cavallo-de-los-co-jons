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
public class Cavall {

    private static Vector[] mov;
    private Vector pos;
    
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

    public static Vector[] getMov() {
        return mov;
    }

    public static void setMov(Vector[] mov) {
        Cavall.mov = mov;
    }

    public Vector getPos() {
        return pos;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

}
