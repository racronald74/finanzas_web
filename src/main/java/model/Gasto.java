package model;

/*
 * Clase que representa un gasto dentro del sistema.
 * Cada objeto Gasto almacena la información registrada
 * por el usuario desde el formulario web.
 */
public class Gasto {

    // Identificador único del gasto
    private int id;

    // Descripción del gasto
    private String descripcion;

    // Categoría del gasto
    private String categoria;

    // Valor monetario del gasto
    private double monto;

    /*
     * Constructor vacío.
     * Permite crear objetos sin inicializar atributos.
     */
    public Gasto() {
    }

    /*
     * Constructor completo.
     * Permite crear un gasto con todos sus datos.
     */
    public Gasto(int id, String descripcion, String categoria, double monto) {

        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.monto = monto;
    }

    // Obtiene el id del gasto
    public int getId() {
        return id;
    }

    // Asigna el id del gasto
    public void setId(int id) {
        this.id = id;
    }

    // Obtiene la descripción
    public String getDescripcion() {
        return descripcion;
    }

    // Asigna la descripción
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Obtiene la categoría
    public String getCategoria() {
        return categoria;
    }

    // Asigna la categoría
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Obtiene el monto
    public double getMonto() {
        return monto;
    }

    // Asigna el monto
    public void setMonto(double monto) {
        this.monto = monto;
    }
}