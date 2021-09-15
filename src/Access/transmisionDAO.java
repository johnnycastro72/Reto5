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
import Model.transmisionModel;
import Utils.ConnectionDB;
/**
 *
 * @author JCC
 */
public class transmisionDAO {
    private Connection conn = null;

    public ArrayList<transmisionModel> getAllTransmisiones() {
        ArrayList<transmisionModel> transmisiones = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT transmisiones.tra_con_id, contenidos.titulo, transmisiones.tra_usu_alias, CONCAT(usuarios.usu_nombre,' ',usuarios.usu_apellido), tra_fechahora \n" + 
                         "FROM transmisiones \n" + 
                         "JOIN contenidos ON transmisiones.tra_con_id=contenidos.con_id \n" +
                         "JOIN usuarios   ON transmisiones.tra_usu_alias=usuarios.usu_alias;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                transmisionModel modelo = new transmisionModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                
                transmisiones.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return transmisiones;
    }
    
    public ArrayList<transmisionModel> getFilteredTransmisiones(int idContenido, String idAlias, String usuarioName) {
        ArrayList<transmisionModel> transmisiones = new ArrayList();
        int case_ = -1;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT transmisiones.tra_con_id, contenidos.titulo, transmisiones.tra_usu_alias, CONCAT(usuarios.usu_nombre,' ',usuarios.usu_apellido), tra_fechahora \n" + 
                         "FROM transmisiones \n" + 
                         "JOIN contenidos ON transmisiones.tra_con_id=contenidos.con_id \n" +
                         "JOIN usuarios   ON transmisiones.tra_usu_alias=usuarios.usu_alias \n" +
                         "WHERE transmisiones.tra_usu_alias LIKE ?";
            if(idContenido != -1){
                if(idAlias != "Todos"){
                    sql += " AND transmisiones.tra_con_id=? AND transmisiones.tra_usu_alias=?;";
                    case_ = 1;
                }
                else{
                    sql += " AND transmisiones.tra_con_id=?;";
                    case_ = 2;
                }
            } else if((idAlias != "Todos")) {
                    sql += "  AND transmisiones.tra_usu_alias=?;";
                    case_ = 3;
            }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+usuarioName+"%");
            switch(case_){
                case 1:     statement.setInt(2, idContenido); statement.setString(3, idAlias);        break;
                case 2:     statement.setInt(2, idContenido);                                         break;
                case 3:     statement.setString(2, idAlias);                                          break;
            }
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                transmisionModel modelo = new transmisionModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                
                transmisiones.add(modelo);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        }
        return transmisiones;
    }
    
    public transmisionModel getTransmision(String alias, int id) {
        transmisionModel transmision = null;
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "SELECT tra_fechahora FROM transmisiones where tra_usu_alias=? and tra_con_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);
            statement.setInt(2, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                transmision = new transmisionModel(alias, id, result.getString(1));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return transmision;
    }

    public void insertTransmision(transmisionModel transmision) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, transmision.getTra_usu_alias());
            statement.setInt(2, transmision.getTra_con_id());
            statement.setString(3, transmision.getTra_fechahora());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "La transmision fue agregada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void updateTransmision(transmisionModel transmision) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "UPDATE transmisiones SET tra_fechahora = ? WHERE tra_usu_alias = ? and tra_con_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, transmision.getTra_fechahora());
            statement.setString(2, transmision.getTra_usu_alias());
            statement.setInt(3, transmision.getTra_con_id());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "La transmision fue actualizada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void deleteTransmision(String alias, int id) {
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql                  = "DELETE FROM transmisiones WHERE tra_usu_alias = ? and tra_con_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);
            statement.setInt(2, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                JOptionPane.showMessageDialog(null, "La transmision fue borrada exitosamente!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
