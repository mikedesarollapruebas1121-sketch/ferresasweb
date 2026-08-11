package model;

public class Clientes
{
    //Atributos
    private int id_cliente;
    private String nombre;
    private String documento;
    private String telefono;
    private String direccion;
    private String correo;

    //Constructor
    public Clientes(String correo, String direccion, String documento, int id_cliente, String nombre, String telefono) {
        this.correo = correo;
        this.direccion = direccion;
        this.documento = documento;
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //Getters y Setters
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
