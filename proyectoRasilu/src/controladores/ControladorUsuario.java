/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.List;
import modelos.Usuario;

/**
 *
 * @author raqpu
 */
public class ControladorUsuario {

    private List<Usuario> usuarios;

    public ControladorUsuario() {
    }

    //Crear Usuario
    public void crearUsuario(String nombre, String email, String contraseña) {
        Usuario usuBuscar = new Usuario(nombre, email, contraseña);
        if (nombre.equals(contraseña)) {
            System.out.println("El nombre no puede ser igual a la contraseña");
        } else if (usuarios.contains(usuBuscar)){
            System.out.println("El usuario ya existe");
        } else if (nombre.isEmpty() || !nombreValido(nombre)){
            
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

    //Modificar Usuario 
    public void modificarUsuario(Usuario usu) {
        for (Usuario u : usuarios) {
            if (u.getId() == usu.getId()) {
                u.setNombre(usu.getNombre());
                u.setCorreoElectronico(usu.getCorreoElectronico());
                u.setContraseña(usu.getContraseña());
            } else {
                System.out.println("El usuario " + usu + "no se ha podido modificar correctamente");
            }
        }
    }
    //UsuarioExiste

    //ComprobadorContraseña
}
