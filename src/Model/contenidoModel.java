/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author JCC
 */
public class contenidoModel {
    private int con_id;
    private String titulo;

    public contenidoModel(int con_id, String titulo) {
        this.con_id = con_id;
        this.titulo = titulo;
    }

    public int getCon_id() {
        return con_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
