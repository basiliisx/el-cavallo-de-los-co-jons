/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author USUARIO
 */
public class Casella extends JButton {

    int valor, x, y;
    Color color;
    
    public Casella(Color color, int x, int y) {
        super();
        this.color = color;
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("a");
                    KnightsTour.situarCavall(x, y);
                } else if (e.getButton() == MouseEvent.BUTTON3){
                    System.out.println("b");
                    modCasella(KnightsTour.t);
                }

            }
        });
        this.setSize(80, 80);
        this.setBackground(color);
        valor = 0;
    }

    public Color getColor() {
        return color;
    }
    
    public int getValor() {
        return valor;
    }

    public void showValor() {
        String out = new String();
        this.setText(Integer.toString(valor));
    }

    public void modCasella(Tauler t){
        if(valor != -1){
            this.setBackground(Color.RED);
            valor = -1;
            t.subMov();
        }
        else{
            valor = 0;
            this.setBackground(color);
            t.addMov();
        }
    }
    
    public void setBg(){
        this.setBackground(color);
    }
    
    public void setCol(Color color) {
        this.setForeground(color);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

//    @Override
//    public void mouseClicked(MouseEvent me) {
//        System.out.println("a");
//        if (me.getButton() == MouseEvent.BUTTON1) {
//            System.out.println("b");
//        }
//    }
}
