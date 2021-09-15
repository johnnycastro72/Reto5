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
public class serieModel {
    private int ser_id;
    private int ser_con_id;
    private int ser_temporadas;
    private int ser_episodios;

    public serieModel(int ser_id, int ser_con_id, int ser_temporadas, int set_episodios) {
        this.ser_id = ser_id;
        this.ser_con_id = ser_con_id;
        this.ser_temporadas = ser_temporadas;
        this.ser_episodios = set_episodios;
    }

    public int getSer_id() {
        return ser_id;
    }

    public int getSer_con_id() {
        return ser_con_id;
    }

    public int getSer_temporadas() {
        return ser_temporadas;
    }

    public int getSet_episodios() {
        return ser_episodios;
    }

    public void setSer_con_id(int ser_con_id) {
        this.ser_con_id = ser_con_id;
    }

    public void setSer_temporadas(int ser_temporadas) {
        this.ser_temporadas = ser_temporadas;
    }

    public void setSer_episodios(int ser_episodios) {
        this.ser_episodios = ser_episodios;
    }
    
    @Override
    public String toString(){
        return "Tiene " + Integer.toString(this.ser_temporadas) + "temporadas";
    }
}
