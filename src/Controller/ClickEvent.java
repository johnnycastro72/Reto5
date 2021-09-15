/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Access.transmisionDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Model.transmisionModel;
import Model.contenidoModel;
import Model.usuarioModel;
import View.AddTransmision;
import View.ControlsPanel;
/**
 *
 * @author JCC
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            int idContenido         = ((contenidoModel)this.controlsPanel.getCbxContenidoList().getSelectedItem()).getCon_id();
            String idAlias          = ((usuarioModel)this.controlsPanel.getCbxUsuarioList().getSelectedItem()).getUsu_alias();
            String usuarioName      = (String)this.controlsPanel.getTxtName().getText();
            
            transmisionDAO oTransmisionDAO = new transmisionDAO();
            ArrayList<transmisionModel> transmisiones = oTransmisionDAO.getFilteredTransmisiones(idContenido, idAlias, usuarioName);
            
            this.controlsPanel.setTblResults(transmisiones);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddTransmision()) {
            AddTransmision addTransmisionView = new AddTransmision();
            addTransmisionView.setVisible(true);
    }   }
}