package ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void scriere(Set<InstrumentMuzical>set) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file=new File("src/main/resources/instrumente.json");
            mapper.writeValue(file,set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<InstrumentMuzical> citire() {
        try {
            File file=new File("src/main/resources/instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<InstrumentMuzical> set = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzical>>(){});
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        Set<InstrumentMuzical> instrumente=new HashSet<>();

        instrumente.add(new Chitara("aaa", 1500.0, Tip.ELECTRICA, 6));
        instrumente.add(new Chitara("aaa", 2500.0, Tip.ACUSTICA, 6));
        instrumente.add(new Chitara("aaa", 1200.0, Tip.CLASICA, 4));

        instrumente.add(new SetTobe("bbb", 3000.0, TipTobe.ACUSTICE, 5, 3));
        instrumente.add(new SetTobe("bbb", 3500.0, TipTobe.ELECTRONICE, 7, 4));
        instrumente.add(new SetTobe("bbb", 2800.0, TipTobe.ACUSTICE, 6, 2)); //1


        scriere(instrumente); //2

        Set<InstrumentMuzical> setFinal=citire(); //3
        System.out.println("Afisare tututor instrumentelor: ");
        setFinal.forEach(System.out::println);
        boolean reusit=instrumente.add(new SetTobe("bbb", 2800.0, TipTobe.ACUSTICE, 6, 2));
        if(reusit){
            System.out.println("introducere cu success"); //5
        }
        else{
            System.out.println("Exista deja acest tip de instrument");
        }

        setFinal.removeIf(i->i.getPret()>3000); //6

        System.out.println("\n dupa eliminare instrumenelte sunt:");
        setFinal.forEach(System.out::println);

        System.out.println("Chitarele sunt: ");
        setFinal.stream()
                .filter(i->i instanceof Chitara)
                .forEach(System.out::println); //7

        System.out.println("Tobele sunt: ");
        setFinal.stream()
                .filter(i->i.getClass()==SetTobe.class)
                .forEach(System.out::println); //8

        System.out.println("Chitara cu cele mai multe corzi: ");
        Optional<InstrumentMuzical> multeCorzi=
                setFinal.stream()
                        .filter(i->i instanceof Chitara)
                        .max(Comparator.comparingInt(c -> ((Chitara) c).getNr_corzi()));

        multeCorzi.ifPresent(System.out::println);

        System.out.println("Tobele acustice ordonate dupa numar de tobe: ");
        setFinal.stream()
                .filter(i -> i instanceof SetTobe)
                .map(i -> (SetTobe) i)
                .filter(t -> t.getTipTobe() == TipTobe.ACUSTICE)
                .sorted(Comparator.comparingInt(SetTobe::getNr_tobe))
                .forEach(System.out::println);








    }
}
