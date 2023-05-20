/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Tarea;
import modelos.Usuario;

/**
 *
 * @author raqpu
 */
public class GestorRasilu {

    private List<Usuario> usuarios;
    private String rutaUsuario = new String("datos/usuario.dat");
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

    // Metodo para buscar usuario en la lista de usuario 
    public boolean buscarUsuario(String nombreUsuario) {
        boolean existe = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                existe = true;
            }
        }
        return existe;
    }

    // Metodo que busca un usuario en una lista de usuario y lo elimina
    public void eliminarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (buscarUsuario(nombreUsuario)) {
                usuarios.remove(usuario);
            }
        }
    }

    // 
    //Crear Usuario
    public void crearUsuario(List usuarios, String nombre, String contrasena, String contrasena2) {
        Usuario buscar = new Usuario(nombre, "");

        boolean crear = true;
        boolean formatoCorrecto = true;

        if (nombre.equals(contrasena)) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario no puede ser igual que la contraseña");
        } else {
            if (usuarios.contains(buscar)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
            } else {
                if (nombre.isEmpty() || !nombreValido(nombre)) {
                    JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario");
                    crear = false;
                    formatoCorrecto = false;
                } else if (contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe introducir una contraseña");
                    crear = false;
                    formatoCorrecto = false;
                } else if (contrasena2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe confirmar su contraseña");
                    crear = false;
                    formatoCorrecto = false;
                } else if (!contrasena.equals(contrasena2)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    crear = false;
                    formatoCorrecto = false;
                } else if (nombre.length() < longMinNombreUsuario) {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener al menos " + longMinNombreUsuario + " caracteres");
                    crear = false;
                    formatoCorrecto = false;
                } else if (contrasena.length() < longMinContrasenaUsuario) {
                    JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos " + longMinContrasenaUsuario + " caracteres");
                    crear = false;
                    formatoCorrecto = false;
                }

                if (crear) {
                    Usuario nuevo = new Usuario(nombre, contrasena, contrasena2);
                    usuarios.add(nuevo);

                    try ( ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File(rutaUsuario), false))) {
                        output.writeObject(usuarios);
                        JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
                        output.close();
                    } catch (IOException e) {
                        System.err.println("Error de escritura: " + e.getMessage());
                    }
                }
            }
        }
    }

    // Método que comprueba si el realmente se ha introducido caracteres
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

    //Modificar Usuario, modifica un usuario que se le pasa por parametro 
    public void modificarUsuario(Usuario usu) {
        for (Usuario u : usuarios) {
            if (buscarUsuario(usu.getNombre())) {
                u.setNombre(usu.getNombre());
                u.setContrasena(usu.getContrasena());
                u.setContasena2(usu.getContasena2());
                System.out.println("Usuario modificado correctamente");
            } else {
                System.out.println("El usuario " + usu + "no se ha podido modificar correctamente");
            }
        }
    }

    // Metodo que recoge los datos del fichero usuarios.dat y devuelve una lista de objetos usuario.
    public List<Usuario> cargarUsuarios() {
        // Pasamos por parametro un Usuario que añadimos List usuarios

        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(rutaUsuario)))) {
            while (ois.available() > 0) {
                usuarios = (List<Usuario>) ois.readObject();
            }
            System.out.println("Datos cargados correctamente");
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no existe: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de escritura del archivo: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error en el cast entre clases " + ex.getMessage());
        }
        return usuarios;
    }

    private boolean usuarioCorrecto(List<Usuario> usuarios, String nombre, String contrasena) {
        String usu = nombre + " : " + contrasena;
        String[] partes = usu.split(" : ");
        Usuario comprobar = new Usuario(partes[0], partes[1]);

        for (Object o : usuarios) {
            Usuario u = (Usuario) o;
            if (u.getNombre().toLowerCase().equals(comprobar.getNombre().toLowerCase()) && u.getContrasena().equals(comprobar.getContrasena())) {
                return true;
            }
        }
        return false;
    }

    // Acciones que va a tener las tareas
    // Añadir tarea
    public void agregarTarea(Tarea tarea, Usuario u) {
        if (siExisteTarea(tarea, u)) {
            System.out.println("La tarea ya existe");
        } else {
            u.setListaTareas((List<Tarea>) tarea);
        }
    }
    // Eliminar tarea

    public void eliminarTarea(Tarea tarea, Usuario u) {
        for (Tarea t : u.getListaTareas()) {
            if (t.getId() == tarea.getId()) {
                u.getListaTareas().remove(tarea);
            } else {
                System.out.println("La tarea no se ha podido eliminar");
            }
        }
    }

    private boolean siExisteTarea(Tarea tarea, Usuario u) {
        return u.getListaTareas().contains(tarea);
    }

    // Añadir una tarea a la lista de tarea de los usuariaos
    public void agregarTarea(Tarea t, String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                usuario.getListaTareas().add(t);
            }
        }

    }

    public void modifcarTarea(Tarea t, Usuario u) {

    }
}
