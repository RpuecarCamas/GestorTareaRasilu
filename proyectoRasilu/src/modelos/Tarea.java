/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoTarea estado;

    // Contrustores
    public Tarea() {
    }

    /**
     * Construtor de Tarea
     * @param nombre
     * @param fechaInicio
     * @param fechaFin
     * @param estado
     */
    public Tarea(String nombre, LocalDate fechaInicio, LocalDate fechaFin, EstadoTarea estado) {

        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        // Inicializamos el id de forma aleatoria
        this.id = nextId++;
        this. estado = estado;
        
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

    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int compareTo(Tarea o) {
        return fechaFin.compareTo(o.fechaFin);
    }
}
