package ro.ase.cts.main;

import ro.ase.cts.memento.Joc;

public class Main {
    public static void main(String[] args) {
        Joc joc = new Joc();
        joc.adaugaX(0,0);
        joc.adaugaO(1,1);
        joc.adaugaX(2,2);
        joc.afiseazaTabla();

        joc.salvare();
        joc.adaugaO(2,0);
        joc.salvare();
        joc.afiseazaTabla();
        joc.adaugaX(0,2);
        joc.afiseazaTabla();
        joc.restaurare();
        joc.afiseazaTabla();
    }
}
