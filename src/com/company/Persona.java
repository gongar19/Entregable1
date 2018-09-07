package com.company;

public class Persona {

    private Integer codigo;
    private String nombre;
    private String apellido;

    public Persona(Integer codigo, String nombre, String apellido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object obj) {

        Persona persona = (Persona) obj;
        return (this.codigo==persona.codigo);
    }

    @Override
    public String toString() {
        return "{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
