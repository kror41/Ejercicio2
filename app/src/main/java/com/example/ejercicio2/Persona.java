package com.example.ejercicio2;

public class Persona {

    private String nombrePersona;
    private String descripcion;
    private String img;

    public Persona(String nombrePersona, String descripcion, String img) {
        this.nombrePersona = nombrePersona;
        this.descripcion = descripcion;
        this.img = img;
    }
    public Persona(){}

    @Override
    public String toString(){

        return nombrePersona+" "+descripcion+" "+img;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
