/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.registrohospital;
import java.sql.*;
import GUI.Pantalla;
import javax.swing.JOptionPane;
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
    //En esencia en el INSERT INTO para evitar ponerlos en un orden erroneo
    public static void insertar(Pacientes pa){
        Connection con = conectar();
        PreparedStatement ps=null;
        
        try {
            String sql="INSERT INTO pacientes(rut, nombre, apellido, edad, motivo_consulta, fecha_ingreso, pasillo, estado, comentarios, `contraseña`) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(10, pa.getContrasena());

            System.out.println("PASSWORD QUE LLEGA: " + pa.getContrasena());

            ps.executeUpdate();
            System.out.println("Registro ingresado");
        }
        catch(SQLException e){
            System.out.println("Error al insertar"+e.getMessage());
        }finally{
            try{
                if (ps != null){ ps.close();}    
                if (con != null){con.close();}
            }catch(SQLException e){
                System.out.println("Error al cerrar la cnexion");
            }
        }
    }
    
    public static void eliminar(String rut) {
    String sql = "DELETE FROM pacientes WHERE rut = ?";

    try (Connection con = conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, rut);
        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Paciente eliminado correctamente");           
        } else {
            System.out.println("No se encontró un paciente con ese RUT");         
        }

    } catch (SQLException e) {
        System.out.println("Error eliminando paciente: " + e.getMessage());
    }
}
    
   
    
    public boolean puedeModificar(String rutPaciente) {
    String sql = "SELECT pasillo FROM pacientes WHERE rut = ?";
    
    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, rutPaciente.trim());
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String pasilloPaciente = rs.getString("pasillo");

            if (Pantalla.pasilloEncargado.equalsIgnoreCase("NINGUNO")) {
                return true;
            }

            if (Pantalla.pasilloEncargado.equalsIgnoreCase(pasilloPaciente)) {
                return true;
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error verificando pasillo: " + e.getMessage());
    }

    return false;  
}

    public int LoginUsuario(String rut, String pass) {
    int resultado = 0;

    String sql = "SELECT * FROM usuarios WHERE rut = ? AND contraseña = ?";

    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, rut.trim());
        ps.setString(2, pass.trim());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            resultado = 1;
            Pantalla.pasilloEncargado = rs.getString("pasillo_asignado");
        }

        con.close();
    } 
    catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "ERROR al validar login: " + e.getMessage());
    }

    return resultado;
}
    public int LoginPaciente(String rut, String pass) {
    int resultado = 0;

    String sql = "SELECT * FROM pacientes WHERE rut = ? AND contraseña = ?";

    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, rut.trim());
        ps.setString(2, pass.trim());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            resultado = 1;
        }

        con.close();
    } 
    catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "ERROR al validar login: " + e.getMessage());
    }

    return resultado;
}
    public ResultSet obtenerPacientePorRut(String rut) {
    String sql = "SELECT rut, nombre, apellido, edad, motivo_consulta, fecha_ingreso, pasillo, estado, comentarios FROM pacientes WHERE rut = ?";

    try {
        Connection con = conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, rut);
        return ps.executeQuery(); 
    } catch (Exception e) {
        System.out.println("Error consultando paciente: " + e.getMessage());
        return null;
    }
    }

    
 }

