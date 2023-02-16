package cuentasPersonales;

import cuentasPersonales.swing.CuentaFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
/*        System.out.println("Hello world!");
        UsuariosServices userService = new UsuariosServices();
        userService.registrarUsuario(new Usuario("Camilo","Diaz",120000));
        userService.registrarUsuario(new Usuario("Claudia","Zapata",3500000));
        userService.registrarUsuario(new Usuario("Jurany","Hernandez",2500000));

        userService.listarUsuarios();
        userService.actualizarDinero("camilo", 75000);
        userService.eliminarUsuario("jurany");
        userService.listarUsuarios();
        System.out.println((userService.obtenerUsuario("camilo")));*/
        JFrame frame = new JFrame("swingInter");
        frame.setContentPane(new CuentaFrame().panelPrincial);
        frame.setVisible(true);
        frame.setSize(450,450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}