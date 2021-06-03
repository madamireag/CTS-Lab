package ro.ase.acs.tests;

import org.junit.Test;
import ro.ase.acs.exceptions.InsufficientFundsException;
import ro.ase.acs.models.BankAccount;
import ro.ase.acs.models.IAtm;

import java.util.Random;

import static org.junit.Assert.assertEquals;

class AtmStub implements IAtm {
    private Random random = new Random();
    public float value = 0;

    @Override
    public float transaction() {
        value = random.nextInt(2001);
        return value;
    }
}

public class BankAccountAtmTests {

    @Test
    public void testWithdraw() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.addTransaction(1000f);
        // testez printr-un fake
        bankAccount.setAtm(new IAtm() {
            @Override
            public float transaction() {
                return -500;
            }
        });
        bankAccount.useAtm();

        bankAccount.setAtm(() -> -400);
        bankAccount.useAtm();
        float result = bankAccount.getBalance();
        assertEquals("ATM not working", 100f, result, 0.001f);
    }

    @Test
    public void testDeposit() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount();
        // facem un stub - clasa AtmStub
        AtmStub atmStub = new AtmStub();
        bankAccount.setAtm(atmStub);

        bankAccount.useAtm();
        float balance = bankAccount.getBalance();
        assertEquals("ATM not working", atmStub.value, balance, 0.001f);
    }
}
