package test;

import JFree.DiscountCalculator;
import JFree.IDiscountCalculator;
import org.jfree.data.time.Week;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;

public class DiscountCalculatorTest {

    @Test
    public void testIsTheSpecialWeekWhenFalse() throws Exception {

        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 22);
        Date date = calendar.getTime();
        Week week = new Week(date);
        IDiscountCalculator calculator = new DiscountCalculator(week);

        //Act
        boolean actual = calculator.isTheSpecialWeek();

        //Assert
        assertFalse(actual);
    }

    @Test
    public void testIsTheSpecialWeekWhenTrue() throws Exception {

        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, 23);
        Date date = calendar.getTime();
        Week week = new Week(date);
        IDiscountCalculator calculator = new DiscountCalculator(week);

        // Act
        boolean actual = calculator.isTheSpecialWeek();

        // Assert
        assertTrue(actual);
    }

    @Test
    public void testGetDiscountPercentageWhenEven() throws Exception {

        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 10);
        Date date = calendar.getTime();
        Week week = new Week(date);
        IDiscountCalculator calculator = new DiscountCalculator(week);
        int expected = 7 ;

        //Act
        int actual = calculator.getDiscountPercentage();

        //Assert
        assertEquals(expected, actual);
    }

    //it's a bug
    @Test
    public void testGetDiscountPercentageWhenOdd() throws Exception {

        //Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.OCTOBER, 11);
        Date date = calendar.getTime();
        Week week = new Week(date);
        IDiscountCalculator calculator = new DiscountCalculator(week);
        int expected = 5 ;

        //Act
        int actual = calculator.getDiscountPercentage();

        //Assert
        assertEquals(expected, actual);
    }

    //it's a bug
    @Test
    public void testGetDiscountPercentageWithInvalidDate() throws Exception {

       //Assert + Act
        assertThrows(IllegalArgumentException.class, () -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2025, Calendar.FEBRUARY, 30);
            Date date = calendar.getTime();
            Week week = new Week(date);
            IDiscountCalculator calculator = new DiscountCalculator(week);
            calculator.getDiscountPercentage();
        });
    }

    @Test
    public void testGetDiscountPercentageWhenWeekIsNull() throws Exception {

        //Arrange
        Week nullWeek = null;

        //Assert + Act
        assertThrows(NullPointerException.class, () -> {
            DiscountCalculator calculator = new DiscountCalculator(nullWeek);
            calculator.getDiscountPercentage();
        });
    }

    @Test
    public void testGetDiscountPercentageWhenWeekIsZero() {

        //Assert + Act
        assertThrows(IllegalArgumentException.class, () -> {
            Week week = new Week(0, 2025);
            DiscountCalculator calculator = new DiscountCalculator(week);
            calculator.getDiscountPercentage();
        });
    }





}
