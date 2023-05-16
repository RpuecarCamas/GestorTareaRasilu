/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import modelos.Tarea;

/**
 *
 * @author raqpu
 */
public class ControladorTarea implements Serializable{

    private java.util.List<Tarea> tareas;

    public ControladorTarea() {
        tareas = new ArrayList();
    }

    // Acciones que va a tener las tareas
    // Añadir tarea
    public void añadirTarea(Tarea tarea) {
        if(isExistsTarea(tarea)){
            System.out.println("La tarea ya existe");
        } else {
            tareas.add(tarea);
        }
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
    
   // Tarea Esiste
    public boolean isExistsTarea (Tarea t){
        return tareas.contains(t);
    }
     
    
}
