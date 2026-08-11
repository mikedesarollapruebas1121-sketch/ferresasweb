package model;

public class Productos
{
    //Atributos
    private int id_producto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int id_categorias;

    //Constructor
    public Productos(int id_producto, String nombre, String descripcion, double precio, int stock, int id_categorias)
    {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.id_categorias = id_categorias;
    }

    //Getters y Setters
    public int getId_producto()
    {
        return id_producto;
    }

    public void setId_producto(int id_producto)
    {
        this.id_producto = id_producto;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public int getId_categorias()
    {
        return id_categorias;
    }

    public void setId_categorias(int id_categorias)
    {
        this.id_categorias = id_categorias;
    }
}
