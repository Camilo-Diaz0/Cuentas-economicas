package cuentasPersonales.guardarInfo;

import cuentasPersonales.entities.Usuario;

import java.util.ArrayList;

public interface DB {
    void registrarUsuario(Usuario usuario);
    ArrayList<Usuario> leerUsuarios();
    void updateUsuario(Usuario usuario, int dinero);
    void deleteUsuario(Usuario usuario);
}
