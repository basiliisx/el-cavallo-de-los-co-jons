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
    
    public Tauler(int n) {
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
    
}
