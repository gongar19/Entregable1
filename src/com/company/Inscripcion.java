package com.company;

import java.util.Date;

public class Inscripcion {

    private Alumno alumno;
    private Curso curso;
    private Date fechaInscripcion;

    public Inscripcion(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.fechaInscripcion=new Date();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "alumno=" + alumno +
                ", curso=" + curso +
                ", fechaInscripcion=" + fechaInscripcion +
                '}';
    }
}
