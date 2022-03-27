package main;

import clases.Documento;

import java.awt.*;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Indexar {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        Scanner scan = new Scanner("D:\\Documents\\FACULTAD\\4°Año\\Diseño de Lenguajes de Consulta\\Trabajo Practico\\DocumentosTP1\\");
        File carpeta = new File("D:\\Documents\\FACULTAD\\4°Año\\Diseño de Lenguajes de Consulta\\Trabajo Practico\\DocumentosTP1\\");

      /*  HashSet setWords = new HashSet();

        for (File doc: Objects.requireNonNull(carpeta.listFiles())){

            System.out.println(doc.getName());
            Scanner documento = new Scanner(doc);


            while (documento.hasNext()) {
                //System.out.println("\t" + documento.next());
                setWords.add(documento.next());
            }
        }

        System.out.println("cant palabras: " + setWords.size());

        setWords.forEach(System.out::println);
        */
    }
}
