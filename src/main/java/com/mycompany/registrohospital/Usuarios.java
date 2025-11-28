/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrohospital;

/**
 *
 * @author Legion
 */
public class Usuarios {
    private int id_usuario;
    private String  rutusuario;
    private String nombreusuario;
    private String apellidousuario;
    private String  tipo_usuario;
    private String pasillo_asignado;
    private String contrasenausuario;

    public Usuarios(int id_usuario, String rutusuario, String nombreusuario, String apellidousuario, String tipo_usuario, String pasillo_asignado, String contrasenausuario) {
        this.id_usuario = id_usuario;
        this.rutusuario = rutusuario;
        this.nombreusuario = nombreusuario;
        this.apellidousuario = apellidousuario;
        this.tipo_usuario = tipo_usuario;
        this.pasillo_asignado = pasillo_asignado;
        this.contrasenausuario = contrasenausuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getRutusuario() {
        return rutusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public String getApellidousuario() {
        return apellidousuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public String getPasillo_asignado() {
        return pasillo_asignado;
    }

    public String getContrasenausuario() {
        return contrasenausuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setRutusuario(String rutusuario) {
        this.rutusuario = rutusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public void setApellidousuario(String apellidousuario) {
        this.apellidousuario = apellidousuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public void setPasillo_asignado(String pasillo_asignado) {
        this.pasillo_asignado = pasillo_asignado;
    }

    public void setContrasenausuario(String contrasenausuario) {
        this.contrasenausuario = contrasenausuario;
    }
    
    
}
