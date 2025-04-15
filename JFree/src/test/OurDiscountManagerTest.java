package test;

import JFree.DiscountManager;
import JFree.IDiscountCalculator;

import org.jmock.Expectations;
import org.jmock.Mockery;

import org.junit.Test;
import static org.junit.Assert.*;

public class OurDiscountManagerTest {

    @Test
    public void TestcalculatePriceAfterDiscount_DiscountsSeason_SpecialWeek() {
        // Arrange
        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedCalculator = mockingContext.mock(IDiscountCalculator.class);

        double price = 100.0;

        mockingContext.checking(new Expectations() {{
            oneOf(mockedCalculator).isTheSpecialWeek(); will(returnValue(true));
        }});

        DiscountManager manager = new DiscountManager(true, mockedCalculator);

        double expected = 80.0;

        // Act
        double actual = manager.calculatePriceAfterDiscount(price);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void TestcalculatePriceAfterDiscount_DiscountsSeason_NotSpecial_EvenWeek() {
        // Arrange
        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedCalculator = mockingContext.mock(IDiscountCalculator.class);

        double price = 100.0;

        mockingContext.checking(new Expectations() {{
            oneOf(mockedCalculator).isTheSpecialWeek(); will(returnValue(false));
            oneOf(mockedCalculator).getDiscountPercentage(); will(returnValue(7));
        }});

        DiscountManager manager = new DiscountManager(true, mockedCalculator);

        double expected = 700.0;

        // Act
        double actual = manager.calculatePriceAfterDiscount(price);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void TestcalculatePriceAfterDiscount_NotDiscountSeason() {
        // Arrange
        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedCalculator = mockingContext.mock(IDiscountCalculator.class);

        double price = 100.0;

        DiscountManager manager = new DiscountManager(false, mockedCalculator);

        double expected = price;

        // Act
        double actual = manager.calculatePriceAfterDiscount(price);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expected, actual, 0.001); // 0.001 for floating point comparison
    }

    @Test
    public void TestcalculatePriceAfterDiscount_DiscountSeason_ThrowsException() {
        // Arrange
        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedCalculator = mockingContext.mock(IDiscountCalculator.class);

        double price = 100.0;

        mockingContext.checking(new Expectations() {{
            oneOf(mockedCalculator).isTheSpecialWeek(); will(returnValue(false));
            oneOf(mockedCalculator).getDiscountPercentage(); will(throwException(new IllegalArgumentException("Invalid week")));
        }});

        DiscountManager manager = new DiscountManager(true, mockedCalculator);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            manager.calculatePriceAfterDiscount(price);
        });

        mockingContext.assertIsSatisfied();
    }


}
