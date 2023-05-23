/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Tarea;
import modelos.Usuario;

public class GestorRasilu implements Serializable{
    private Usuario usuario;
    private List<Usuario> usuarios;
    private String rutaUsuario = "datos/usuario.dat";
    private int longMinContrasenaUsuario;
    private int longMinNombreUsuario;

    public GestorRasilu() {
        usuarios = new ArrayList<Usuario>();
        longMinContrasenaUsuario = 6;
        longMinNombreUsuario = 3;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
  

    // Métodos 
    public void crearUsuario(String nombre, String contrasena, String contrasena2) throws IOException {

        boolean crear = true;
        if (nombre.equals(contrasena)) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario no puede ser igual que la contraseña");
            crear = false;
        }

        if (buscarUsuario(nombre)) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe");
            crear = false;
        }

        if (nombre.isEmpty() || nombre.equals("Escriba aquí su nombre..")) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario");
            crear = false;
        }

        if (contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir una contraseña");
            crear = false;
        }

        if (contrasena2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe confirmar su contraseña");
            crear = false;
        }

        if (!contrasena.equals(contrasena2)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            crear = false;
        }

        if (nombre.length() < longMinNombreUsuario) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener al menos " + longMinNombreUsuario + " caracteres");
            crear = false;
        }

        if (contrasena.length() < longMinContrasenaUsuario) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos " + longMinContrasenaUsuario + " caracteres");
            crear = false;
        }

        if (crear) {
            Usuario nuevo = new Usuario(nombre, contrasena);
            usuarios.add(nuevo);
            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaUsuario));
            oos.writeObject(usuarios);
            
        } catch (IOException ex) {
            System.err.println("Error al guardar al usuario" + ex.getMessage());
        }
    }

    public void cargarUsuarios() {

        try ( ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(rutaUsuario))) {
            usuarios = (List<Usuario>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            usuarios = new ArrayList<Usuario>();
        }
    }

    // Busca el usuario 
    public boolean buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarUsuario(String nombreUsuario) {
        Usuario usuarioAEliminar = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                usuarioAEliminar = usuario;
            } else {
                System.out.println("No se ha encontrado el usuario");
            }
        }
        if (usuarioAEliminar != null) {
            usuarios.remove(usuarioAEliminar);
        }
    }

    public boolean nombreValido(String nombre) {
        if (nombre.isEmpty()) {
            return false;
        }

        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) != ' ' && !nombre.equals("null")) {
                return true;
            }
        }
        return false;
    }

//    public void modificarUsuario(Usuario usu) {
//        for (Usuario u : usuarios) {
//            if (u.getNombre().equals(usu.getNombre())) {
//                u.setNombre(usu.getNombre());
//                u.setContrasena(usu.getContrasena());
//                u.setContasena2(usu.getContasena2());
//                System.out.println("Usuario modificado correctamente");
//            } else {
//                System.out.println("El usuario " + usu + " no se ha podido modificar correctamente");
//            }
//        }
//    }

    public Usuario usuarioCorrecto(String nombre, String contrasena) {
        Usuario comprobar = new Usuario(nombre, contrasena);

        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(comprobar.getNombre()) && u.getContrasena().equals(comprobar.getContrasena())) {
                return u;
            }
        }
        return null;
    }
    
  
//    public void addTarea (Tarea t){
//        tareas.add(t);
//    }
//    public void eliminarTarea(Tarea tarea, Usuario u) {
//        if (u.getListaTareas().remove(tarea)) {
//            actualizarArchivoTareas(u);
//        } else {
//            System.out.println("La tarea no se ha podido eliminar");
//        }
//    }
//    private boolean siExisteTarea(Tarea tarea, Usuario u) {
//        return u.getListaTareas().contains(tarea);
//    }
   
    public void guardarTareas(List<Tarea> tareas, String nombre) {
        String nombreArchivo = "datos/" + nombre + "Tarea.dat";
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(nombreArchivo)))) {
            out.writeObject(tareas);
        } catch (IOException e) {
            System.out.println("Error al crear el archivo de tareas para el usuario: " + nombre);
        }
    }



   

//    public void actualizarArchivoTareas(Usuario usuario) {
//        String nombreArchivo = "datos/" + usuario.getNombre() + "Tarea.dat";
//        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(nombreArchivo)))) {
//            out.writeObject(usuario.getListaTareas());
//        } catch (IOException e) {
//            System.out.println("Error al actualizar el archivo de tareas para el usuario: " + usuario.getNombre());
//        }
//    }
}
