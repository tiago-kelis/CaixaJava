/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Caixa.Model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author tiago
 */
public class pintarTable extends DefaultTableCellRenderer{
    
    public pintarTable(){
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
       Color background = Color.getHSBColor(1,50,85);
       Object object = table.getValueAt(row, 0);
        try {
            
          int codigo = Integer.parseInt(object.toString());
          
          if(codigo == Math.floorMod(0, 0)){
              
              background = Color.GREEN;            
                           
          } 
          
          
        } catch (Exception e) {
        }
        
        
        label.setBackground(background);
         return label;
    }
    
        
    
}
