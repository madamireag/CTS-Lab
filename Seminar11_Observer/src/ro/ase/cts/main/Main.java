package ro.ase.cts.main;

import ro.ase.cts.observer.Abonat;
import ro.ase.cts.observer.Website;

public class Main {
    public static void main(String[] args) {
        Website website = new Website();
        website.setAdresa("myblog.com");
        Abonat abonat1 = new Abonat("gigel@yahoo.com");
        Abonat abonat2 = new Abonat("maria@gmail.com");
        Abonat abonat3 = new Abonat("alin@yahoo.com");

        website.abonareNewsletter(abonat1);
        website.abonareNewsletter(abonat2);
        website.abonareNewsletter(abonat3);
        website.adaugaArticol("Cum sa faci fata testului la CTS");

        website.dezabonareNewsletter(abonat3);
        website.adaugaArticol("Alt articol");


    }
}
