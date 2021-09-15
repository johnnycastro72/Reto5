/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Access.transmisionDAO;
import Model.transmisionModel;
import java.util.ArrayList;
import Access.contenidoDAO;
import Model.contenidoModel;
import Access.usuarioDAO;
import Model.usuarioModel;
/**
 *
 * @author JCC
 */
public class InitialData {
    private ArrayList<transmisionModel>  transmisiones = null;
    private ArrayList<contenidoModel>    contenidos    = null;
    private ArrayList<usuarioModel>      usuarios      = null;

    public InitialData() {
        contenidoDAO oContenidoDAO = new contenidoDAO();
        this.contenidos = oContenidoDAO.getAllContenidos();
        this.contenidos.add(0, new contenidoModel(-1, "Todos los contenidos"));
        
        usuarioDAO oUsuarioDAO = new usuarioDAO();
        this.usuarios = oUsuarioDAO.getAllUsuarios();
        this.usuarios.add(0, new usuarioModel("Todos", "Todas los usuarios"));
        
        transmisionDAO oTransmisionDAO = new transmisionDAO();
        this.transmisiones = oTransmisionDAO.getAllTransmisiones();
   }

    public ArrayList<transmisionModel> getTransmisiones() {
        return transmisiones;
    }

    public ArrayList<contenidoModel> getContenidos() {
        return contenidos;
    }

    public ArrayList<usuarioModel> getUsuarios() {
        return usuarios;
    }

    
}
