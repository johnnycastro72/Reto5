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
import Model.peliculaModel;
import Utils.ConnectionDB;
/**
 *
 * @author JCC
 */
public class peliculaDAO {
    private Connection conn = null;

    public ArrayList<peliculaModel> getAllPeliculas() {
        ArrayList<peliculaModel> peliculas = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql          = "SELECT pel_id, pel_con_id, pel_resumen, pel_anio, pel_dir_id FROM pelicula;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                peliculaModel modelo = new peliculaModel(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getInt(5));
                
                peliculas.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return peliculas;
    }
    
    public peliculaModel getPelicula(int id) {
        peliculaModel pelicula = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "SELECT pel_con_id, pel_resumen, pel_anio, pel_dir_id FROM pelicula where pel_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                pelicula = new peliculaModel(id, result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return pelicula;
    }

    public void insertPelicula(peliculaModel pelicula) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "INSERT INTO pelicula (pel_id, pel_con_id, pel_resumen, pel_anio, pel_dir_id) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getPel_id());
            statement.setInt(2, pelicula.getPel_con_id());
            statement.setString(3, pelicula.getPel_resumen());
            statement.setString(4, pelicula.getPel_anio());
            statement.setInt(5, pelicula.getPel_dir_id());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "La película fue agregada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void updatePelicula(peliculaModel pelicula) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "UPDATE pelicula SET pel_con_id = ?, pel_resumen = ?, pel_anio = ?, pel_dir_id = ? WHERE pel_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getPel_con_id());
            statement.setString(2, pelicula.getPel_resumen());
            statement.setString(3, pelicula.getPel_anio());
            statement.setInt(4, pelicula.getPel_dir_id());
            statement.setInt(5, pelicula.getPel_id());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "La película fue actualizada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void deletePelicula(int id) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "DELETE FROM pelicula WHERE pel_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                JOptionPane.showMessageDialog(null, "La película fue borrada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
