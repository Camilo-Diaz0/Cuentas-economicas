package cuentasPersonales.swing;

import cuentasPersonales.entities.Usuario;
import cuentasPersonales.servicios.UsuariosServices;

import javax.swing.*;
import java.util.ArrayList;

public class CuentaFrame {
    public JPanel panelPrincial;
    public UsuariosServices userServices = new UsuariosServices();
    private JLabel nombre1;
    private JLabel nombre2;
    private JLabel nombre3;
    private JLabel dinero1;
    private JLabel dinero2;
    private JLabel dinero3;
    private JPanel sum1;
    private JPanel restar1;
    private JPanel sum2;
    private JPanel sum3;
    private JPanel restar2;
    private JPanel restar3;

    public CuentaFrame(){
        ArrayList<JLabel> etiquetas = new ArrayList<>();
        etiquetas.add(nombre1);
        etiquetas.add(nombre2);
        etiquetas.add(nombre3);
        etiquetas.add(dinero1);
        etiquetas.add(dinero2);
        etiquetas.add(dinero3);
        ArrayList<Usuario> usuarios = userServices.devolverLista();
        for(int i = 0; i < 3; i++){
            etiquetas.get(i).setText(usuarios.get(i).nombre);
            etiquetas.get(i+3).setText(String.valueOf(usuarios.get(i).dinero));
        }
    }

}
