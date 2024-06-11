
package br.com.Caixa.Jdbc;

import javax.swing.JOptionPane;


public class TextConnection {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Connection ok");
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null, "Connection erro" + erro);
        }
    }
    
}
