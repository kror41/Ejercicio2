package com.example.ejercicio2;

public class Persona {

    private String nombrePersona;
    private String descripcion;//no
    private String img;
    private String ciudad_de_nacimiento;
    private String matricula;
    private String expresion;//max 600 carateres min 200

    private int img2;//no

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

    public String getCiudad_de_nacimiento() {
        return ciudad_de_nacimiento;
    }

    public void setCiudad_de_nacimiento(String ciudad_de_nacimiento) {
        this.ciudad_de_nacimiento = ciudad_de_nacimiento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
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
    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }
}
