package soporte;

import clases.Documento;
import clases.Posteo;
import clases.Vocabulario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Indexador {

    private static HashSet<Documento> documentos = new HashSet<>();
    private static Hashtable<Integer,Vocabulario> vocabularioAux;
    private static Hashtable<Integer,Vocabulario> vocabulario = new Hashtable<>();
    private static Hashtable<Integer,Posteo> posteos = new Hashtable<>();

    /**
     * Comienza la indexacion de los archivos
     * @throws FileNotFoundException
     */
    public void indexar(String ruta) throws IOException {

        Scanner scanDocumentoActual;
        File carpeta = new File(ruta);
        String palabra;
        int i = 1;

        //Recorre cada documento ".txt" de la carpeta
        for (File file: Objects.requireNonNull(carpeta.listFiles((File pathname) -> pathname.getName().endsWith(".txt")))){

            vocabularioAux = new Hashtable<>();

            //Creo una Instancia de Documento con las datos del archivo que se esta leyendo
            Documento documento = new Documento(file.getName(),file.getPath(), new Date(file.lastModified()));

            //Se agrega el documento al verctor de documentos
            documentos.add(documento);

            //Se crea un Scanner que nos permitira leer el documento actual
//            scanDocumentoActual = new Scanner(file, StandardCharsets.ISO_8859_1);
            scanDocumentoActual = new Scanner(file, StandardCharsets.UTF_8);
            //System.out.println("Comenzando lectuda del ducumento n°: "+ i + " " + file.getName());
            i++;

            //Recorre cada palabra del documento
            while (scanDocumentoActual.hasNext()) {

                palabra = scanDocumentoActual.next();

                //Obtengo el hashcode de la palabra actual
                int key = palabra.hashCode();

                //Pregunta si la palabra ya se encuentra y si lo esta aumenta su frecuencia y si no la agrega
                if (vocabularioAux.containsKey(key)) {
                    vocabularioAux.get(key).increaseMaxFrec();
                } else {
                    Vocabulario newTermino = new Vocabulario(palabra);
                    vocabularioAux.put(key, newTermino);
                }
            }

            //Aca se controla si los terminos indexados en el documento ya se encontraban en el vocabulario y si lo
            // estaban se guada el de mayor frecuencia

            if (!vocabulario.isEmpty()) {
                int maxFrecPalabra;
                int maxFrecPalabraAux;

                for (Vocabulario terminoAux : vocabularioAux.values()) {

                    Vocabulario termino = vocabulario.get(terminoAux.getPalabra().hashCode());
                    if (termino != null) {
                        termino.increaseCantDoc();

                        maxFrecPalabra = termino.getMaxFrecuenciaPalabra();
                        maxFrecPalabraAux = terminoAux.getMaxFrecuenciaPalabra();

                        if (maxFrecPalabra < maxFrecPalabraAux) {
                            termino.setMaxFrecuenciaPalabra(maxFrecPalabraAux);
                        }
                    } else {
                        vocabulario.put(terminoAux.getPalabra().hashCode(), terminoAux);
                    }
                }
            } else {
                vocabulario = new Hashtable<>(vocabularioAux);
                }

            for (Integer key : vocabularioAux.keySet()) {
                //Se crea el posteo del temino junto con el documento en el que aparece y la frecuencia en este
                Vocabulario terminoAux = vocabulario.get(key);
                Posteo posteo = new Posteo(terminoAux, documento, terminoAux.getMaxFrecuenciaPalabra());
                posteos.put(posteo.hashCode(), posteo);
            }
        }
        actualizarPeso();
    }



    public HashSet<Documento> getDocumentos() {
        return documentos;
    }

    public Hashtable<Integer, Vocabulario> getVocabulario() {
        return vocabulario;
    }

    public Hashtable<Integer, Posteo> getPosteos() {
        return posteos;
    }


    public boolean checkChanges(){
        return true;
    }

    private void actualizarPeso(){

        // hay un problema con el vocabulario, en algunas palabras sale que sale en 1 documento cuando sale en 2, creo que se crean 2 veces la misma palabra.
        for (Posteo p : posteos.values()
             ) {
            p.calcularPeso();
        }
    }
}
