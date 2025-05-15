package ejercicio1.ejercicio2;

import ejercicio1.Funko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Funko> funkos;
    public static void main(String[] args) throws Exception {

        

        List<String> lista = Files.readAllLines(Path.of("funkos.csv"));
        for (String s : lista) {
            funkos.add(new Funko(s));
        }
        for (Funko funko: funkos){
            System.out.println(funko);
        }
    }
}
