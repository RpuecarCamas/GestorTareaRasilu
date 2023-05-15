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
    private String contrase�a;
    
    public Usuario (){
    }
    
    public Usuario (String nombre, String email, String contrase�a){
        this.id = nextId++;
        this.nombre = nombre;
        this.correoElectronico = email;
        this.contrase�a = contrase�a;
        
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

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }
    

    @Override
    public String toString() {
        return "Usuario" + "id: " + id + 
               "\n" + ", nombre: " + nombre + "\n" + ", correoElectronico: " + correoElectronico ;
    }
    
}
