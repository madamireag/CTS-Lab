package ro.ase.cts.memento;

import java.util.ArrayList;
import java.util.List;

// manager stari
public class ManagerSalvari {
    private List<TablaJoc> salvari = new ArrayList<>();

    public void salvare(TablaJoc tablaJoc) {
        try {
            salvari.add((TablaJoc) tablaJoc.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public TablaJoc restaurare() {
        if (salvari.size() > 0) {
            TablaJoc tablaJoc = salvari.get(salvari.size() - 1);
            salvari.remove(tablaJoc);
            return tablaJoc;
        }
        return null;
    }
}
