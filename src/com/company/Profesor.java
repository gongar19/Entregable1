package com.company;

public class Profesor extends Persona {

    private Integer antiguedad;

    public Profesor(Integer codigo, String nombre, String apellido, Integer antiguedad) {
        super(codigo, nombre, apellido);
        this.antiguedad = antiguedad;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

}
