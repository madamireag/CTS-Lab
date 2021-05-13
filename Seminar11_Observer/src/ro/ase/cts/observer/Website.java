package ro.ase.cts.observer;

// observabil concret
public class Website extends Observabil {
    private String adresa;

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void adaugaArticol(String numeArticol) {
        trimiteMail(numeArticol);
    }
}
