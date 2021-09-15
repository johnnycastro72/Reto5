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
import Model.serieModel;
import Utils.ConnectionDB;
/**
 *
 * @author JCC
 */
public class serieDAO {
    private Connection conn = null;

    public ArrayList<serieModel> getAllSeries() {
        ArrayList<serieModel> series = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql          = "SELECT ser_id, ser_con_id, ser_temporadas, ser_episodios FROM serie;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                serieModel modelo = new serieModel(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4));
                
                series.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return series;
    }
    
    public serieModel getSerie(int id) {
        serieModel serie = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "SELECT ser_con_id, ser_temporadas, ser_episodios FROM serie where ser_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                serie = new serieModel(id, result.getInt(1), result.getInt(2), result.getInt(3));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return serie;
    }

    public void insertSerie(serieModel serie) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodio) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, serie.getSer_con_id());
            statement.setInt(2, serie.getSer_temporadas());
            statement.setInt(3, serie.getSet_episodios());
            statement.setInt(4, serie.getSer_id());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "La serie fue agregada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void updateSerie(serieModel serie) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "UPDATE serie SET ser_con_id = ?, ser_temporadas = ?, ser_episodios = ? WHERE ser_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, serie.getSer_con_id());
            statement.setInt(2, serie.getSer_temporadas());
            statement.setInt(3, serie.getSet_episodios());
            statement.setInt(4, serie.getSer_id());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "La serie fue actualizada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void deleteSerie(int id) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "DELETE FROM serie WHERE ser_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                JOptionPane.showMessageDialog(null, "La serie fue borrada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
