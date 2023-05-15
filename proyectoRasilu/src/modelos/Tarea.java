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

    public static int nextId = 001;
    // Atributos de la Clase Tarea
    private int id;
    private String nombre;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Contrustores
    public Tarea() {
    }

    public Tarea(String nombre, String estado, LocalDate fechaInicio, LocalDate fechaFin) {

        this.nombre = nombre;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        // Inicializamos el id de forma aleatoria
        this.id = nextId++;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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
