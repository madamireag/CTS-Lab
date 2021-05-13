package ro.ase.cts.memento;

// originator
public class Joc {
    private TablaJoc tablaJoc;
    private ManagerSalvari managerSalvari;

    public Joc() {
        tablaJoc = new TablaJoc();
        managerSalvari = new ManagerSalvari();
    }

    public boolean verificaCastigator() {
        // ...
        return false;
    }

    public void adaugaX(int linie, int coloana) {
        tablaJoc.adaugaSimbol('X', linie, coloana);
    }

    public void adaugaO(int linie, int coloana) {
        tablaJoc.adaugaSimbol('O', linie, coloana);
    }

    public void afiseazaTabla() {
        if (tablaJoc != null) {
            char[][] m = tablaJoc.getTabla();
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    // creare memento
    public void salvare() {
        managerSalvari.salvare(tablaJoc);
    }

    public void restaurare() {
        tablaJoc = managerSalvari.restaurare();
    }

}
