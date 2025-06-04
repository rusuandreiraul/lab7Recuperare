package org.example.ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void scriere(Map<Integer, Carte> carti) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,carti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<Integer,Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<Integer, Carte> carti = mapper
                    .readValue(file, new TypeReference<Map<Integer, Carte>>() {
                    });
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Map<Integer, Carte>carti=new HashMap<Integer,Carte>();

        carti=citire();

        afisare(carti); //1

        carti.remove(1); //2
        System.out.println("Afisare dupa eliminare: ");
        afisare(carti);


        carti.putIfAbsent(7,new Carte("Belle si bestia", "Gigi", 2000)); //3

        scriere(carti); //4

        System.out.println("cartile lui Yual Noah Harari ");
        Set<Carte> cartiSet= carti.values().stream()
                .filter(c->c.autorul().equalsIgnoreCase("Yuval Noah Harari"))
                .collect(Collectors.toSet());
        cartiSet.forEach(System.out::println); //5
        System.out.println("cartile sortate: ");
        carti.values().stream() //folosesc mapul si nu setul
                .sorted((c1, c2)->c1.titlul().compareToIgnoreCase(c2.titlul()))
                .forEach(System.out::println); //6
        System.out.println("cartea cea mai veche");
        Optional<Carte> veche=carti.values().stream()
                .min((c1, c2)->Integer.compare(c1.anul(), c2.anul()));
        veche.ifPresent(System.out::println); //7


    }

    public static void afisare(Map<Integer,Carte>carti){
        var entryset=carti.entrySet(); //set pereche cheie-valoare

        var it=entryset.iterator();
                while(it.hasNext()){
                    var m=it.next();

                    Integer key=m.getKey();
                    Carte carte=m.getValue();
                    System.out.println("Cheie: " + key + " Carte: " + carte);
                }
    }

}