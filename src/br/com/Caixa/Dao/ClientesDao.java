
package br.com.Caixa.Dao;

import br.com.Caixa.Jdbc.ConnectionFactory;
import br.com.Caixa.Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class ClientesDao {
    
    private Connection cnx;
    
    public ClientesDao(){
        this.cnx =  new ConnectionFactory().getConnection();
    }
    
    
    
    public void cadastrarClientes(Clientes obj){
        try {
            String mysql = "insert into tb_clientes(nome, email, telefone, cep, celular) values (?, ?, ?, ?, ?)";
            
            PreparedStatement pStmt = cnx.prepareStatement(mysql);
            pStmt.setString(1, obj.getNome());
            pStmt.setString(2, obj.getEmail());
            pStmt.setString(3, obj.getTelefone());
            pStmt.setString(4, obj.getCep());
            pStmt.setString(5, obj.getCelular());
            
            pStmt.execute();
            pStmt.close();
            
            JOptionPane.showMessageDialog(null, "Clientes Cadastrado com Sucessso");
            
            
        } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Clientes" + erro);
        }
        
    }
    
    public List<Clientes> listarClientes(){
        try {
            List<Clientes> lista = new ArrayList<>();
            
            String mysql = "select * from tb_clientes";
            
             PreparedStatement pStmt = cnx.prepareStatement(mysql);
             ResultSet rs = pStmt.executeQuery();
             while(rs.next()){
                 Clientes obj = new Clientes();
                 obj.setId(rs.getInt("id"));
                 obj.setNome(rs.getString("nome"));
                 obj.setEmail(rs.getString("email"));
                 obj.setTelefone(rs.getString("telefone"));
                 obj.setCep(rs.getString("cep"));
                 obj.setCelular(rs.getString("celular"));
                 lista.add(obj);              
                 
             }
               return lista;
             
             
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: ao listar Clientes" + erro);
            return null;
        }
        
    }
    
    public void excluirClientes(Clientes obj){
          try {
            String mysql = "delete from tb_clientes where id = ?";
            
            PreparedStatement pStmt = cnx.prepareStatement(mysql);
            pStmt.setInt(1, obj.getId());
          
            pStmt.execute();
            pStmt.close();
            
            JOptionPane.showMessageDialog(null, "Clientes Excluíd com Sucessso");
            
            
        } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "Erro ao erro ao Excluir Clientes" + erro);
        }
        
        
    }
    
    public void editarClientes(Clientes obj){
        
         try {
            String mysql = "update tb_clientes set nome=?, email=?, telefone=?, cep=?, celular=? where id=?";
            
            PreparedStatement pStmt = cnx.prepareStatement(mysql);
            pStmt.setString(1, obj.getNome());
            pStmt.setString(2, obj.getEmail());
            pStmt.setString(3, obj.getTelefone());
            pStmt.setString(4, obj.getCep());
            pStmt.setString(5, obj.getCelular());
            pStmt.setInt(6, obj.getId());
            
            pStmt.execute();
            pStmt.close();
            
            JOptionPane.showMessageDialog(null, "Clientes Editado com Sucessso");
            
            
        } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "Erro ao Editar Clientes" + erro);
        }
        
        
    }
    
    
     
    public List<Clientes> buscarClienteNome(String nome){
        try {
            List<Clientes> lista = new ArrayList<>();
            
            String mysql = "select * from tb_clientes where nome like ?";
            
             PreparedStatement pStmt = cnx.prepareStatement(mysql);
             pStmt.setString(1, nome);
             ResultSet rs = pStmt.executeQuery();
             while(rs.next()){
                 Clientes obj = new Clientes();
                 obj.setId(rs.getInt("id"));
                 obj.setNome(rs.getString("nome"));
                 obj.setEmail(rs.getString("email"));
                 obj.setTelefone(rs.getString("telefone"));
                 obj.setCep(rs.getString("cep"));
                 obj.setCelular(rs.getString("celular"));
                 lista.add(obj);              
                 
             }
               return lista;
             
             
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: ao listar Clientes" + erro);
            return null;
        }
        
    }
    
    
}
