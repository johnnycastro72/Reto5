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
public class transmisionModel {
    private String tra_usu_alias;
    private int tra_con_id;
    private String tra_fechahora;
    private String titulo;
    private String nombre;
    
    
    public transmisionModel(String tra_usu_alias, int tra_con_id, String tra_fechahora) {
        this.tra_usu_alias = tra_usu_alias;
        this.tra_con_id = tra_con_id;
        this.tra_fechahora = tra_fechahora;
    }

    public transmisionModel(int tra_con_id, String titulo, String tra_usu_alias, String nombre, String tra_fechahora) {
        this.tra_usu_alias = tra_usu_alias;
        this.tra_con_id = tra_con_id;
        this.tra_fechahora = tra_fechahora;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public String getTra_usu_alias() {
        return tra_usu_alias;
    }

    public int getTra_con_id() {
        return tra_con_id;
    }

    public String getTra_fechahora() {
        return tra_fechahora;
    }

    public void setTra_con_id(int tra_con_id) {
        this.tra_con_id = tra_con_id;
    }

    public void setTra_fechahora(String tra_fechahora) {
        this.tra_fechahora = tra_fechahora;
    }
    
    @Override
    public String toString(){
        return this.tra_usu_alias;
    }

    public Object[] toArray(){
        Object[] data = {tra_con_id, titulo, tra_usu_alias, nombre, tra_fechahora};
        return data;
    }

}
