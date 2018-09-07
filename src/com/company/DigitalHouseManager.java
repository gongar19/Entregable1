package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Alumno> alumnos = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public DigitalHouseManager(){

    }

    public DigitalHouseManager(List<Alumno> alumnos, List<Profesor> profesores, List<Curso> cursos, List<Inscripcion> inscripciones) {
        this.alumnos = alumnos;
        this.profesores = profesores;
        this.cursos = cursos;
        this.inscripciones = inscripciones;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void altaCurso(String nombre, Integer codigoCurso, Integer cupoMaximoDealumnos){
        Curso curso = new Curso(nombre,codigoCurso,cupoMaximoDealumnos);
        Boolean existeCurso=false;
        for(int i=0;i<cursos.size();i++){
            if(cursos.get(i).equals(curso)){
                System.out.println("Ya existe el curso que quiere dar de alta");
                existeCurso=true;
            }
        }
        if(!existeCurso){
            cursos.add(curso);
            System.out.println("Se dio de alta el curso: "+curso.toString());
        }
    }

    public void bajaCurso(Integer codigoCurso){
        Boolean existeCurso=false;
        for(int i=0;i<cursos.size();i++){
            if(cursos.get(i).getCodigo().equals(codigoCurso)){
                System.out.println("Se dio de baja el curso: "+cursos.get(i).toString());
                cursos.remove(i);
                existeCurso=true;
            }
        }
        if(!existeCurso){
            System.out.println("No existe el curso que quiere dar de baja");
        }
    }

    public void altaProfesorAdjunto(String nombre, String apellido, Integer codigoProfesor, Integer cantidadDeHoras){
        Boolean existeProfesor=false;
        Adjunto profesorAdjunto = new Adjunto(codigoProfesor,nombre,apellido,0,cantidadDeHoras);
        for(int i=0;i<profesores.size();i++){
            if(profesores.get(i).equals(profesorAdjunto)){
                System.out.println("Ya existe el profesor que quiere dar de alta");
                existeProfesor=true;
            }
        }
        if(!existeProfesor){
            profesores.add(profesorAdjunto);
            System.out.println("Se dio de alta el profesor "+profesorAdjunto.toString());
        }
    }

    public void altaProfesorTitular(String nombre, String apellido, Integer codigoProfesor, String especialidad){
        Boolean existeProfesor=false;
        Titular profesorTitular = new Titular(codigoProfesor,nombre,apellido,0,especialidad);
        for(int i=0;i<profesores.size();i++){
            if(profesores.get(i).equals(profesorTitular)){
                System.out.println("Ya existe el profesor que quiere dar de alta");
                existeProfesor=true;
            }
        }
        if(!existeProfesor){
            profesores.add(profesorTitular);
            System.out.println("Se dio de alta el profesor "+profesorTitular.toString());
        }
    }

    public void bajaProfesor(Integer codigoProfesor){
        Boolean existeProfesor=false;
        for(int i=0;i<profesores.size();i++){
            if(profesores.get(i).getCodigo().equals(codigoProfesor)){
                System.out.println("Se dio de baja el profesor "+profesores.get(i).toString());
                profesores.remove(i);
                existeProfesor=true;
            }
        }
        if(!existeProfesor){
            System.out.println("No existe el progesor que quiere dar de baja");
        }
    }

    public void altaAlumno(String nombre, String apellido, Integer codigoAlumno){
        Alumno alumno = new Alumno(codigoAlumno,nombre,apellido);
        Boolean existeAlumno=false;
        for(int i=0;i<alumnos.size();i++){
            if(alumnos.get(i).equals(alumno)){
                System.out.println("Ya existe el alumno que quiere dar de alta");
                existeAlumno=true;
            }
        }
        if(!existeAlumno){
            alumnos.add(alumno);
            System.out.println("Se dio de alta el alumno "+alumno.toString());
        }
    }

    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso){

        Boolean existeCurso=false,existeAlumno=false;

        for(int i=0;i<cursos.size();i++){

            if(cursos.get(i).getCodigo().equals(codigoCurso)){
                existeCurso=true;
                for(int j=0;j<alumnos.size();j++){
                    if(alumnos.get(j).getCodigo().equals(codigoAlumno)){
                        existeAlumno=true;
                        if(cursos.get(i).agregarUnAlumno(alumnos.get(j))){
                            Inscripcion inscripcion = new Inscripcion(alumnos.get(j),cursos.get(i));
                            inscripcion.toString();
                            System.out.println("La inscripción fue realizada correctamente");
                        }
                    }
                }
            }
        }
        if(!existeAlumno&&!existeCurso){
            System.out.println("No se realizó la inscripción - No existe el alumno/curso");
        }else if(!existeAlumno){
            System.out.println("No se realizó la inscripción - No existe el alumno");
        }else if(!existeCurso){
            System.out.println("No se realizó la inscripción - No existe el curso");
        }
    }

    public void asignarProfesores(Integer codigoCurso, Integer codigoProfesorTitular, Integer codigoProfesorAdjunto){

        Boolean existeTitular=false,existeAdjunto=false,existeCurso=false;

        for(int i=0;i<profesores.size();i++){
            if(profesores.get(i).getCodigo().equals(codigoProfesorTitular)){
                existeTitular=true;
                for(int j=0;j<profesores.size();j++){
                    if(profesores.get(j).getCodigo().equals(codigoProfesorAdjunto)){
                        existeAdjunto=true;
                        for(int k=0;k<cursos.size();k++){
                            if(cursos.get(k).getCodigo().equals(codigoCurso)){
                                existeCurso=true;
                                cursos.get(k).setTitular((Titular) profesores.get(i));
                                cursos.get(k).setAdjunto((Adjunto) profesores.get(j));
                                System.out.println("Se agregaron los profesores "+profesores.get(i).toString()+" y "+profesores.get(j).toString()+" al curso");
                            }
                        }
                    }
                }
            }
        }
        if(!existeTitular||!existeCurso||!existeAdjunto){
            System.out.println("No se realizó la inscripción - No existe profesores/curso");
        }
    }
}
