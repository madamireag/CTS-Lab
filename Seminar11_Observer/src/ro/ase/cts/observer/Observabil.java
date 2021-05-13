package ro.ase.cts.observer;

import java.util.ArrayList;
import java.util.List;

// observabil abstract
public abstract class Observabil {
    private List<Observer> observers = new ArrayList<>();

    public void abonareNewsletter(Observer observer) {
        observers.add(observer);
    }

    public void dezabonareNewsletter(Observer observer) {
        observers.remove(observer);
    }

    public void trimiteMail(String subiect) {
        for (Observer observer : observers) {
            observer.primesteMail(subiect);
        }
    }
}
