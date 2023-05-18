/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import modelos.Usuario;

/**
 *
 * @author raqpu
 */
public class ControladorUsuario implements Serializable {

    private static List<Usuario> usuarios;
    private static String rutaUsuario = new String ("datos/usuario.dat");
    
    public ControladorUsuario() {
    }

    //Crear Usuario
    public void crearUsuario(String nombre, String contrasena, String contrasena2) {
        Usuario usuBuscar = new Usuario(nombre, contrasena, contrasena2);

        if (nombre.equals(contrasena)) {
            System.out.println("El nombre no puede ser igual a la contraseña");
        } else if (usuarios.contains(usuBuscar)) {
            System.out.println("El usuario ya existe");
        } else if (!nombreValido(nombre)) {
            System.out.println("El nombre no es válido");
        } else if (contrasena.length() < 9) {
            System.out.println("La contraseña debe contener al menos 8 caracteres");
        } else if (!contrasena.equals(contrasena2)) {
            System.out.println("Las dos contraseñas deben coincidir");
        } else {
            Usuario nuevo = new Usuario(nombre, contrasena, contrasena2);
            usuarios.add(nuevo);
        }
    }

    /*
    * Comprobar que el nombre es valido:
    *     Si esta vacio
    *     Son caracteres
    *     No es null
     */
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
            if (isExistsUsuario(usu)) {
                u.setNombre(usu.getNombre());
                u.setContrasena(usu.getContrasena());
                u.setContasena2(usu.getContasena2());
            } else {
                System.out.println("El usuario " + usu + "no se ha podido modificar correctamente");
            }
        }
    }

    //UsuarioExiste
    public boolean isExistsUsuario(Usuario usu) {
        return usuarios.contains(usu);
    }
    
     public static void guardarDatos(List<Usuario> usu) {
        try {
            ObjectOutputStream salida;
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaUsuario)));
            salida.writeObject(usu);
            salida.close();
        } catch (IOException ex) {
            System.err.println("Error al guardar datos: " + ex.getMessage());
        }
    }
    
}
