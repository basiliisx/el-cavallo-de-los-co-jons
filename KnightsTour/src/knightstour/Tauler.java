/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.awt.Color;

/**
 *
 * @author USUARIO
 */
public class Tauler {

    private Casella[][] m;
    private int dim, movs;
    private boolean clear;
    
    
    public Tauler(int n) {
        clear = true;
        boolean black = true;
        dim = n;
        movs = dim*dim;
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

    public int getMovs() {
        return movs;
    }

    public void addMov(){
        movs++;
    }
    
    public void subMov(){
        movs--;
    }
    
    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

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

    public int getM(int x, int y) {
        return m[x][y].getValor();
    }

    public void setM(int val, int x, int y) {
        m[x][y].setValor(val);
    }

    public boolean isValid(Vector v) {
        if (v.getX() >= 0 && v.getY() >= 0 && v.getX() < dim && v.getY() < dim) {
            return getM(v.getX(), v.getY()) == 0;
        } else {
            return false;
        }
    }

    public Casella[][] getM() {
        return m;
    }

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
