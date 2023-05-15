/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author raqpu
 */
public class ControladorFile {
    private String rutaUsuario = new String ("datos/usuario.dat");
    private String rutaTarea = new String ("datos/usuario.dat");
    
    public ControladorFile (String rutaUsuario, String rutaTarea){
        this.rutaUsuario = rutaUsuario;
        this.rutaTarea = rutaTarea;
    }
}
