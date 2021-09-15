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
import Model.usuarioModel;
import Utils.ConnectionDB;
/**
 *
 * @author JCC
 */
public class usuarioDAO {
    private Connection conn = null;

    public ArrayList<usuarioModel> getAllUsuarios() {
        ArrayList<usuarioModel> usuarios = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql          = "SELECT usu_alias, usu_nombre, usu_apellido, usu_email, usu_celular, usu_password, usu_nacimiento  FROM usuarios;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                usuarioModel modelo = new usuarioModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
                
                usuarios.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return usuarios;
    }
    
    public usuarioModel getUsuario(String alias) {
        usuarioModel usuario = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "SELECT usu_nombre, usu_apellido, usu_email, usu_celular, usu_password, usu_nacimiento FROM usuarios where usu_alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                usuario = new usuarioModel(alias, result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return usuario;
    }

    public void insertUsuario(usuarioModel usuario) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "INSERT INTO usuario (usu_alias, usu_nombre, usu_apellido, usu_email, usu_celular, usu_password, usu_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getUsu_alias());
            statement.setString(2, usuario.getUsu_nombre());
            statement.setString(3, usuario.getUsu_apellido());
            statement.setString(4, usuario.getUsu_email());
            statement.setString(5, usuario.getUsu_celular());
            statement.setString(6, usuario.getUsu_password());
            statement.setString(7, usuario.getUsu_nacimiento());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "El usuario fue agregado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void updateUsuario(usuarioModel usuario) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "UPDATE usuario SET usu_nombre = ?, usu_apellido = ?, usu_email = ?, usu_celular = ?, usu_password = ?, usu_nacimiento = ? WHERE usu_alias = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getUsu_nombre());
            statement.setString(2, usuario.getUsu_apellido());
            statement.setString(3, usuario.getUsu_email());
            statement.setString(4, usuario.getUsu_celular());
            statement.setString(5, usuario.getUsu_password());
            statement.setString(6, usuario.getUsu_nacimiento());
            statement.setString(7, usuario.getUsu_alias());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "El usuario fue actualizado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void deleteUsuario(String alias) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "DELETE FROM usuario WHERE usu_alias = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                JOptionPane.showMessageDialog(null, "El usuario fue borrado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
