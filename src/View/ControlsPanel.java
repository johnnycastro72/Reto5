/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ChangeEvent;
import Controller.ClickEvent;
import Controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.transmisionModel;
import Model.contenidoModel;
import Model.usuarioModel;
import java.awt.Color;
/**
 *
 * @author JCC
 */
public class ControlsPanel extends JPanel {

    private JLabel                       lblUsuario;
    private JComboBox<usuarioModel>      cbxUsuarioList;
    private JLabel                       lblContenido;
    private JComboBox<contenidoModel>    cbxContenidoList;
    private JLabel                       lblName;
    private JTextField                   txtName;
    private JButton                      btnSearch;
    private JButton                      btnAddTransmision;
    private JTable                       tblResults;

    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();
        
        // Complete ArtPieces info
        this.setTblResults(initialData.getTransmisiones());
        
        // Museum selection
        this.lblUsuario = new JLabel("Usuario");
        add(this.getLblUsuario());
        
        this.cbxUsuarioList = new JComboBox();
        this.cbxUsuarioList.setModel(new DefaultComboBoxModel<>(initialData.getUsuarios().toArray(new usuarioModel[initialData.getUsuarios().size()])));
        this.cbxUsuarioList.setSelectedIndex(0);
        add(this.getCbxUsuarioList());
        
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxUsuarioList().addActionListener(changeEvent);
        
        
        // Exhibition selection
        this.lblContenido = new JLabel("Contenido");
        add(this.getLblContenido());
        
        this.cbxContenidoList = new JComboBox();
        this.setCbxContenidoList(initialData.getContenidos());
        add(this.getCbxContenidoList());
        
        
        // Name patttern 
        this.lblName = new JLabel("Nombre del Usuario");
        add(this.getLblName());
        
        this.txtName = new JTextField();
        add(this.getTxtName());
        
        
        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);
        
        // Insert  button
        this.btnAddTransmision = new JButton("Agregar Nueva Transmisión");
        add(this.getBtnAddTransmision());
        this.getBtnAddTransmision().addActionListener(clickEvent);
    }

    /**
     * @return the lblMuseums
     */
    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    /**
     * @return the cbxMuseumsList
     */
    public JComboBox getCbxUsuarioList() {
        return cbxUsuarioList;
    }

    public JLabel getLblContenido() {
        return lblContenido;
    }

    public JComboBox getCbxContenidoList() {
        return cbxContenidoList;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JTable getTblResults() {
        return tblResults;
    }

    public void setCbxContenidoList(ArrayList<contenidoModel> contenidos) {
        this.cbxContenidoList.setModel(new DefaultComboBoxModel<>(contenidos.toArray(new contenidoModel[contenidos.size()])));
        this.getCbxContenidoList().setSelectedIndex(0);
    }

    public void setTblResults(ArrayList<transmisionModel> transmisiones) {
        String[] headers = {"ID", "Titulo", "Alias", "Nombre del Usuario", "Fecha"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<transmisiones.size(); i++){
            tableModel.addRow(transmisiones.get(i).toArray() );
        }
    }

    /**
     * @return the btnAddArtPiece
     */
    public JButton getBtnAddTransmision() {
        return btnAddTransmision;
    }

}
