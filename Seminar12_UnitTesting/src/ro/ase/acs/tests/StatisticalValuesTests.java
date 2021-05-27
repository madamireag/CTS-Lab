package ro.ase.acs.tests;

import org.junit.Test;
import ro.ase.acs.exceptions.StatisticalException;
import ro.ase.acs.models.StatisticalValues;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StatisticalValuesTests {
    @Test
    public void testMin() {
        List<Long> values = new ArrayList<>();
        values.add(1L);
        values.add(2L);
        values.add(3L);

        StatisticalValues statisticalValues = new StatisticalValues();
        statisticalValues.setValues(values);

        long result = statisticalValues.getMinim();
        assertEquals("Incorrect minimum", 1, result);

    }

    @Test
    public void testGetAverageForThreeValues() {
        List<Long> values = new ArrayList<>();
        values.add(1L);
        values.add(2L);
        values.add(3L);

        StatisticalValues statisticalValues = new StatisticalValues();
        statisticalValues.setValues(values);

        double result = 0;
        try {
            result = statisticalValues.getAverage();
        } catch (StatisticalException e) {
            fail(e.getMessage());
        }
        assertEquals("Incorrect average", 2, result, 0.01); // le compar la a doua zecimala, daca diferenta e sub 0.01 le consider egale
    }

    @Test(expected = StatisticalException.class)
    public void testGetAverageForEmptyList() throws StatisticalException {
        List<Long> values = new ArrayList<>();

        StatisticalValues statisticalValues = new StatisticalValues();
        statisticalValues.setValues(values);

        statisticalValues.getAverage();
    }

    @Test(expected = StatisticalException.class)
    public void testGetAverageForNullList() throws StatisticalException {
        List<Long> values = null;

        StatisticalValues statisticalValues = new StatisticalValues();
        statisticalValues.setValues(values);

        statisticalValues.getAverage();
    }

    @Test
    public void testGetAverageForSingleValue() throws StatisticalException {
        List<Long> values = new ArrayList<>();
        values.add(1L);
        StatisticalValues statisticalValues = new StatisticalValues();
        statisticalValues.setValues(values);

        double result = statisticalValues.getAverage();
        assertEquals("Incorrect average", 1, result, 0.01);
    }

    @Test(expected = StatisticalException.class)
    public void testGetAverageForNullElement() throws StatisticalException {
        List<Long> values = new ArrayList<>();
        values.add(null);

        StatisticalValues statisticalValues = new StatisticalValues();
        statisticalValues.setValues(values);

        statisticalValues.getAverage();
    }

    @Test
    public void testGetAverageFloatForValues() throws StatisticalException {
        List<Long> values = new ArrayList<>();
        values.add(2L);
        values.add(2L);
        values.add(3L);

        StatisticalValues statisticalValues = new StatisticalValues();
        statisticalValues.setValues(values);

        double result = statisticalValues.getAverage();
        assertEquals("Incorrect average", 2.33, result, 0.01);
    }
}
