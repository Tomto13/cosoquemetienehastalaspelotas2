/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital21;

import GUI.Pantalla;
import main.java.com.mycompany.registrohospital.Conexion;

/**
 *
 * @author Legion
 */
public class HOSPITAL21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectar();
        Pantalla pan = new Pantalla();
        pan.resize(450, 300);
        pan.setVisible(true);
    }
    
}
