package com.example.ejercicio2;

public class Persona {

    private String nombrePersona;
    private String descripcion;
    private String img;

    private int img2;

    public Persona(int img2, String nombrePersona, String descripcion, String img) {
        this.img2 = img2;
        this.nombrePersona = nombrePersona;
        this.descripcion = descripcion;
        this.img = img;
    }

    public Persona(){}

   /* @Override
    public String toString(){

        return img2+" "+nombrePersona+" "+descripcion+" "+img;
    }*/

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
    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }
}
