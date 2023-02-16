package cuentasPersonales.guardarInfo;

import cuentasPersonales.entities.Usuario;

import java.util.ArrayList;

public class ArrayDB implements DB {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    public ArrayDB(){}
    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("usuario registrado: " + usuario.nombre);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("usuario removido");

    }

    @Override
    public ArrayList<Usuario> leerUsuarios() {
        return usuarios;
    }

    @Override
    public void updateUsuario(Usuario usuario, int dinero) {
        usuario.dinero = dinero;
        System.out.println("dinero actualizado");
    }
}
