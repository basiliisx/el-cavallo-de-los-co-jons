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
 * Clase que representa una casella del tauler 
 * @author Jiménez Sánchez, Pablo
 */
public class Casella extends JButton {

    int valor, x, y;
    Color color;
    
    /**
     * Constructo de la clase casella que a més initcialitza el listener
     * per rebre l'input del mouse
     * @param color color de la casella
     * @param x posició de la casella respecte a x
     * @param y posició de la casella respecte a y
     */
    public Casella(Color color, int x, int y) {
        super();
        this.color = color;
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    KnightsTour.situarCavall(x, y);
                } else if (e.getButton() == MouseEvent.BUTTON3){
                    modCasella(KnightsTour.t);
                }

            }
        });
        this.setSize(80, 80);
        this.setBackground(color);
        valor = 0;
    }

    /**
     * Getter del color de la casella
     * @return Color color
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Getter del valor de la casella
     * @return int valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * Mostra per pantalla el valor de la casella
     */
    public void showValor() {
        String out = new String();
        this.setText(Integer.toString(valor));
    }

    /**
     * Modifica la casella per bloquejarla o desbloquejarla en el tauler
     * @param t 
     */
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
    
    /**
     * Retorna al color original de la casella
     */
    public void setBg(){
        this.setBackground(color);
    }
    
    /**
     * Modifica el color del text de la casella
     * @param color el color desitjat per la casella
     */
    public void setCol(Color color) {
        this.setForeground(color);
    }
    
    /**
     * Setter del valor de la casella
     * @param valor el valor nou de la casella
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

}
