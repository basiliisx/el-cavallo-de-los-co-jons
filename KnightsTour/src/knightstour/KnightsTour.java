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
    int sol = 1;

    public void generarTauler(int n) {
        t = new Tauler(n);
        dim = n;
    }

    public void situarCavall(int x, int y) {
        c = new Cavall(x, y);
        t.setM(sol, x, y);
    }

    public void backtracking(Cavall c) {
        sol++;
        if (sol == dim * dim + 1) {
            return;
        }
        Cavall aux = new Cavall(c.getPos().getX(), c.getPos().getY());
        for (int i = 0; i < 8; i++) {
            if (isValid(Vector.sumVector(c.getPos(), Cavall.getMov()[i]))) {
                aux.setPos(Vector.sumVector(c.getPos(), Cavall.getMov()[i]));
                t.setM(sol, aux.getPos().getX(), aux.getPos().getY());
                backtracking(aux);
            }
        }
        if(sol != dim*dim +1){
            sol--;
            t.setM(0, c.getPos().getX(), c.getPos().getY());
        }
    }
    
    public void kt(int n, int posx, int posy){
        generarTauler(n);
        situarCavall(posx, posy);
        backtracking(c);
    }

    public void printSol(){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(t.getM(j, i));
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    
    public boolean isValid(Vector v) {
        if (v.getX() >= 0 && v.getY() >= 0 && v.getX() < dim && v.getY() < dim) {
            return t.getM(v.getX(), v.getY()) == 0;
        } else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KnightsTour k = new KnightsTour();
        k.kt(10, 0, 0);
        k.printSol();
    }

}
