package cuentasPersonales;

import cuentasPersonales.entities.Usuario;
import cuentasPersonales.servicios.UsuariosServices;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UsuariosServices userService = new UsuariosServices();
        userService.registrarUsuario(new Usuario("Camilo","Diaz",120000));
        userService.registrarUsuario(new Usuario("Claudia","Zapata",3500000));
        userService.registrarUsuario(new Usuario("Jurany","Hernandez",2500000));

        userService.listarUsuarios();
        userService.actualizarDinero("camilo", 75000);
        userService.eliminarUsuario("jurany");
        userService.listarUsuarios();
        System.out.println((userService.obtenerUsuario("camilo")));
    }
}