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
    private String contasena2;
    private List<Tarea> listaTareas;

    public Usuario() {
        listaTareas = new ArrayList<Tarea>();
    }

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String contrasena, String contrasena2) {
        nextId = 100;
        this.id = nextId++;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.contasena2 = contasena2;

    }

    public Usuario(String nombre, String contrasena, String contrasena2, List<Tarea> listaTareas, int id) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.contasena2 = contrasena2;
        listaTareas = new ArrayList<Tarea>();
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getNombre() {
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

    public String getContasena2() {
        return contasena2;
    }

    public void setContasena2(String contasena2) {
        this.contasena2 = contasena2;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }
    

    @Override
    public String toString() {
        return "Usuario" + "id: " + id
                + "\n" + ", nombre: " + nombre + "\n";
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
