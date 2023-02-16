package cuentasPersonales.guardarInfo;

import cuentasPersonales.entities.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDB implements DB{
    public String filetype = "cuenta.txt";
    //ArrayList<Usuario> usuarios = new ArrayList<>();
    public FileDB(){}
    public String transformarUsuario(Usuario usuario){
        return    usuario.nombre + "-"
                + usuario.apellido + "-"
                + usuario.dinero ;
    }
    public void actualizarArchivo(ArrayList<Usuario> usuarios){
        try {
            PrintStream printStream = new PrintStream(filetype);
            for(Usuario actual : usuarios){
                printStream.println(transformarUsuario(actual));
                printStream.flush();
            }
            printStream.close();
        }catch (FileNotFoundException e){
            System.out.println("archivo no encotrado: " + e.getMessage());
        }
    }
    @Override
    public ArrayList<Usuario> leerUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(filetype));
            while (scanner.hasNext()){
                String usuarioActual = scanner.next();
                String []partes = usuarioActual.split("-");
                Usuario usuario = new Usuario();
                usuario.nombre = partes[0];
                usuario.apellido = partes[1];
                usuario.dinero =Integer.parseInt(partes[2]);

                usuarios.add(usuario);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("archivo no encontrado: " + e.getMessage());
        }
        return usuarios;
    }
    @Override
    public void registrarUsuario(Usuario usuario){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filetype, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(transformarUsuario(usuario));
            printStream.flush();
            printStream.close();
        }catch (FileNotFoundException e){
            System.out.println("archivo no encotrado:" + e.getMessage());
        }
    }
    @Override
    public void updateUsuario(Usuario usuario, int dinero){
        ArrayList<Usuario> usuarios = leerUsuarios();
        for (Usuario actual : usuarios){
            if(actual.nombre.equalsIgnoreCase(usuario.nombre)){
                actual.dinero = dinero;
            }
        }
        actualizarArchivo(usuarios);

    }
    @Override
    public void deleteUsuario(Usuario usuario){
        ArrayList<Usuario> usuarios = leerUsuarios();
        for(Usuario actual : usuarios){
            if(actual.nombre.equalsIgnoreCase(usuario.nombre)){
                usuarios.remove(actual);
                actualizarArchivo(usuarios);
                return;
            }
        }


    }

}
