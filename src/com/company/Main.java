package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        DigitalHouseManager digitalHouseManager = new DigitalHouseManager();


        //Agrego Profesores
        System.out.println("Alta de Profesores Titulares");
        digitalHouseManager.altaProfesorTitular("Maestro","Tabarez",1,"Futbol");
        digitalHouseManager.altaProfesorTitular("Jose","Cordo",2,"Medicina");

        System.out.println("");
        System.out.println("Alta de Profesores Adjunts");
        digitalHouseManager.altaProfesorAdjunto("Juan","Attach",3,25);
        digitalHouseManager.altaProfesorAdjunto("Jesica","Alegria",4,10);
        //Intento agregar un profesor existente
        digitalHouseManager.altaProfesorAdjunto("Profesor","Existente",2,10);

        System.out.println("");
        //Agrego cursos
        System.out.println("Alta de Cursos");
        digitalHouseManager.altaCurso("Full Stack",20001,3);
        digitalHouseManager.altaCurso("Android",20002,2);

        System.out.println("");
        //Asigno profesores
        System.out.println("Agrego Profesores");
        digitalHouseManager.asignarProfesores(20001,1,3);
        digitalHouseManager.asignarProfesores(20002,2,4);

        //Intento agregar un profesor que no existe y otro que no existe el curso
        digitalHouseManager.asignarProfesores(20003,2,4);
        digitalHouseManager.asignarProfesores(20002,8,4);

        //Agrego alumnos
        System.out.println("");
        System.out.println("Agrego Alumnos");
        digitalHouseManager.altaAlumno("Roberto","De Bruce",1);
        digitalHouseManager.altaAlumno("Jeremias","Grande",2);
        digitalHouseManager.altaAlumno("Juan","Domingo",3);
        //Intento agregar un alumno que ya existe
        digitalHouseManager.altaAlumno("Juan","Domingo",3);

        //Inscribo alumnos
        System.out.println("");
        System.out.println("Inscribo Alumnos");
        digitalHouseManager.inscribirAlumno(1,20001);
        digitalHouseManager.inscribirAlumno(2,20001);
        digitalHouseManager.inscribirAlumno(1,20002);
        digitalHouseManager.inscribirAlumno(2,20002);
        digitalHouseManager.inscribirAlumno(3,20002);

        //Elimino profesores
        System.out.println("");
        System.out.println("Baja de profesores");
        digitalHouseManager.bajaProfesor(4);
        digitalHouseManager.bajaProfesor(1);

        //Elimino cursos
        System.out.println("");
        System.out.println("Baja de cursos");
        digitalHouseManager.bajaCurso(20001);
        digitalHouseManager.bajaCurso(20002);
        digitalHouseManager.bajaCurso(20003);

        System.out.println("");
        System.out.println("Alta de Curso mobile android con mas cupo");
        digitalHouseManager.altaCurso("Android",20002,15);

        ArrayList<Alumno> alumnos2 = new ArrayList();

        LectorDeArchivosCSV lectorCSV = new LectorDeArchivosCSV();

        try {
            alumnos2=lectorCSV.leerCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        for(int i=0;i<alumnos2.size();i++){
            digitalHouseManager.altaAlumno(alumnos2.get(i).getNombre(),alumnos2.get(i).getApellido(),alumnos2.get(i).getCodigo());
        }
        for(int i=0;i<alumnos2.size();i++){
            digitalHouseManager.inscribirAlumno(alumnos2.get(i).getCodigo(),20002);
        }
    }

    //Parte K
    //1. ¿Cómo modificaría el diagrama de clases para que se le pueda consultar a un alumno a qué cursos está inscripto?
    // Responder a la pregunta en el archivo Main.java mediante un comentario.

    // Agregaría dentro de alumno una lista de cursos

}
