/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author USUARIO
 */
public class KnightsTour {

    private JFrame fr;
    public static Tauler t;
    private static Cavall c;
    private static int idx = 1;
    private ImageIcon icon;

    public void generarTauler(int n) {
        t = new Tauler(n);
        fr.setSize(80 * n, 80 * n);
        GridLayout grid = new GridLayout(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fr.add(t.getM()[j][i]);
            }
        }
        fr.setLayout(grid);
        fr.setVisible(true);
    }

    static public void situarCavall(int x, int y) {
        c = new Cavall(x, y);
        t.setM(idx, x, y);
        if (t.isClear()) {
            t.setClear(false);
            if (backtracking(c)) {
                printSol();
            } else {
                System.out.println("No hay solución");
            }
        } else {
            idx = 1;
            t.clearTauler();
            t.setClear(true);
        }
    }

    public static boolean backtracking(Cavall c) {
        idx++;
        Cavall aux = new Cavall(c.getPos().getX(), c.getPos().getY());
        for (Vector mov : Cavall.getMov()) {
            if (t.isValid(Vector.sumVector(c.getPos(), mov))) {
                aux.setPos(Vector.sumVector(c.getPos(), mov));
                if (t.hasSol(aux)) {
//                     printSol();
                    t.setM(idx, aux.getPos().getX(), aux.getPos().getY());
                    //System.out.println(idx);
                    backtracking(aux);
                }
            }
        }
        if (idx == t.getMovs()+ 1) {
            return true;
        }
        if (idx != t.getMovs() + 1) {
            idx--;
            t.setM(0, c.getPos().getX(), c.getPos().getY());
        }
        return false;
    }

    public void init() {
        fr = new JFrame("Knight Tour");
        icon = new ImageIcon("chess_icon.png");
        fr.setIconImage(icon.getImage());
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        definirTauler();

    }

    public void definirTauler() {
        Object[] possibilities = {"2", "3", "4", "5", "6", "7",
            "8", "9", "10"};
        String s = (String) JOptionPane.showInputDialog(
                fr,
                "Seleccioni un tauler de NxN",
                "Selecció de tauler",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                possibilities,
                "...");

//If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            int n = Integer.parseInt(s);
            generarTauler(n);
        }

    }

    public static void printSol() {
        for (int i = 0; i < t.getDim(); i++) {
            for (int j = 0; j < t.getDim(); j++) {
                if(t.getM()[j][i].getValor() != -1)
                t.getM()[j][i].showValor();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KnightsTour k = new KnightsTour();
        k.init();
    }
}
