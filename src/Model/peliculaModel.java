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
public class peliculaModel {
    private int pel_id;
    private int pel_con_id;
    private String pel_resumen;
    private String pel_anio;
    private int pel_dir_id;

    public peliculaModel(int pel_id, int pel_con_id, String pel_resumen, String pel_anio, int pel_dir_id) {
        this.pel_id = pel_id;
        this.pel_con_id = pel_con_id;
        this.pel_resumen = pel_resumen;
        this.pel_anio = pel_anio;
        this.pel_dir_id = pel_dir_id;
    }

    public int getPel_id() {
        return pel_id;
    }

    public int getPel_con_id() {
        return pel_con_id;
    }

    public String getPel_resumen() {
        return pel_resumen;
    }

    public String getPel_anio() {
        return pel_anio;
    }

    public int getPel_dir_id() {
        return pel_dir_id;
    }

    public void setPel_con_id(int pel_con_id) {
        this.pel_con_id = pel_con_id;
    }

    public void setPel_resumen(String pel_resumen) {
        this.pel_resumen = pel_resumen;
    }

    public void setPel_anio(String pel_anio) {
        this.pel_anio = pel_anio;
    }

    public void setPel_dir_id(int pel_dir_id) {
        this.pel_dir_id = pel_dir_id;
    }

    @Override
    public String toString() {
        return this.pel_resumen;
    }
    
}
