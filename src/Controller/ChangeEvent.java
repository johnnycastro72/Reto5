/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Access.contenidoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Model.contenidoModel;
import Access.usuarioDAO;
import Model.usuarioModel;
import View.ControlsPanel;

/**
 *
 * @author JCC
 */
public class ChangeEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getCbxContenidoList()) {
            contenidoDAO oContenidoDAO = new contenidoDAO();
            ArrayList<contenidoModel> contenidos = null;
            String alias = ((usuarioModel)this.controlsPanel.getCbxUsuarioList().getSelectedItem()).getUsu_alias();
            if(alias == "-1") {
                contenidos = oContenidoDAO.getAllContenidos();
                contenidos.add(0, new contenidoModel(-1, "Todos los contenidos"));
            }
            else {
                contenidos = oContenidoDAO.getContenidosbyUser(alias);
                contenidos.add(0, new contenidoModel(-1, "Todos los contenidos"));
            }
            this.controlsPanel.setCbxContenidoList(contenidos);
        }
    }
    
}
