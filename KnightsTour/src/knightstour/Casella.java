/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author USUARIO
 */
public class Casella extends JButton {

    int valor;

    public Casella(Color color) {
        super();
        this.setSize(80, 80);
        this.setBackground(color);
        valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void showValor() {
        String out = new String();
        this.setText(Integer.toString(valor));
    }

    public void setCol(Color color) {
        this.setForeground(color);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
