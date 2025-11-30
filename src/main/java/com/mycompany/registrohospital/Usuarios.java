/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.registrohospital;

/**
 *
 * @author Legion
 */
public class Usuarios {
    private int id_paciente;
    private String  rut;
    private String nombre;
    private String apellido;
    private int  edad;
    private String motivo;
    private String fecha;
    private String pasillo;
    private String estado;
    private String comentario;
    private String contrasena;
    private int id_usuario;

    public Usuarios(String rut, String nombre, String apellido, int edad, String motivo, String fecha, String pasillo, String estado, String contrasena) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.motivo = motivo;
        this.fecha = fecha;
        this.pasillo = pasillo;
        this.estado = estado;
        this.comentario = "Sin observaciones";
        this.contrasena = contrasena;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPasillo() {
        return pasillo;
    }

    public String getEstado() {
        return estado;
    }

    public String getComentario() {
        return comentario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
    
