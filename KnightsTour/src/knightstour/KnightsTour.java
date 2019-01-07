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
    int sol = 1;

    public void generarTauler(int n) {
        t = new Tauler(n);
        t.dim = n;
    }

    public void situarCavall(int x, int y) {
        c = new Cavall(x, y);
        t.setM(sol, x, y);
    }

    public void backtracking(Cavall c) {
        sol++;
        if (sol == t.dim * t.dim + 1) {
            return;
        }
        Cavall aux = new Cavall(c.getPos().getX(), c.getPos().getY());
        for (int i = 0; i < 8; i++) {
            if (t.isValid(Vector.sumVector(c.getPos(), Cavall.getMov()[i]))) {
                aux.setPos(Vector.sumVector(c.getPos(), Cavall.getMov()[i]));
                t.setM(sol, aux.getPos().getX(), aux.getPos().getY());
                if(t.hasSol(Cavall.getMov())){ 
                backtracking(aux);
                }
            }
        }
        if(sol != t.dim*t.dim +1){
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
        k.kt(9, 0, 0);
        k.printSol();
    }

}
