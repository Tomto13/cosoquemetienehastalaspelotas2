/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.registrohospital;

/**
 *
 * @author Legion
 */
public class Pacientes {
    private int id_paciente;
    private String  rut;
    private String nombre;
    private String apellido;
    private int edad;
    private String motivo_consulta;
    private String fecha;
    private String pasillo;
    private String estado;
    private String comentarios;
    private String contrasena;
    private Integer id_usuario_fk;

    public Pacientes(String rut, String nombre, String apellido, int edad, String motivo_consulta, String fecha, String pasillo, String estado, String comentario, String contrasena) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.motivo_consulta = motivo_consulta;
        this.fecha = fecha;
        this.pasillo = pasillo;
        this.estado = estado;
        this.comentarios = "Sin observaciones";
        this.contrasena = contrasena;
    }

   

    public int getId_paciente() {
        return id_paciente;
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

    public String getMotivo_consulta() {
        return motivo_consulta;
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

    public String getComentarios() {
        return comentarios;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Integer getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
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

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
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

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setId_usuario_fk(Integer id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }
    
    
}
