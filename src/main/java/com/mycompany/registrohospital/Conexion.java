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
    
}
