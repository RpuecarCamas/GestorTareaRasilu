/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public void modificarTarea(Tarea tareaModificada) {
        for (Tarea t : tareas) {
            if (!isExistsTarea(tareaModificada)) {
                t.setNombre(tareaModificada.getNombre());
                t.setFechaInicio(tareaModificada.getFechaInicio());
                t.setFechaFin(tareaModificada.getFechaFin());
                t.setEstado(tareaModificada.getEstado());
            
                System.out.println("No se ha encontrado podido modificar la tarea");
            }
        }
    }
   // Tarea Esiste
    public boolean isExistsTarea (Tarea t){
        return tareas.contains(t);
    }
     
     public static void guardarDatos(Tarea e) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("empresa.dat"));
            salida.writeObject(e);
            salida.close();
        } catch (IOException ex) {
            System.err.println("Error al guardar datos "
                    + ex.getMessage());
        }
    }
    
    public static Tarea cargarDatos (){
        Tarea e;
        try {
            ObjectInputStream entrada = new ObjectInputStream(new
                                        FileInputStream("empresa.dat"));
            e = (Tarea)entrada.readObject();
            entrada.close();
        }catch (IOException | ClassNotFoundException ex){
            System.err.println("Error al abrir los datos: " + ex.getMessage());
        } 
        e = new Tarea();
        return e;
    }
}
