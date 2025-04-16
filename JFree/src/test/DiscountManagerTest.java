package test;
import JFree.DiscountManager;
import JFree.IDiscountCalculator;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiscountManagerTest {

    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsFalse() throws Exception {

        // Arrange
        boolean isDiscountsSeason = false;
        double originalPrice = 100.0;
        double expectedPrice = 100.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);

        mockingContext.checking(new Expectations() {{
            never(mockedDependency);
        }});

        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);

        // Act
        double actualPrice = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsTrue() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        double expectedPrice = 80.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);

        mockingContext.checking(new Expectations() {{
            oneOf(mockedDependency).isTheSpecialWeek(); will(returnValue(true));
        }});

        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);

        // Act
        double actualPrice = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    //it's a bug
    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsFalse() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        int discountPercentage = 5;
        double expectedPrice = originalPrice * discountPercentage / 100.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);

        mockingContext.checking(new Expectations() {{
            oneOf(mockedDependency).isTheSpecialWeek(); will(returnValue(false));
            oneOf(mockedDependency).getDiscountPercentage(); will(returnValue(discountPercentage));
        }});

        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);

        // Act
        double actualPrice = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCalculatePriceWhenPriceIsZero() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        double price = 0.0;
        double expectedPrice = 0.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);

        mockingContext.checking(new Expectations() {{
            oneOf(mockedDependency).isTheSpecialWeek(); will(returnValue(true));
        }});

        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);

        // Act
        double actualPrice = discountManager.calculatePriceAfterDiscount(price);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCalculatePriceWhenPriceIsNull() {

        // Arrange
        boolean isDiscountsSeason = true;
        Double price = null;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);

        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);

        // Assert + Act
        assertThrows(NullPointerException.class, () -> {
            discountManager.calculatePriceAfterDiscount(price);
        });
    }

    @Test
    public void testCalculatePriceWhenPriceIsInt() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        int intPrice = 100;
        double expectedPrice = 80.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);

        mockingContext.checking(new Expectations() {{
            oneOf(mockedDependency).isTheSpecialWeek(); will(returnValue(true));
        }});

        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);

        // Act
        double actualPrice = discountManager.calculatePriceAfterDiscount(intPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void testCalculatePriceWhenPriceIsString() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        String priceStr = "not-a-number";

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);

        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);

        // Act + Assert
        assertThrows(NumberFormatException.class, () -> {
            double parsedPrice = Double.parseDouble(priceStr);
            discountManager.calculatePriceAfterDiscount(parsedPrice);
        });
    }











}
