///*
// *
// */
//package controladores;
//
//import java.io.*;
//
///**
// *
// * @author Lucia
// */
//public class ControladorFile {
//    
//    private String rutaTarea = new String ("datos/tarea.dat");
//    
//    public ControladorFile (String rutaUsuario, String rutaTarea){
//        this.rutaUsuario = rutaUsuario;
//        this.rutaTarea = rutaTarea;
//    }
//    
//    // Contrucci�n por defecto
//    public ControladorFile(){
//        this ("datos/usuario.dat", "datos/tarea.dat");
//    }
//    
//    /*  
//     * Este m�todo carga los datos guardados en el archivo "usuario.dat" y devuelve un objeto ControladorFile.
//    */
//    public static ControladorFile cargarDatos() throws IOException {
//        ControladorFile e;
//        try {
//            // Creamos un ObjectInputStream para leer el archivo "usuario.dat"
//            ObjectInputStream entrada = 
////                    new ObjectInputStream(new FileInputStream(rutaUsuario));
//            // Leemos el objeto ControladorFile del archivo
//            e = (ControladorFile)entrada.readObject();
//            // Cerramos el flujo de entrada
//            entrada.close();
//        } catch (IOException | ClassNotFoundException ex) {
//            // Si hay alg�n problema al leer el archivo, creamos un nuevo objeto ControladorFile vac�o
//            e = new ControladorFile();
//        }
//        // Devolvemos el objeto ControladorFile.
//        return e;
//    }
//   
//    /*
//     *  Este m�todo guarda los datos de un objeto ControladorFile en el archivo "usuario.dat".
//    */
//    public static void guardarDatosUsuario(ControladorFile e) {
//        try {
//            // Creamos un ObjectOutputStream para escribir en el archivo "usuario.dat"
//            ObjectOutputStream salida = 
//                    new ObjectOutputStream(new FileOutputStream("usuario.dat"));
//            // Escribimos el objeto ControladorFile en el archivo
//            salida.writeObject(e);
//            // Cerramos el flujo de salida
//            salida.close();
//        } catch (IOException ex) {
//            // Si hay alg�n problema al guardar los datos, mostramos un mensaje de error
//            System.err.println("Error al guardar datos: " + ex.getMessage());
//        }        
//    }
//
//    /*  
//     * Este m�todo carga los datos guardados en el archivo "tarea.dat" y devuelve un objeto ControladorFile.
//    */
//    public static ControladorFile cargarDatosTarea() throws IOException { 
//        ControladorFile e;
//        try {
//            // Creamos un ObjectInputStream para leer el archivo "tarea.dat"
//            ObjectInputStream entrada = 
//                    new ObjectInputStream(new FileInputStream("tarea.dat"));
//            // Leemos el objeto ControladorFile del archivo
//            e = (ControladorFile)entrada.readObject();
//            // Cerramos el flujo de entrada
//            entrada.close();
//        } catch (IOException | ClassNotFoundException ex) {
//            // Devolvemos el objeto ControladorFile le�do o creado
//            e = new ControladorFile();
//        }
//        return e;        
//    }
//
//    /*
//     *  Este m�todo guarda los datos de un objeto ControladorFile en el archivo "tarea.dat". 
//    */
//    public static void guardarDatosTarea(ControladorFile e) {
//        try {
//            // Creamos un ObjectOutputStream para escribir en el archivo "tarea.dat"
//            ObjectOutputStream salida = 
//                    new ObjectOutputStream(new FileOutputStream("tarea.dat"));
//            // Escribimos el objeto ControladorFile en el archivo
//            salida.writeObject(e);
//            // Cerramos el flujo de salida
//            salida.close();
//        } catch (IOException ex) {
//            // Si hay alg�n problema al guardar los datos, mostramos un mensaje de error
//            System.err.println("Error al guardar datos: " + ex.getMessage());
//        }         
//    }
//   
//}
//
