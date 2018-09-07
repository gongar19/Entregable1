package com.company;

public class Titular extends Profesor {

    private String especialidad;

    public Titular(Integer codigo, String nombre, String apellido, Integer antiguedad, String especialidad) {
        super(codigo, nombre, apellido, antiguedad);
        this.especialidad=especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
