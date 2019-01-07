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
public class Tauler {

    int[][] m;
    int dim;

    public Tauler(int n) {
        dim = n;
        m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[j][i] = 0;
            }
        }
    }

    public int getM(int x, int y) {
        return m[x][y];
    }

    public int[][] getM() {
        return m;
    }

    public void setM(int val, int x, int y) {
        m[x][y] = val;
    }

    public boolean isValid(Vector v) {
        if (v.getX() >= 0 && v.getY() >= 0 && v.getX() < dim && v.getY() < dim) {
            return getM(v.getX(), v.getY()) == 0;
        } else {
            return false;
        }
    }

    public boolean hasSol(Vector[] mov) {
        boolean sol;
        if (dim < 6) {
            return true;
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (m[j][i] == 0) {
                    Vector aux = new Vector(j, i);
                    sol = false;
                    for (int k = 0; k < mov.length; k++) {
                        if (isValid(Vector.sumVector(aux, mov[k]))) {
                            sol = true;
                        }
                        if(sol){
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

}
