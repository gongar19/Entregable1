package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorDeArchivosCSV {

    ArrayList<Alumno> alumnos =new ArrayList<>();
    public static final String SEPARATOR=",";
    public static final String QUOTE="\"";

    public LectorDeArchivosCSV() {
    }

    public ArrayList<Alumno> leerCSV() throws IOException {

    BufferedReader br = null;

        br = new BufferedReader(new FileReader("C:/Users/DH/Desktop/listadoDeAlumnos.csv"));

        String line = br.readLine();

        ArrayList<Alumno> alumnos = new ArrayList<>();

        line = br.readLine();

        while (null!=line) {
            String [] fields = line.split(SEPARATOR);

            fields = removeTrailingQuotes(fields);

            Integer codigo=Integer.valueOf(fields[0]);
            String nombre=fields[1];
            String apellido=fields[2];

            Alumno alumno = new Alumno(codigo,nombre,apellido);
            alumnos.add(alumno);
            line = br.readLine();
        }

        if (null!=br) {
            br.close();
        }

        return alumnos;
    }

    private static String[] removeTrailingQuotes(String[] fields) {

        String result[] = new String[fields.length];

        for (int i=0;i<result.length;i++){
            result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
        }
        return result;
    }
}
