package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Curso {

    private Integer codigo;
    private String nombre;
    private Titular titular;
    private Adjunto adjunto;
    private Integer cupoMaximo;
    private ArrayList<Alumno> alumnos = new ArrayList<>();

    public Curso(Integer codigo, String nombre, Titular titular, Adjunto adjunto, Integer cupoMaximo, ArrayList<Alumno> alumnos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titular = titular;
        this.adjunto = adjunto;
        this.alumnos = alumnos;
        this.cupoMaximo=cupoMaximo;
    }

    public Curso(String nombre, Integer codigo, Integer cupoMaximo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
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

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Adjunto getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(Adjunto adjunto) {
        this.adjunto = adjunto;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Integer getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(Integer cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public Boolean agregarUnAlumno(Alumno alumno){
        if(alumnos.size()<cupoMaximo){
            alumnos.add(alumno);
            System.out.println("Se agregó al alumno "+alumno.toString()+" en el curso "+this.nombre+" quedan "+ (cupoMaximo-alumnos.size())+" vacantes");
            return true;
        }else {
            System.out.println("No hay cupo disponible");
            return false;
        }
    }

    public void eliminarAlumno(Alumno unAlumno){
        Boolean existeAlumno=false;

        for(int i=0;i<alumnos.size();i++){
            if(alumnos.get(i).equals(unAlumno)){
                alumnos.remove(i);
                System.out.println("Se eliminó al alumno "+unAlumno.toString()+" del curso"+this.nombre+" quedan "+ (cupoMaximo-alumnos.size())+" vacantes");
                existeAlumno=true;
            }
        }
        if(!existeAlumno){
            System.out.println("No se encontró al alumno "+unAlumno.toString()+" en el curso"+this.nombre);
        }
    }

    @Override
    public boolean equals(Object obj) {

        Curso curso = (Curso) obj;

        return super.equals(this.codigo==curso.codigo);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cupoMaximo='" + cupoMaximo + '\'' +
                '}';
    }
}
