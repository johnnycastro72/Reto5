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
import Model.directorModel;
import Utils.ConnectionDB;
/**
 *
 * @author JCC
 */
public class directorDAO {
    private Connection conn = null;

    public ArrayList<directorModel> getAllDirectores() {
        ArrayList<directorModel> directores = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql          = "SELECT dir_id, dir_nombre, dir_apellido, dir_nacionalidad FROM director;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                directorModel modelo = new directorModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                
                directores.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return directores;
    }
    
    public directorModel getDirector(int id) {
        directorModel director = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "SELECT dir_nombre, dir_apellido, dir_nacionalidad FROM director where dir_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                director = new directorModel(id, result.getString(1), result.getString(2), result.getString(3));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return director;
    }

    public void insertDirector(directorModel director) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "INSERT INTO director (dir_id, dir_nombre, dir_apellido, dir_nacionalidad) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, director.getDir_id());
            statement.setString(2, director.getDir_nombre());
            statement.setString(3, director.getDir_apellido());
            statement.setString(4, director.getDir_nacionalidad());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "El director fue agregado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void updateDirector(directorModel director) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "UPDATE director SET dir_nombre = ?, dir_apellido = ?, dir_nacionalidad = ? WHERE dir_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, director.getDir_nombre());
            statement.setString(2, director.getDir_apellido());
            statement.setString(3, director.getDir_nacionalidad());
            statement.setInt(4, director.getDir_id());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "El director fue actualizado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void deleteDirector(int id) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "DELETE FROM director WHERE dir_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                JOptionPane.showMessageDialog(null, "El director fue borrado exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
