/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import java.util.List;
import modelos.Tarea;
import modelos.Usuario;

/**
 *
 * @author raqpu
 */
public class GestorRasilu {

    private List<Usuario> usuarios;

    public GestorRasilu() {
        usuarios = new ArrayList<Usuario>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // Añadir una tarea a la lista de tarea de los usuariaos
    public void agregarTarea(Tarea t, String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if(usuario.getNombre().equals(nombreUsuario)){
                usuario.getListaTareas().add(t);
            }
        }

    }
    
    public boolean buscarUsuario (String nombreUsuario){
        boolean existe = false;
        for(Usuario usuario : usuarios){
            if(usuario.getNombre().equals(nombreUsuario)){
                existe = true;
            }
        }
        return existe;
    }
    
    public void eliminarUsuario (String nombreUsuario){
         for(Usuario usuario : usuarios){
            if(buscarUsuario(nombreUsuario)){
                usuarios.remove(usuario);
            }
        }
    }

}
