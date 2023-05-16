/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


import java.io.Serializable;
import java.util.List;


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
    private String email;
    private String contrasena;
    private String contasena2;
    private List<Tarea> listaTareas;
    
    public Usuario (){
    }
    
    public Usuario (String nombre, String email, String contrasena, String contrasena2){
        this.id = nextId++;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.contasena2 = contasena2;
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String correoElectronico) {
        this.email = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getContasena2() {
        return contasena2;
    }

    public void setContasena2(String contasena2) {
        this.contasena2 = contasena2;
    }
    
    @Override
    public String toString() {
        return "Usuario" + "id: " + id + 
               "\n" + ", nombre: " + nombre + "\n" + ", correoElectronico: " + email ;
    }
    
        public void añadirTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }
        public void eliminarTarea(Tarea tarea) {
        listaTareas.remove(tarea);
    }
        
       public void modificarTarea(Tarea tarea) {
        // Implementación para modificar una tarea específica
    }
         public void modificarEstadoTarea(Tarea tarea, EstadoTarea estado) {
        tarea.setEstado(estado);
    }
}
