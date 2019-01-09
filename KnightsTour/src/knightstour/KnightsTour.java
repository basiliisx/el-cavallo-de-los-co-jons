/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class KnightsTour {
    
    JFrame fr;
    Tauler t;
    Cavall c;
    int dim;
    int idx = 1;

    public void generarTauler(int n) {
        t = new Tauler(n);
        t.dim = n;
        fr = new JFrame("Knight Tour");
        fr.setSize(80*n,80*n);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fr.add(t.getM()[j][i]);
            }
        }
        fr.setLayout(grid);
        fr.setVisible(true);
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
                    printSol();
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
                t.m[j][i].showValor();
            }
            System.out.println();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KnightsTour k = new KnightsTour();
        if (k.kt(8, 3, 5)) {
            k.printSol();
        } else {
            System.out.println("No hi ha solució");
        }
    }

}
