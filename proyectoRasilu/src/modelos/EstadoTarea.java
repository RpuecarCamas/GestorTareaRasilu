/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelos;

/**
 *
 * @author raqpu
 */
public enum EstadoTarea {
    EN_ESPERA("En espera"),
    EN_PROCESO("En proceso"),
    FINALIZADO("Finalizado");

    private String descripcion;

    EstadoTarea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
