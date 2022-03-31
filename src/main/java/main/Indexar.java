package main;

import clases.Documento;
import clases.Posteo;
import clases.Vocabulario;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Indexar {

    private static HashSet<Documento> documentos = new HashSet<>();
    private static Hashtable<Integer,Vocabulario> vocabularioAux;
    private static Hashtable<Integer,Vocabulario> vocabulario = new Hashtable<>();
    private static HashSet<Posteo> posteos = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        indexar();

        while (true) {
            System.out.println("Opciones\n");
            System.out.println("1 - Mostrar vocabulario");
            System.out.println("2 - Mostrar Documentos");
            System.out.println("3 - Mostrar Posteos");
            System.out.println("4 - Salir");

            System.out.print("\nIngrese una opcion: ");
            int opcion = scanner.nextInt();
            System.out.println("\n");

            switch (opcion) {
                case 1:
                    System.out.println("Vocabulario: \n");
                    vocabulario.forEach((integer, terminos) -> System.out.println());
                    System.out.println("Cantidad de Terminos: " + vocabulario.size());
                    break;
                case 2:
                    System.out.println("Documentos: \n");
                    documentos.forEach(System.out::println);
                    System.out.println("Cantidad de documentos: " + documentos.size());
                    break;
                case 3:
                    System.out.println("Posteos: \n");
                    posteos.forEach(System.out::println);
                    System.out.println("Cantidad de Posteos: " + posteos.size());
                    break;
                default:
                    return;
            }
        }
    }

    public static void indexar() throws FileNotFoundException {

        Scanner docScan;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(fileChooser);
        String ruta = fileChooser.getCurrentDirectory().getPath();

        File carpeta = new File(ruta);

        String palabra;

        System.out.println("Comenzando la indexacion de lo documentos\n" +
                "Por favor espere mientras se completa");

        int i = 0;
        //Recorre un solo doc
        for (File docFile: Objects.requireNonNull(carpeta.listFiles())) {

            vocabularioAux = new Hashtable<>();
            Documento documento = new Documento(docFile.getPath(), docFile.getName());
            documentos.add(documento);
            docScan = new Scanner(docFile);

            //System.out.println("Comenzando lectuda del ducumento n°: "+ i + " " + docFile.getName());
            i++;
            while (docScan.hasNext()) {

                palabra = docScan.next();
                int key = palabra.hashCode();


                if (vocabularioAux.containsKey(key)) {
                    vocabularioAux.get(key).increaseMaxFrec();
                } else {
                    Vocabulario newTermino = new Vocabulario(palabra);
                    vocabularioAux.put(key, newTermino);
                    posteos.add(new Posteo(newTermino, documento));
                }
            }



            if (!vocabulario.isEmpty())
            {
                int maxFrecPalabra;
                int maxFrecPalabraAux;

                for (Vocabulario terminoAux: vocabularioAux.values()) {
                    Vocabulario termino = vocabulario.get(terminoAux.getPalabra().hashCode());
                    if (termino != null)
                    {
                        termino.increaseCantDoc();

                        maxFrecPalabra = termino.getMaxFrecuenciaPalabra();
                        maxFrecPalabraAux = terminoAux.getMaxFrecuenciaPalabra();
                        if (maxFrecPalabra < maxFrecPalabraAux)
                        {
                            termino.setMaxFrecuenciaPalabra(maxFrecPalabraAux);
                        }
                    }
                    else {
                        vocabulario.put(terminoAux.getPalabra().hashCode(), terminoAux);
                    }
                }
            }else {
                vocabulario = new Hashtable<>(vocabularioAux);
            }
        }
    }
}
