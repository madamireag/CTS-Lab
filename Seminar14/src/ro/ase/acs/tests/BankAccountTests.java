package ro.ase.acs.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ro.ase.acs.exceptions.InsufficientFundsException;
import ro.ase.acs.models.BankAccount;
import ro.ase.acs.tests.categories.CorrectCategory;
import ro.ase.acs.tests.categories.RightBicepCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BankAccountTests {

    private BankAccount bankAccount;

    // se ruleaza inainte de fiecare test
    @Before
    public void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    @Category(CorrectCategory.class)
    public void testConformance() throws InsufficientFundsException {
        bankAccount.addTransaction(300.331f);
        bankAccount.addTransaction(100.667f);
        bankAccount.addTransaction(0.01f);

        float result = bankAccount.getBalance();
        assertEquals("The balance is not right", 401, result, 0.001f);
    }

    @Test
    @Category(CorrectCategory.class)
    public void testOrdering1() throws InsufficientFundsException {
        bankAccount.addTransaction(200);
        bankAccount.addTransaction(200);
        bankAccount.addTransaction(-100);

        float result = bankAccount.getBalance();
        assertEquals("The balance is not right", 300, result, 0.001f);
    }

    @Test
    @Category(CorrectCategory.class)
    public void testOrdering2() {
        try {
            bankAccount.addTransaction(-100);
        } catch (InsufficientFundsException e) {

        }
        try {
            bankAccount.addTransaction(200);
        } catch (InsufficientFundsException e) {

        }
        try {
            bankAccount.addTransaction(200);
        } catch (InsufficientFundsException e) {

        }

        float result = bankAccount.getBalance();
        assertEquals("The balance is not right", 400, result, 0.001f);
    }

    @Test
    @Category(CorrectCategory.class)
    public void testRange() throws InsufficientFundsException {
        bankAccount.addTransaction(1900f);
        bankAccount.addTransaction(-1800f);
        bankAccount.addTransaction(3000f);
        bankAccount.addTransaction(2000f);
        bankAccount.addTransaction(-2050f);
        bankAccount.addTransaction(0f);


        List<Float> transactions = bankAccount.getTransactions();
        assertTrue("Invalid transaction accepted", transactions.contains(1900f));
        assertTrue("Invalid transaction accepted", transactions.contains(-1800f));
        assertTrue("Invalid transaction accepted", transactions.contains(2000f));
        assertFalse("Invalid transaction accepted", transactions.contains(3000f));
        assertFalse("Invalid transaction accepted", transactions.contains(-2050f));
        assertFalse("Invalid transaction accepted", transactions.contains(0f));
    }

    @Test
    @Category(CorrectCategory.class)
    public void testReference() throws InsufficientFundsException {
        List<Float> transactions = new ArrayList<>();
        transactions.add(300f);
        transactions.add(-150f);
        transactions.add(400f);

        bankAccount.restoreTransactions(transactions);
        transactions.add(200f);
        float result = bankAccount.getBalance();
        assertEquals("Invalid balance", 550, result, 0.001f);
    }

    @Test
    @Category(CorrectCategory.class)
    public void testCardinality1() {
        float result = bankAccount.getBalance();
        assertEquals("Balance is not correct", 0, result, 0.001f);
    }

    @Test
    @Category(CorrectCategory.class)
    public void testCardinality2() throws InsufficientFundsException {
        bankAccount.addTransaction(100f);
        float result = bankAccount.getBalance();
        assertEquals("Balance is not correct", 100f, result, 0.001f);
    }

    @Test
    @Category(CorrectCategory.class)
    public void testCardinality3() throws InsufficientFundsException {
        for (int i = 0; i <= 500; i++) {
            bankAccount.addTransaction(100f);
        }
        for (int i = 0; i <= 500; i++) {
            bankAccount.addTransaction(-100f);
        }

        float result = bankAccount.getBalance();
        assertEquals("Balance is not correct", 0f, result, 0.001f);
    }

    @Test(timeout = 1000)
    @Category(CorrectCategory.class)
    public void testTimeFrame() throws InsufficientFundsException {
        for (int i = 0; i <= 1000; i++) {
            bankAccount.addTransaction(100f);
        }
        bankAccount.getBalance();
    }

    // Right BICEP
    @Test
    @Category(RightBicepCategory.class)
    public void testRight() throws InsufficientFundsException {
        bankAccount.addTransaction(100.55f);
        bankAccount.addTransaction(50.33f);
        bankAccount.addTransaction(-79.82f);
        bankAccount.addTransaction(-45.43f);

        float result = bankAccount.getBalance();
        assertEquals("Balance is not correct", 25.63f, result, 0.001f);
    }

    @Test
    @Category(RightBicepCategory.class)
    public void testBoundary1() throws InsufficientFundsException {
        bankAccount.addTransaction(2000f);
        bankAccount.addTransaction(-2000f);

        float result = bankAccount.getBalance();
        assertEquals("Incorrect bounds", 0f, result, 0.001f);
    }

    @Test
    @Category(RightBicepCategory.class)
    public void testBoundary2() throws InsufficientFundsException {
        bankAccount.addTransaction(2000f);
        bankAccount.addTransaction(2000f);
        bankAccount.addTransaction(-2001f);
        bankAccount.addTransaction(2001f);

        float result = bankAccount.getBalance();
        assertEquals("Incorrect bounds", 4000f, result, 0.001f);
    }

    @Test
    @Category(RightBicepCategory.class)
    public void testInverse() throws InsufficientFundsException {
        bankAccount.addTransaction(100.55f);
        bankAccount.addTransaction(50.33f);
        bankAccount.addTransaction(-79.82f);
        bankAccount.addTransaction(-45.43f);

        float result = bankAccount.getBalance();
        List<Float> transactions = bankAccount.getTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            result -= transactions.get(i);
        }

        assertEquals("Incorrect balance", 0f, result, 0.001f);
    }

    @Test
    @Category(RightBicepCategory.class)
    public void testCrossCheck() throws InsufficientFundsException {
        bankAccount.addTransaction(100.55f);
        bankAccount.addTransaction(50.33f);
        bankAccount.addTransaction(-79.82f);
        bankAccount.addTransaction(-45.43f);

        float result = bankAccount.getBalance();

        List<Float> transactions = bankAccount.getTransactions();
        float expected = (float) transactions.stream().mapToDouble(x -> (double) x).sum();

        assertEquals("Incorrect balance", expected, result, 0.001f);
    }

    @Test(expected = InsufficientFundsException.class)
    @Category(RightBicepCategory.class)
    public void testErrorCondition() throws InsufficientFundsException {
        bankAccount.addTransaction(300f);
        bankAccount.addTransaction(-350f);

    }

    @Test(timeout = 1)
    @Category(RightBicepCategory.class)
    @Ignore
    public void testPerformance() throws InsufficientFundsException {
        bankAccount.addTransaction(150f);
    }


}
