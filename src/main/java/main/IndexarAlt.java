package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IndexarAlt {
    public static void main(String[] args) throws IOException {


        String path = "D:\\Documents\\FACULTAD\\4°Año\\Diseño de Lenguajes de Consulta\\Trabajo Practico\\DocumentosTP1\\00ws110.txt";

        Scanner scan = new Scanner(new File(path), StandardCharsets.ISO_8859_1);
        //scan.useDelimiter("[^\\w]");

        Stream<String> palabras = scan.tokens().map(s -> {
            //System.out.println("palabra: " + s);
            char[] characters = s.toCharArray();
            for (char c : characters) {
                int value = c;
                //System.out.println("caracter: "  + c);
                //System.out.println(value);
                if ((value >= 48 & value <= 57) || (value >= 65 & value <= 90) || (value >= 97 && value <= 122) ||
                    (value >= 128 & value <= 165) || (value >= 208 & value <= 216) || (value >= 224 & value <= 237))
                {
                    break;
                }
            }
            if (s.endsWith(",")) {
                return s.replace(",", "");
            }
            return "";
        });
        //palabras.forEach(System.out::println);

        //Utilizando Set
        //Set<String> terminos = palabras.collect(Collectors.toSet());

        //utilizando HashSet
        HashSet<String> terminos = palabras.collect(Collectors.toCollection(HashSet::new));
        terminos.forEach(System.out::println);
        System.out.println("cantidad de terminos: " + terminos.size());

    }
}
