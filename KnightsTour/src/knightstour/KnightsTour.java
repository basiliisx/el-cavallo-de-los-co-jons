/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.awt.GridLayout;
import javax.swing.*;

/**
 * Programa que resol el problema de la ruta del cavall 
 * amb un esquema de backtracking en un tauler de n*n
 * on n varia desde 2 fins a 10
 * 
 * @author Jiménez Sánchez, Pablo
 */
public class KnightsTour {

    private JFrame fr;
    public static Tauler t;
    private static Cavall c;
    private static int idx = 1;
    private ImageIcon icon;

    /**
     * Genera un tauler de dimensió n*n
     * @param n longitud del tauler
     */
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

    /**
     * Situa el cavall i comença l'algorisme per trobar una solució si el tauler 
     * no mostra cap solució, i si en té fa una neteja del tauler
     *
     * @param x posició inicial del cavall respecte a x
     * @param y posició inicial del cavall respecte a y
     */
    static public void situarCavall(int x, int y) {
        if (t.isClear()) {
            c = new Cavall(x, y);
            t.setM(idx, x, y);
            t.getM()[x][y].setBg();
            t.setClear(false);
            if (backtracking(c)) {
                printSol();
            } else {
                System.out.println("No hay solución");
                idx = 1;
                t.clearTauler();
                t.setClear(true);
            }
        } else {
            idx = 1;
            t.clearTauler();
            t.setClear(true);
        }
    }

    /**
     * Mètode recursiu utilitzat per trobar si un tauler té una solució 
     * mitjançant un esquema de backtracking, probant tots el moviments que té
     * un cavall
     * @param c El cavall que s'utilitza per comprobar si el tauler té solució
     * @return Booleà que indica si el tauler té o no solució
     */
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
        if (idx == t.getMovs() + 1) {
            return true;
        }
        if (idx != t.getMovs() + 1) {
            idx--;
            t.setM(0, c.getPos().getX(), c.getPos().getY());
        }
        return false;
    }

    /**
     * Initzialització dels components gràfics d'aquest programa
     */
    public void init() {
        fr = new JFrame("Knight Tour");
        icon = new ImageIcon("chess_icon.png");
        fr.setIconImage(icon.getImage());
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        definirTauler();

    }

    /**
     *  Definició de la longitud d'un tauler n x n amb un JOptionPane
     */
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
        if ((s != null) && (s.length() > 0)) {
            int n = Integer.parseInt(s);
            generarTauler(n);
        }

    }

    /**
     * Imprimeix la solució per pantalla del tauler
     */
    public static void printSol() {
        for (int i = 0; i < t.getDim(); i++) {
            for (int j = 0; j < t.getDim(); j++) {
                if (t.getM()[j][i].getValor() != -1) {
                    t.getM()[j][i].showValor();
                }
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
