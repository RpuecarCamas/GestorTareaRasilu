/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raqpu
 */
public class Usuario implements Serializable {

    // Atributos
    private final long serialVersionUID = 1;
    public int nextId;
    private int id;
    private String nombre;
    private String contrasena;
    private List<Tarea> tareas;

    public Usuario() {

    }

  
    public Usuario(String nombre, String contrasena) {
        nextId = 100;
        this.id = nextId++;
        this.nombre = nombre;
        this.contrasena = contrasena;
        tareas = new ArrayList<Tarea>();

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

 
    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
    
    @Override
    public String toString() {
        return "Usuario" + "id: " + id
                + "\n" + ", nombre: " + nombre + "\n";
    }

    // Tarea
//    public void añadirTarea(Tarea tarea) {
//        listaTareas.add(tarea);
//    }
//
//    public void eliminarTarea(Tarea tarea) {
//        listaTareas.remove(tarea);
//    }
    public void modificarTarea(Tarea tarea) {
        // Implementación para modificar una tarea específica
    }

    public void modificarEstadoTarea(Tarea tarea, EstadoTarea estado) {
        tarea.setEstado(estado);
    }
}
