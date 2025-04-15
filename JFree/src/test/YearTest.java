package test;

import junit.framework.TestSuite;
import org.jfree.data.time.Year;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {
    Year year;
    Year Year1;
    Year Year2;
    Year Year3;



    private void arrange() {
        year = new Year();
    }
    @Test
    public void testYearDefaultCtor() {
        arrange();
        assertEquals(2025, year.getYear());
    }

    @Before
    public void Intializer () {
        Year1 = new Year(2004);
        Year2 = new Year (2004);
        Year3 = new Year(2005);

    }


    @Test
    public void Testequals() {

        // Valid
        assertTrue(Year1.equals(Year2));


        //Invalid
        assertFalse(Year1.equals(Year3));


        //Null
        assertFalse(Year1.equals(null));


        //Diff Types
        assertFalse(Year1.equals("NotInt"));


        //Same Instance
        assertTrue(Year1.equals(Year1));


    }

    @Test
    public void TestGetYear() {
        //Valid Year LowestRange----------------------------------------------------------------
        //Arrange
        Year lowestValidYear = new Year(1900);

        //Act
        int result = lowestValidYear.getYear();

        //Assert
        assertEquals(1900,result);

        //Valid Year InBetweenRange----------------------------------------------------------------
        //Arrange
        Year inBetweenRangeValidYear = new Year(2025);

        //Act
        int result2 = inBetweenRangeValidYear.getYear();

        //Assert
        assertEquals(2025,result2);


        //Valid Year HighestRange----------------------------------------------------------------
        //Arrange
        Year highestValidRange = new Year(9999);

        //Act
        int result3 = highestValidRange.getYear();

        //Assert
        assertEquals(9999,result3);


        //Invalid Year Below Range----------------------------------------------------------------
        Year bellowValidRange = new Year(1899);

        //Act
        int result4 = bellowValidRange.getYear();

        //Assert
        assertEquals(1899,result4);

    }





}
