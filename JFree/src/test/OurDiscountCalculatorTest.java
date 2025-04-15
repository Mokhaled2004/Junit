package test;

import JFree.IDiscountCalculator;
import JFree.DiscountCalculator;
import org.jfree.data.time.Week;

import org.junit.Test;
import static org.junit.Assert.*;

public class OurDiscountCalculatorTest {

    //c1 special week (b1 -> special , b2 -> not)
    //c2 week parity (b1 -> even , b2 -> odd)
    //c3 week validity (b1 -> <1 , b2 -> 1<= range <=52 , b3 -> >52)

    //b1.1, b3.2
    @Test
    public void TestisTheSpecialWeek_Special() {
        //Arrange
        Week week = new Week(26, 2025);
        IDiscountCalculator calculator = new DiscountCalculator(week);
        //Act
        boolean actual = calculator.isTheSpecialWeek();
        //Assert
        assertTrue(actual);
    }

    //b1.2, b3.2
    @Test
    public void TestisTheSpecialWeek_NotSpecial() {
        //Arrange
        Week week = new Week(51, 2025);
        IDiscountCalculator calculator = new DiscountCalculator(week);
        //Act
        boolean actual = calculator.isTheSpecialWeek();
        //Assert
        assertFalse(actual);
    }

    //b2.1, b3.2
    @Test
    public void TestgetDiscountPercentage_EvenWeek() {
        //Arrange
        Week week = new Week(8, 2025);
        IDiscountCalculator calculator = new DiscountCalculator(week);
        int expected = 7 ;
        //Act
        int actual = calculator.getDiscountPercentage();
        //Assert
        assertEquals(expected, actual);
    }

    //b2.2, b3.2
    @Test
    public void TestgetDiscountPercentage_OddWeek() {
        //Arrange
        Week week = new Week(1, 2025);
        IDiscountCalculator calculator = new DiscountCalculator(week);
        int expected = 5 ;
        //Act
        int actual = calculator.getDiscountPercentage();
        //Assert
        assertEquals(expected, actual);
    }

    //b2.1, b3.3
    @Test
    public void TestgetDiscountPercentage_WeekAbove52() {
        //Assert + Act
        assertThrows(IllegalArgumentException.class, () -> {
            Week week = new Week(54, 2025);
            IDiscountCalculator calculator = new DiscountCalculator(week);
            calculator.getDiscountPercentage(); // Not reached
        });
    }

    //b3.1
    @Test
    public void TestgetDiscountPercentage_WeekZero() {
        //Assert + Act
        assertThrows(IllegalArgumentException.class, () -> {
            Week week = new Week(0, 2025);
            IDiscountCalculator calculator = new DiscountCalculator(week);
            calculator.getDiscountPercentage(); // Not reached
        });
    }


}
