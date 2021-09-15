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
public class usuarioModel {
    
    private String usu_alias;
    private String usu_nombre;
    private String usu_apellido;
    private String usu_email;
    private String usu_celular;
    private String usu_password;
    private String usu_nacimiento;

    public usuarioModel(String usu_alias, String usu_nombre, String usu_apellido, String usu_email, String usu_celular, String usu_password, String usu_nacimiento) {
        this.usu_alias = usu_alias;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_email = usu_email;
        this.usu_celular = usu_celular;
        this.usu_password = usu_password;
        this.usu_nacimiento = usu_nacimiento;
    }

    public usuarioModel(String usu_alias, String usu_nombre) {
        this.usu_alias = usu_alias;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = "";
        this.usu_email = "";
        this.usu_celular = "";
        this.usu_password = "";
        this.usu_nacimiento = "";
    }

    public String getUsu_alias() {
        return usu_alias;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public String getUsu_apellido() {
        return usu_apellido;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public String getUsu_celular() {
        return usu_celular;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public String getUsu_nacimiento() {
        return usu_nacimiento;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public void setUsu_celular(String usu_celular) {
        this.usu_celular = usu_celular;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    public void setUsu_nacimiento(String usu_nacimiento) {
        this.usu_nacimiento = usu_nacimiento;
    }

    @Override
    public String toString() {
        return this.usu_alias;
    }
            
}