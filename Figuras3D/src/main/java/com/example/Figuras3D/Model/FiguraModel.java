
package com.example.Figuras3D.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // libreria que ayuda a que no se rompa la conversion de de objetos a JSON
public class FiguraModel {
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo; // esfera, cubo, cilindro, persoanlizado
    private double altura;
    private double ancho;
    private double largo;
    private boolean estado; //figura de acción, coleccionable, etc
    private boolean condicion; //nuevo, usado

    //Contructor vacio util al momento de hacer el puente con fetch de js para conectar la API con la pagina web
    public FiguraModel() {
    }

    //Constructor con parametros para crear los objetos de la clase FiguraModel
    public FiguraModel(int id, String nombre, String descripcion, String tipo, double altura, double ancho, double largo, boolean estado, boolean condicion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
        this.estado = estado;
        this.condicion = condicion;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }
    
    
    
    
    
    
    
}
