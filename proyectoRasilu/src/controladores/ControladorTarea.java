/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Tarea;

/**
 *
 * @author raqpu
 */
public class ControladorTarea {

    private java.util.List<Tarea> tareas;

    public ControladorTarea() {
        tareas = new ArrayList();
    }

    // Acciones que va a tener las tareas
    // Añadir tarea
    public void añadirTarea(Tarea tarea) {
        tareas.add(tarea);
    }
    // Eliminar tarea
    public void eliminarTarea (Tarea tarea){
        for(Tarea t: tareas){
            if(t.getId() == tarea.getId()){
                tareas.remove(tarea);
            } else {
                System.out.println("La tarea no se ha podido eliminar");
            }
        }
    }
    // Modificar Tarea
    public void modificarTarea(int id, Tarea tareaModificada) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.setNombre(tareaModificada.getNombre());
                t.setFechaInicio(tareaModificada.getFechaInicio());
                t.setFechaFin(tareaModificada.getFechaFin());
                t.setEstado(tareaModificada.getEstado());
            } else {
                System.out.println("No se ha encontrado podido modificar la tarea");
            }
        }
    }
    // Mostrar tareas por estados
     
    
}
