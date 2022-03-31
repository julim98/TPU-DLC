package soporte;

import clases.Documento;
import clases.Posteo;
import clases.Vocabulario;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class Indexador {

    private static HashSet<Documento> documentos = new HashSet<>();
    private static Hashtable<Integer,Vocabulario> vocabularioAux;
    private static Hashtable<Integer,Vocabulario> vocabulario = new Hashtable<>();
    private static HashSet<Posteo> posteos = new HashSet<>();

    /**
     * Comienza la indexacion de los archivos
     * @throws FileNotFoundException
     */
    public void indexar(String ruta) throws FileNotFoundException {

        Scanner docScan;
        File carpeta = new File(ruta);

        String palabra;
        System.out.println("Comenzando la indexacion de lo documentos\n" +
                "Por favor espere mientras se completa");

        int i = 0;

        //Recorre cada documento txt de la carpeta
        for (File docFile: Objects.requireNonNull(carpeta.listFiles((File pathname) -> pathname.getName().endsWith(".txt")))) {

            vocabularioAux = new Hashtable<>();
            Documento documento = new Documento(docFile.getPath(), docFile.getName());
            documentos.add(documento);
            docScan = new Scanner(docFile);

            //System.out.println("Comenzando lectuda del ducumento n°: "+ i + " " + docFile.getName());
            i++;

            //Recorre cada palabra del documento
            while (docScan.hasNext()) {

                palabra = docScan.next();
                int key = palabra.hashCode();

                //Pregunta si la palabra ya se encuentra y si lo esta aumenta su frecuencia y si no la agrega
                if (vocabularioAux.containsKey(key)) {
                    vocabularioAux.get(key).increaseMaxFrec();
                } else {
                    Vocabulario newTermino = new Vocabulario(palabra);
                    vocabularioAux.put(key, newTermino);
                    posteos.add(new Posteo(newTermino, documento));
                }
            }

            //Aca se controla si los terminos indexados en el documento ya se encontraban en el vocabulario y si lo
            // estaban se guada el de mayor frecuencia
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

    public HashSet<Documento> getDocumentos() {
        return documentos;
    }

    public Hashtable<Integer, Vocabulario> getVocabulario() {
        return vocabulario;
    }

    public HashSet<Posteo> getPosteos() {
        return posteos;
    }
}
