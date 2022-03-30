package main;

import clases.Documento;
import clases.Posteo;
import clases.Vocabulario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Indexar {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        Scanner docScan;
        File carpeta = new File("D:\\Documents\\FACULTAD\\4°Año\\Diseño de Lenguajes de Consulta\\Trabajo Practico\\DocumentosTP1\\");

        HashSet<Documento> documentos = new HashSet<>();
        Hashtable<Integer,Vocabulario> vocabularioAux = new Hashtable<>();
        Hashtable<Integer,Vocabulario> vocabulario = new Hashtable<>();
        //HashSet<String> palabras = new HashSet<>();
        HashSet<Posteo> posteos = new HashSet<>();

        String palabra;

        //Recorre un solo doc
        File[] requireNonNull = Objects.requireNonNull(carpeta.listFiles());
        for (int i = 0; i < 2; i++) {
            File docFile = requireNonNull[i];
            vocabularioAux = new Hashtable<>();
            Documento documento = new Documento(docFile.getPath(), docFile.getName());
            documentos.add(documento);
            docScan = new Scanner(docFile);

            while (docScan.hasNext()) {

                palabra = docScan.next();
                int key = palabra.hashCode();

                if (vocabularioAux.containsKey(key)) {
                    vocabularioAux.get(key).increaseMaxFrec();
                } else {
                    vocabularioAux.put(key, new Vocabulario(palabra));
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


        //Recorre todos lo documentos
       /* for (File docFile: Objects.requireNonNull(carpeta.listFiles())) {
            documentos.add(new Documento(docFile.getPath(), docFile.getName()));
            doc = new Scanner(docFile.getPath());

            while (doc.hasNext()){
                palabra = doc.next();
                int key = palabra.hashCode();

                if (vocabularioAux.containsKey(key)){
                    Vocabulario voc = vocabularioAux.get(key);
                    voc.increaseCantDoc();
                    voc.increaseMaxFrec();
                }
                else {
                    vocabularioAux.put(key, new Vocabulario(palabra));
                }
            }
        }*/

        System.out.println("Cantidad de documentos: " + documentos.size());

        System.out.println("\nDocumentos");
        for (Documento documento: documentos) {
            System.out.println(documento);
        }


        System.out.println("\nVocabulario tamaño");
        System.out.println(vocabulario.size());


        System.out.println("\nVocabulario");
        for (Vocabulario voc: vocabulario.values()) {
            System.out.println(voc);
        }



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
