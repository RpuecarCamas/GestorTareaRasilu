/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


import java.io.Serializable;


/**
 *
 * @author raqpu
 */
public class Usuario  implements Serializable {
    // Atributos
    private static final long serialVersionUID = 1;
    public static int nextId = 100;
    private int id;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String contraseña;
    
    public Usuario (){
    }
    
    public Usuario (String nombre, String email, String contraseña){
        this.id = nextId++;
        this.nombre = nombre;
        this.correoElectronico = email;
        this.contraseña = contraseña;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    

    @Override
    public String toString() {
        return "Usuario" + "id: " + id + 
               "\n" + ", nombre: " + nombre + "\n" + ", correoElectronico: " + correoElectronico ;
    }
    
}
