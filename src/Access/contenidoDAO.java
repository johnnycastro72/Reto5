/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import Model.contenidoModel;
import Utils.ConnectionDB;
/**
 *
 * @author JCC
 */
public class contenidoDAO {
    private Connection conn = null;

    public ArrayList<contenidoModel> getAllContenidos() {
        ArrayList<contenidoModel> contenidos = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql          = "SELECT con_id, titulo FROM contenidos;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                contenidoModel modelo = new contenidoModel(result.getInt(1), result.getString(2));
                
                contenidos.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return contenidos;
    }
    
    public ArrayList<contenidoModel> getContenidosbyUser(String alias) {
        ArrayList<contenidoModel> contenidos = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql          = "SELECT contenidos.con_id, contenidos.titulo FROM transmisiones JOIN contenidos ON transmisiones.tra_con_id = contenidos.con_id WHERE transmisiones.tra_usu_alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                contenidoModel modelo = new contenidoModel(result.getInt(1), result.getString(2));
                
                contenidos.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return contenidos;
    }
    
    public contenidoModel getContenido(int id) {
        contenidoModel contenido = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "SELECT titulo FROM contenidos where con_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                contenido = new contenidoModel(id, result.getString(1));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return contenido;
    }

    public void insertContenido(contenidoModel contenido) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                   = "INSERT INTO contenido (con_id, titulo) VALUES (?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, contenido.getCon_id());
            statement.setString(2, contenido.getTitulo());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "El contenido fue agregado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void updateContenido(contenidoModel contenido) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                   = "UPDATE contenido SET titulo = ? WHERE con_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, contenido.getTitulo());
            statement.setInt(2, contenido.getCon_id());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "El contenido fue actualizado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void deleteContenido(int id) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                   = "DELETE FROM contenido WHERE con_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                JOptionPane.showMessageDialog(null, "El contenido fue borrado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
