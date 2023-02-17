package cuentasPersonales.servicios;

import cuentasPersonales.entities.Usuario;
import cuentasPersonales.guardarInfo.ArrayDB;
import cuentasPersonales.guardarInfo.DB;
import cuentasPersonales.guardarInfo.FileDB;

import java.util.ArrayList;

public class UsuariosServices {
//    DB database = new ArrayDB();
    DB database = new FileDB();
    public UsuariosServices(){}
    public ArrayList<Usuario> devolverLista(){
        return database.leerUsuarios();
    }
    public Usuario obtenerUsuario(String nombre){
        for(Usuario temp : database.leerUsuarios()){
            if (temp.nombre.equalsIgnoreCase(nombre)){
                return temp;
            }
        }
        return null;
    }
    public void listarUsuarios(){

        ArrayList<Usuario> usuarios = database.leerUsuarios();

        for(Usuario temp : usuarios){
            System.out.println("-------------------------------");
            System.out.println(temp.nombre +"  "+ temp.apellido);
            System.out.println(temp.dinero + "\n");
        }
    }
    public void registrarUsuario(Usuario usuario){
        if (obtenerUsuario(usuario.nombre) != null){
            System.out.println("el usuario ya se encuentra registrado, prueba con otro nombre");
            return;
        }
        database.registrarUsuario(usuario);
    }
    public void eliminarUsuario(String nombre){
        for(Usuario actual : database.leerUsuarios()) {
            if (actual.nombre.equalsIgnoreCase(nombre)) {
                database.deleteUsuario(actual);
                return;
            }
        }
        System.out.println("el usuario " + nombre + "no se ha encontrado");
    }
    public void actualizarDinero(String nombre, int dinero){
       for(Usuario actual : database.leerUsuarios()){
           if(actual.nombre.equalsIgnoreCase(nombre)){
               database.updateUsuario(actual,dinero);
               return;
           }
       }
        System.out.println("el usuario " + nombre + "no se ha encontrado");
    }
}
