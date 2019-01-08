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

    public boolean hasSol(Cavall c) {
        if (dim < 6) {
            return true;
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (m[j][i] == 0) {
                    Vector aux = new Vector(j, i);
                    for (int k = 0; k < Cavall.getMov().length; k++) {
                        if (isValid(Vector.sumVector(aux, Cavall.getMov()[k]))||((c.getPos().getX() == j)&&c.getPos().getY() == i)) {
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
