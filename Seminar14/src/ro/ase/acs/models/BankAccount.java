package ro.ase.acs.models;

import ro.ase.acs.exceptions.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String owner;
    private String IBAN;
    private List<Float> transactions = new ArrayList<>();
    private IAtm atm;

    public void setAtm(IAtm atm) {
        this.atm = atm;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public List<Float> getTransactions() {
        return transactions;
    }

    public void addTransaction(float value) throws InsufficientFundsException {
        if (-value > getBalance()) {
            throw new InsufficientFundsException();
        }
        if (value != 0 && value >= -2000f && value <= 2000f) {
            transactions.add((float) (Math.floor(value * 100) / 100));
        }
    }

    public float getBalance() {
        float balance = 0;
        for (float s : transactions) {
            balance += s;
        }
        return balance;
    }

    public void restoreTransactions(List<Float> transactions) throws InsufficientFundsException {
        this.transactions.clear();
        for(int i=0; i<transactions.size(); i++){
            addTransaction(transactions.get(i));
        }
    }

    public void useAtm() throws InsufficientFundsException {
        if(atm != null){
            float value = atm.transaction();
            addTransaction(value);
        }
    }
}
