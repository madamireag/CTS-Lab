package ro.ase.acs.main;


import ro.ase.acs.readers.ConsoleReader;
import ro.ase.acs.writers.ConsoleWriter;

public class Main {
    public static void main(String[] args){
        // Citesc o linie de la tastatura
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Message: ");
        //String message = scanner.nextLine();
        //System.out.println(message);

        // scanner.close(); //la sfarsit cand nu mai citim alte informatii

        // rezolvam Single Responsability impartind in 2 clase, nu mai fac si citire si scriere

//        ConsoleReader reader = new ConsoleReader();
//        ConsoleWriter writer = new ConsoleWriter();
//        writer.write(reader.read());
//        try {
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Open-Closed Principle - vrem sa putem scrie si in fisier, fac o clasa,o derivez din ConsoleWriter si implementez metoda

        // Liskov Substitution - cream interfata Writeable si ambele vor fi derivate din ea
//        ConsoleReader reader = new ConsoleReader();
//        Writeable writer = new FileWriter();
//        writer.write(reader.read());
//        try {
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // Interface Segregation - daca as avea interfata IOCapable care face si read si write, sparg in
        // interfetele Readable si Writeable
        // Dependency Inversion
        Orchestrator orchestrator = new Orchestrator(new ConsoleReader(),new ConsoleWriter());
        orchestrator.execute();
    }



}
