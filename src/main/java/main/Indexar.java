package main;

import clases.Documento;
import clases.Posteo;
import clases.Vocabulario;
import soporte.Indexador;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

public class Indexar {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Indexador indexador = new Indexador();
        String path = directoryPath();

        Runnable indexar = () -> {
            try {
                indexador.indexar(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };


        Runnable menu = () -> {

            HashSet<Documento> documentos = indexador.getDocumentos();
            Hashtable<Integer,Vocabulario> vocabulario = indexador.getVocabulario();
            Hashtable<Integer, Posteo> posteos = indexador.getPosteos();

            while (true) {
                System.out.println("Opciones\n");
                System.out.println("1 - Mostrar Vocabulario");
                System.out.println("2 - Mostrar Documentos");
                System.out.println("3 - Mostrar Posteos");
                System.out.println("4 - Salir");

                System.out.print("\nIngrese una opcion: ");
                int opcion = scanner.nextInt();
                System.out.println("\n");

                switch (opcion) {
                    case 1:
                        System.out.println("Vocabulario: \n");
                        vocabulario.forEach((integer, termino) -> System.out.println(termino));
                        break;
                    case 2:
                        System.out.println("Documentos: \n");
                        documentos.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Posteos: \n");
                        posteos.forEach((integer, termino) -> System.out.println(termino));
                        break;
                    default:
                        return;
                }
            }
        };

        indexar.run();
        menu.run();
    }

    /**
     * Abre una ventana donde se solicita que se seleccione una carpeta
     * @return devuelve la ruta del directorio seleccionado
     */
    public static String directoryPath(){
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.showOpenDialog(directoryChooser);
        return String.valueOf(directoryChooser.getSelectedFile());
    }
}
