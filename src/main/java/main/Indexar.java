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
import java.util.*;

public class Indexar {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Indexador indexador = new Indexador();
        indexador.indexar(directoryPath());

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
                    indexador.getVocabulario().forEach((integer, termino) -> System.out.println(termino));
                    break;
                case 2:
                    System.out.println("Documentos: \n");
                    indexador.getDocumentos().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Posteos: \n");
                    indexador.getPosteos().forEach(System.out::println);
                    break;
                default:
                    return;
            }
        }
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
