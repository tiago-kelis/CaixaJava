
package br.com.Caixa.Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "a995359204A#$AAA");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }
}

  
   

   
     
    
    

