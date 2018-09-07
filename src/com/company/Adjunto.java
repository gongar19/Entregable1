package com.company;

public class Adjunto extends Profesor {

    private Integer horasConsulta;

    public Adjunto(Integer codigo, String nombre, String apellido, Integer antiguedad, Integer horasConsulta) {
        super(codigo, nombre, apellido, antiguedad);
        this.horasConsulta=horasConsulta;
    }

    public Integer getHorasConsulta() {
        return horasConsulta;
    }

    public void setHorasConsulta(Integer horasConsulta) {
        this.horasConsulta = horasConsulta;
    }

}
