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
public class KnightsTour {

    Tauler t;
    Cavall c;
    int dim;
    int idx = 1;

    public void generarTauler(int n) {
        t = new Tauler(n);
        t.dim = n;
    }

    public void situarCavall(int x, int y) {
        c = new Cavall(x, y);
        t.setM(idx, x, y);
    }

    public boolean backtracking(Cavall c) {
        idx++;
        Cavall aux = new Cavall(c.getPos().getX(), c.getPos().getY());
        for (Vector mov : Cavall.getMov()) {
            if (t.isValid(Vector.sumVector(c.getPos(), mov))) {
                aux.setPos(Vector.sumVector(c.getPos(), mov));
                if (t.hasSol(aux)) {
                    t.setM(idx, aux.getPos().getX(), aux.getPos().getY());
                    //System.out.println(idx);
                    backtracking(aux);
                }
            }
        }
        if (idx == t.dim * t.dim + 1) {
            return true;
        }
        if (idx != t.dim * t.dim + 1) {
            idx--;
            t.setM(0, c.getPos().getX(), c.getPos().getY());
        }
        return false;
    }

    public boolean kt(int n, int posx, int posy) {
        generarTauler(n);
        situarCavall(posx, posy);
        return backtracking(c);
    }

    public void printSol() {
        for (int i = 0; i < t.dim; i++) {
            for (int j = 0; j < t.dim; j++) {
                System.out.print(t.getM(j, i));
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KnightsTour k = new KnightsTour();
        if (k.kt(7, 3, 0)) {
            k.printSol();
        } else {
            System.out.println("No hi ha solució");
        }
    }

}
