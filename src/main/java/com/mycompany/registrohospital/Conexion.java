/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrohospital;
import java.sql.*;
/**
 *
 * @author Legion
 */
public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/saludplus";
    private static final String user="root";
    private static final String pass="";
    
    public static Connection conectar(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa a Mysql");
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en la conexion: " +e.getMessage());
        }
        return con;}
    
    
    //Se uso Chatgt para reutilizar un codigo antiguo, y adaptarlo a lo que necesito
    //En esencia en el INSERT INTO para evitar ponerlos en un otrden erroneo
    public static void insertar(Pacientes pa){
        Connection con = conectar();
        PreparedStatement ps=null;
        
        try{
            String sql="INSERT INTO pacientes(rut, nombre, apellido, edad, motivo_consulta, fecha_ingreso, pasillo, estado, comentarios) VALUES (?,?,?,?,?,?,?,?,?)";
            ps= con.prepareStatement(sql);
            ps.setString(1, pa.getRut());
            ps.setString(2, pa.getNombre());
            ps.setString(3, pa.getApellido());
            ps.setString(4, String.valueOf(pa.getEdad()));
            ps.setString(5, pa.getMotivo_consulta());
            ps.setString(6, pa.getFecha());
            ps.setString(7, pa.getPasillo());
            ps.setString(8, pa.getEstado());
            ps.setString(9, pa.getComentarios());
            ps.executeUpdate();
            System.out.println("Registro ingresado");
        }catch(SQLException e){
            System.out.println("Error al insertar"+e.getMessage());
        }finally{
            try{
                if (ps != null){ ps.close();}    
                if (con != null){con.close();}
            }catch(SQLException e){
                System.out.println("Error al cerrar ña cnexion");
            }
        }
    }
    public static boolean eliminar(String rut) {
    String sql = "DELETE FROM pacientes WHERE rut = ?";

    try (Connection con = conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, rut);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Paciente eliminado correctamente");
            return true;
        } else {
            System.out.println("No se encontró un paciente con ese RUT");
            return false;
        }

    } catch (SQLException e) {
        System.out.println("Error eliminando paciente: " + e.getMessage());
        return false;
    }
}
    
    // Se utulizo Chatgpt para adaptar codigo antiguo a uno utilizable para este 
    public static boolean actualizar(Pacientes pa) {
    String sql = "UPDATE pacientes SET nombre=?, apellido=?, edad=?, motivo_consulta=?, "
               + "fecha_ingreso=?, pasillo=?, estado=?, comentarios=?, contraseña=? "
               + "WHERE rut=?";

    try (Connection con = conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, pa.getNombre());
        ps.setString(2, pa.getApellido());
        ps.setInt(3, pa.getEdad());
        ps.setString(4, pa.getMotivo_consulta());
        ps.setString(5, pa.getFecha());
        ps.setString(6, pa.getPasillo());
        ps.setString(7, pa.getEstado());
        ps.setString(8, pa.getComentarios());
        ps.setString(9, pa.getContrasena());       
        ps.setString(10, pa.getRut()); // <- se actualiza por RUT

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Paciente actualizado correctamente");
            return true;
        } else {
            System.out.println("No se encontró un paciente con ese RUT");
            return false;
        }

    } catch (SQLException e) {
        System.out.println("Error actualizando paciente: " + e.getMessage());
        return false;
    }
    }
    
    
}
