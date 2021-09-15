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
public class directorModel {
    private int dir_id;
    private String dir_nombre;
    private String dir_apellido;
    private String dir_nacionalidad;

    public directorModel(int dir_id, String dir_nombre, String dir_apellido, String dir_nacionalidad) {
        this.dir_id = dir_id;
        this.dir_nombre = dir_nombre;
        this.dir_apellido = dir_apellido;
        this.dir_nacionalidad = dir_nacionalidad;
    }

    public int getDir_id() {
        return dir_id;
    }

    public String getDir_nombre() {
        return dir_nombre;
    }

    public String getDir_apellido() {
        return dir_apellido;
    }

    public String getDir_nacionalidad() {
        return dir_nacionalidad;
    }

    public void setDir_nombre(String dir_nombre) {
        this.dir_nombre = dir_nombre;
    }

    public void setDir_apellido(String dir_apellido) {
        this.dir_apellido = dir_apellido;
    }

    public void setDir_nacionalidad(String dir_nacionalidad) {
        this.dir_nacionalidad = dir_nacionalidad;
    }
    
    @Override
    public String toString(){
        return this.dir_nombre + " " + this.dir_apellido;
    }
}
