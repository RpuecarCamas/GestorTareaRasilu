/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class Tarea implements Serializable, Comparable<Tarea> {

    private static final long serialVersionUID = 1;

    public int nextId = 001;
    // Atributos de la Clase Tarea
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoTarea estado;

    // Contrustores
    public Tarea(String titulo, Date fehcaInicio, Date fechaFin1) {
    }

    /**
     * Construtor de Tarea
     * @param nombre
     * @param fechaInicio
     * @param fechaFin
     * @param estado
     */
    public Tarea(String nombre, Date fechaInicio, Date fechaFin, EstadoTarea estado) {

        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        // Inicializamos el id de forma aleatoria
        this.id = nextId++;
        this. estado = estado;
        
    }
    public Tarea (String nombre){
        this.nombre = nombre;
    }
    // Metodos
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

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int compareTo(Tarea o) {
        return fechaFin.compareTo(o.fechaFin);
    }
}
