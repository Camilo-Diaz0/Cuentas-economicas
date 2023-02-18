package cuentasPersonales.swing;

import cuentasPersonales.entities.Usuario;
import cuentasPersonales.servicios.CalcularDinero;
import cuentasPersonales.servicios.UsuariosServices;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class CuentaFrame {
    public JPanel panelPrincial;
    public CalcularDinero calcular = new CalcularDinero();
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
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JPanel restar2;
    private JPanel restar3;

    public CuentaFrame(){
        setPropiedades();
        JPanel []arra = {sum1,sum2,sum3,restar1,restar2,restar3};
        Arrays.stream(arra).forEach(x -> x.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("clickeado");
                System.out.println(x.getSize().width);
                String identificador = x.getToolTipText();
                int valor = 0;
                Usuario usuario = null;

                try{
                    switch (identificador){
                        case "1":
                            System.out.println(text1.getText());
                            valor = Integer.parseInt(text1.getText());
                            usuario = userServices.obtenerUsuario(nombre1.getText());
                            text1.setText("");
                            break;
                        case "2":
                            System.out.println(text2.getText());
                            valor = Integer.parseInt(text2.getText());
                            usuario = userServices.obtenerUsuario(nombre2.getText());
                            text2.setText("");
                            break;
                        case "3":
                            System.out.println(text3.getText());
                            valor = Integer.parseInt(text3.getText());
                            usuario = userServices.obtenerUsuario(nombre3.getText());
                            text3.setText("");
                            break;
                    }

                    if(x.getSize().width == 70) {
                        calcularYActualizar(usuario, valor, "suma");
                    }else{
                        calcularYActualizar(usuario, valor, "Restar");
                    }
                    setPropiedades();
                }catch (NumberFormatException exc){
                    text1.setText("");
                    text2.setText("");
                    text3.setText("");
                }
            }
        }));

    }
    private void setPropiedades(){
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
    private void calcularYActualizar(Usuario usuario, int valor, String modo){
        int nuevoMonto = 0;
        if(modo.equals("suma")){
            nuevoMonto = calcular.sumarDinero(usuario.dinero,valor);
        } else {
            nuevoMonto = calcular.restarDinero(usuario.dinero,valor);
        }
        userServices.actualizarDinero(usuario.nombre,nuevoMonto);
    }
}
