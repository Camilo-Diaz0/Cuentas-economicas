package cuentasPersonales.entities;



public class Usuario{
    public String nombre;
    public String apellido;
    public int dinero;

   public Usuario(){}
    public Usuario(String nombre, String apellido, int dinero){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Usuario actual : \n"  +
                "nombre : " + nombre + '\n' +
                "apellido = " + apellido + '\n' +
                "dinero = " + dinero;
    }
}
