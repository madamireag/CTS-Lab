package ro.ase.cts.observer;

// observer concret
public class Abonat implements Observer {
    private String email;

    public Abonat(String email) {
        this.email = email;
    }

    @Override
    public void primesteMail(String subiect) {
        System.out.println("Mesaj trimis catre: " + email + ": " + subiect);
    }
}
