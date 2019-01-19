/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.awt.Color;

/**
 * Aquesta clase representa un tauler d'escacs n*n, implementat amb una matriu
 * de objectes Casella
 *
 * @author Jiménez Sánchez, Pablo
 */
public class Tauler {

    private Casella[][] m;
    private int dim, movs;
    private boolean clear;

    /**
     * Constructor de Tauler que crea la matriu de Casella i initzialitza
     * individualmente cadascuna
     *
     * @param n
     */
    public Tauler(int n) {
        clear = true;
        boolean black = true;
        dim = n;
        movs = dim * dim;
        m = new Casella[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (black) {
                    m[j][i] = new Casella(Color.black, j, i);
                    m[j][i].setCol(Color.white);
                } else {
                    m[j][i] = new Casella(Color.white, j, i);
                    m[j][i].setCol(Color.black);
                }
                black = !black;
            }
            if (dim % 2 == 0) {
                black = !black;
            }
        }
    }

    /**
     * Getter dels moviments necesaris
     *
     * @return int movs
     */
    public int getMovs() {
        return movs;
    }

    /**
     * Afegeix un moviment més per completar el recorregut
     */
    public void addMov() {
        movs++;
    }

    /**
     * Sostreu un moviment menys per completar el recorregut
     */
    public void subMov() {
        movs--;
    }

    /**
     * Getter de la dimensió del tauler
     *
     * @return int dim
     */
    public int getDim() {
        return dim;
    }

    /**
     * Setter de la dimensió del tauler
     *
     * @param dim la nova dimensió
     */
    public void setDim(int dim) {
        this.dim = dim;
    }

    /**
     * Getter del booleà que indica si el tauler està net
     *
     * @return boolean clear
     */
    public boolean isClear() {
        return clear;
    }

    /**
     * Setter del booleà clear
     *
     * @param clear
     */
    public void setClear(boolean clear) {
        this.clear = clear;
    }

    /**
     * Neteja el tauler
     */
    public void clearTauler() {
        movs = dim * dim;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                m[j][i].setValor(0);
                m[j][i].setText("");
                m[j][i].setBg();
            }
        }
    }

    /**
     * Getter del valor d'una Casella de la matriu
     * @param x posició respecte a x
     * @param y posició respecte a y
     * @return valor de la Casella
     */
    public int getM(int x, int y) {
        return m[x][y].getValor();
    }

    /**
     * Setter del valor d'una Casella de la matriud
     * @param val nou valor
     * @param x posició respecte a x
     * @param y posició respecte a y
     */
    public void setM(int val, int x, int y) {
        m[x][y].setValor(val);
    }

    /**
     * Funció que revisa si una Casella pot ser visitada
     * @param v Posició de la Casella
     * @return 
     */
    public boolean isValid(Vector v) {
        if (v.getX() >= 0 && v.getY() >= 0 && v.getX() < dim && v.getY() < dim) {
            return getM(v.getX(), v.getY()) == 0;
        } else {
            return false;
        }
    }

    /**
     * Getter de la matriud de Casella
     * @return Casella[][] m
     */
    public Casella[][] getM() {
        return m;
    }

    /**
     * Funció de poda que verifica que totes les Casella poden ser visitades
     * @param c Cavall actual
     * @return estat del tauler
     */
    public boolean hasSol(Cavall c) {
        if (dim < 0) {
            return true;
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (m[j][i].getValor() == 0) {
                    Vector aux = new Vector(j, i);
                    for (int k = 0; k < Cavall.getMov().length; k++) {
                        if (isValid(Vector.sumVector(aux, Cavall.getMov()[k])) || ((c.getPos().getX() == j) && c.getPos().getY() == i)) {
                            break;
                        }
                        if (k == Cavall.getMov().length - 1) {
                            // System.out.println("a");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
