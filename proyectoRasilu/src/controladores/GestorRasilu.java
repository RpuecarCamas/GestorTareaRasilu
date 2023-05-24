/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Tarea;
import modelos.Usuario;

public class GestorRasilu implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private String rutaUsuario = "datos/usuario.dat";
    private int longMinContrasenaUsuario;
    private int longMinNombreUsuario;
    SimpleDateFormat formato;

    public GestorRasilu() {
        usuarios = new ArrayList<Usuario>();
        longMinContrasenaUsuario = 6;
        longMinNombreUsuario = 3;
        formato = new SimpleDateFormat("dd-MM-yyyy");
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

    public void guardarDatos() {
      try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaUsuario));
            oos.writeObject(usuarios);

        } catch (IOException ex) {
            System.err.println("Error al guardar al usuario" + ex.getMessage());
        }
    }

    // Metodo que coge el fichero donde están todos los objetos de usuario y lo guarda en una List de Usuario
    public void cargarUsuarios() {

        try ( ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(rutaUsuario))) {
            usuarios = (List<Usuario>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            usuarios = new ArrayList<Usuario>();
        }
    }

    // crearUsuario metodo que registra al usuario
    // Crear un nuevo usuario, y lo guarda en el fichero donde están todos los usuarios
    public void crearUsuario(String nombre, String contrasena, String contrasena2) throws IOException {
        // Booleano para comprobar si está bien el usuario
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
        // Creamos al usuario que lo añadimos a una List de objetos Usuario
        if (crear) {
            Usuario nuevo = new Usuario(nombre, contrasena);
            usuarios.add(nuevo);
            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
        }
        // Guardamos toda la List de Usuario y la escribimos en el fichero binario
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaUsuario));
            oos.writeObject(usuarios);

        } catch (IOException ex) {
            System.err.println("Error al guardar al usuario" + ex.getMessage());
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
   

    // Metodo que recoge un JDateChooser y proporciona un String con el formato predeterminado por nosotros
    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    // Metodo que recoge un String y lo transforma en un Date
    public Date StringDate(String fecha) {
        SimpleDateFormat formatoTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaE = null;

        try {
            fechaE = formatoTexto.parse(fecha);
            return fechaE;
        } catch (ParseException ex) {
            return null;
        }
    }
}
