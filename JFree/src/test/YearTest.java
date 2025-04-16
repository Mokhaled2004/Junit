package test;

import junit.framework.TestSuite;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Year;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class YearTest {
    Year year;


    //==============================================================================================================
    // Default Constructor Passed
    private void arrange() {
        year = new Year();
    }
    @Test
    public void testYearDefaultCtor() {
        arrange();
        assertEquals(2025, year.getYear());
    }
    //==============================================================================================================


    //==============================================================================================================
    //IntParam Constructor
    @Test
    public void testYearIntCtor() {
        //Arrange
        int year = 2004;

        //Act
        Year year1 = new Year(year);

        //Assert
        assertEquals(year,year1.getYear());
    }


   @Test
   public void testYearIntCtorBellowRange() {
       // Arrange
       int year = 1899;

       try {
           // Act
           Year year2 = new Year(year);
           fail("Expected IllegalArgumentException was not thrown");
       } catch (IllegalArgumentException e) {
           assertEquals("Year constructor: year (1899) outside valid range.", e.getMessage());
       }
   }


    @Test(expected = IllegalArgumentException.class)
    public void testYearIntCtorAboveRange() {
        //Arrange
        int year = 10000;

        //Act
        Year year3 = new Year(year);
    }

    //==============================================================================================================
    //Third Constructor=============================================================================================
    @Test
    public void testYearDateCtor() {
        //Arrange
        Date date = new Date(2025-1900,3,16);

        //Act
        Year year4 = new Year(date);

        //Assert
        assertEquals(2025,year4.getYear());
    }

    @Test(expected = NullPointerException.class)
    public void testYearDateCtorNull() {
        //Arrange
        Date date = null;

        //Act
        Year year5 = new Year(date);
    }
    //==============================================================================================================

    //==============================================================================================================
    //4th Constructor ==============================================================================================
    @Test
    public void testYearDateZoneCtor() {
        // Arrange
        Date date = new Date(2025 - 1900, 3, 16);  // April 16, 2025 (Note: Date is 0-indexed for months)
        TimeZone zone = TimeZone.getTimeZone("UTC");

        // Act
        //Year year6 = new Year(date, zone);
        fail("Cant resolve zone to calender and in the doc calender isnt mentioned");

        // Assert
        //assertEquals(2025, year6.getYear());
    }
    //==============================================================================================================


    //==============================================================================================================
    //getYear Method================================================================================================
    @Test
    public void testGetYearLowestValue(){
        //Arrange
        Year year7 = new Year(1900);

        //Act
        int actual = year7.getYear();

        //Assert
        assertEquals(1900,actual);
    }


    @Test
    public void testGetYearInRange() {
        //Arrange
        Year year8 = new Year(2004);

        //Act
        int actual = year8.getYear();

        //Assert
        assertEquals(2004,actual);
    }

    @Test
    public void testGetHighestValue() {
        //Arrange
        Year year9 = new Year(9999);

        //Act
        int actual = year9.getYear();

        //Assert
        assertEquals(9999,actual);
    }
    //==============================================================================================================


    //==============================================================================================================
    //previous======================================================================================================
    @Test
    public void testPreviousValid() {
        //Arrange
        Year year2004 = new Year(2004);

        //Act
        RegularTimePeriod prevYear2004 = year2004.previous();

        //Assert
        assertNotNull(prevYear2004);
        assertEquals(2003,((Year) prevYear2004).getYear());
    }

    @Test
    public void testPreviousInvalid() {
        //Arrange
        Year year1900 = new Year(1900);

        //Act
        RegularTimePeriod prevYear1900 = year1900.previous();

        //Assert
        assertNull(prevYear1900);

    }
    //==============================================================================================================


    //==============================================================================================================
    //next==========================================================================================================
    @Test
    public void testNextValid() {
        //Arrange
        Year year2004 = new Year(2004);

        //Act
        RegularTimePeriod nextYear2004 = year2004.next();

        //Assert
        assertEquals(2005, ((Year) nextYear2004).getYear());

    }

    @Test
    public void testNextInvalid() {
        //Arrange
        Year year9999 = new Year(9999);

        //Act
        RegularTimePeriod nextYear9999 = year9999.next();

        //Assert
        assertNull(nextYear9999);
    }
    //==============================================================================================================


    //==============================================================================================================
    //getSerialIndex=================================================================================================
    @Test
    public void testGetSerialIndexInRange() {
        //Arrange
        Year year2004 = new Year(2004);

        //Act
        long year2004Index = year2004.getSerialIndex();

        //Assert
        assertEquals(2004L,year2004Index);
    }

    @Test
    public void testGetSerialIndexLowest() {
        //Arrange
        Year year1900 = new Year(1900);

        //Act
        long year1900Index = year1900.getSerialIndex();

        //Assert
        assertEquals(1900L,year1900Index);
    }

    @Test
    public void testGetSerialIndexHighest() {
        //Arrange
        Year year9999 = new Year(9999);

        //Act
        long year9999Index = year9999.getSerialIndex();

        //Assert
        assertEquals(9999L, year9999Index);
    }
    //==============================================================================================================


    //==============================================================================================================
    //getFirstMillisecond===========================================================================================
    @Test
    public void testGetFirstMilliSecondValid() {
        //Arrange
        Year year = new Year(2004);
        Calendar calendar = Calendar.getInstance();

        calendar.set(2004,Calendar.JANUARY,1,0,0,0);
        calendar.set(Calendar.MILLISECOND,0);
        long expectedTimeInMills = calendar.getTimeInMillis();

        //Act
        long actualTimeInMills = year.getFirstMillisecond(calendar);

        //Assert
        assertEquals(actualTimeInMills, expectedTimeInMills);

    }

    @Test
    public void testGetFirstMillisecondLowestValue() {
        // Arrange
        Year year = new Year(1900);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long expectedTimeInMills = calendar.getTimeInMillis();

        // Act
        long actualTimeInMills = year.getFirstMillisecond(calendar);

        // Assert
        assertEquals(expectedTimeInMills, actualTimeInMills);
    }

    @Test
    public void testGetFirstMillisecondHighestYear() {
        // Arrange
        Year year = new Year(9999);
        Calendar calendar = Calendar.getInstance();
        calendar.set(9999, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long expectedTimeInMills = calendar.getTimeInMillis();

        // Act
        long actualTimeInMills = year.getFirstMillisecond(calendar);

        // Assert
        assertEquals(expectedTimeInMills, actualTimeInMills);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFirstMillisecondWithNullCalendar() {
        // Arrange
        Year year = new Year(2025);

        // Act
        year.getFirstMillisecond(null);

        // Assert
        // Exception expected
    }
    //==============================================================================================================

    //==============================================================================================================
    //Method getLastMillisecond ====================================================================================
    @Test
    public void testGetLastMillisecond_NormalYear() {

        // Arrange
        Calendar calendar = Calendar.getInstance();
        Year year = new Year(2025);

        // Act
        long lastMillisecond = year.getLastMillisecond(calendar);

        calendar.set(2025, Calendar.DECEMBER, 31, 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        long expected = calendar.getTimeInMillis();

        // Assert
        assertEquals(expected, lastMillisecond);

    }

    @Test
    public void testGetLastMillisecond_NullCalendar() {

        // Arrange
        Year year = new Year(2024);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            year.getLastMillisecond(null);
        });

    }
    //==============================================================================================================

    //==============================================================================================================
    //equals========================================================================================================
    @Test
    public void testEqualSameYear() {
        //Arrange
        Year year1 = new Year(2004);
        Year year2  = new Year(2004);

        //Act-Assert
        assertTrue(year1.equals(year2));

    }

    @Test
    public void testEqualDifferentYear() {
        //Arrange
        Year year1 = new Year(2004);
        Year year2  = new Year(2005);

        //Act-Assert
        assertFalse(year1.equals(year2));
    }

    @Test
    public void testEqualNull() {
        //Arrange
        Year year1 = new Year(2004);

        //Act-Assert
        assertFalse(year1.equals(null));
    }

    @Test
    public void testEqualDifferentObject() {
        //Arrange
        Year year1 = new Year(2004);
        String year2  = "2004";

        //Acr-Assert
        assertFalse(year1.equals(year2));
    }
    //==============================================================================================================

    //===============================================================================================================
    //hashcode=======================================================================================================
    @Test
    public void testHashCodeLowerBoundary() {
        Year year = new Year(1900);
        assertNotNull(year.hashCode());
    }

    @Test
    public void testHashCodeUpperBoundary() {
        Year year = new Year(9999);
        assertNotNull( year.hashCode());
    }

    @Test
    public void testHashCodeSameObject() {
        Year year = new Year(2025);
        assertNotNull(year.hashCode());
        assertEquals( year.hashCode(), year.hashCode());
    }

    @Test
    public void testHashCodeEqualObjects() {
        Year y1 = new Year(2025);
        Year y2 = new Year(2025);
        assertNotNull(y1.hashCode());
        assertNotNull(y2.hashCode());
        assertEquals( y1.hashCode(), y2.hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() {
        Year y1 = new Year(2025);
        Year y2 = new Year(1999);
        assertNotNull(y1.hashCode());
        assertNotNull(y2.hashCode());
        assertNotEquals(y1.hashCode(), y2.hashCode());
    }

    @Test
    public void testHashCodeCollision() {
        Year year1 = new Year(2020);
        Year year2 = new Year(2030);

        // assert that they have the same hash code
        assertEquals(year1.hashCode(), year2.hashCode());

        // BUT they are NOT equal as objects
        assertNotEquals(year1, year2);
    }

    @Test(expected = NullPointerException.class)
    public void testHashCodeOnNullObject() {
        Year year = null;
        year.hashCode();
    }
    //==============================================================================================================



    //==================================================================================================================
    //Method compareTo==================================================================================================
    @Test
    public void testCompareTo_LessThan() {

        // Arrange
        Year year1 = new Year(2020);
        Year year2 = new Year(2022);

        // Act
        int result = year1.compareTo(year2);

        // Assert
        assertTrue(result < 0);

    }

    @Test
    public void testCompareTo_Same() {

        // Arrange
        Year year1 = new Year(2025);
        Year year2 = new Year(2025);

        // Act
        int result = year1.compareTo(year2);

        // Assert
        assertTrue(result == 0);

    }

    @Test
    public void testCompareTo_GreaterThan() {

        // Arrange
        Year year1 = new Year(2025);
        Year year2 = new Year(2020);

        // Act
        int result = year1.compareTo(year2);

        // Assert
        assertTrue(result > 0);

    }

    //it's a bug
    @Test
    public void testCompareTo_WhenOtherYearIsNull() {

        // Arrange
        Year year1 = new Year(2025);
        Year year2 = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            year1.compareTo(year2);
        });

    }
    //==============================================================================================================

    //==============================================================================================================
    //toString======================================================================================================
    @Test
    public void testValidYearToString() {
        Year year = new Year(2025);
        assertEquals( "2025", year.toString());
    }


    @Test
    public void testToStringFailsIfWrong() {
        Year year = new Year(2025);
        if (!year.toString().equals("2025")) {
            fail("Year toString() did not return expected value");
        }
    }


    @Test
    public void testToStringNotNull() {
        Year year = new Year(2025);
        assertNotNull("toString() should not return null", year.toString());
    }


    @Test(expected = NullPointerException.class)
    public void testToStringThrowsWhenYearIsNull() {
        Year year = null;
        year.toString();
    }
    //==============================================================================================================


    //===============================================================================================================
    //parseYear======================================================================================================
    @Test
    public void testParseYearEqualsExpected() {
        Year expected = new Year(2025);
        Year actual = Year.parseYear("2025");
        assertEquals(expected, actual);
    }


    @Test
    public void testParseYearInvalidLetters() {
        Year year = Year.parseYear("abcd");
        assertNull(year);
    }

    @Test
    public void testParseYearEmptyString() {
        Year year = Year.parseYear("");
        assertNull(year);
    }

    @Test
    public void testParseYear_TooShort() {
        Year year = Year.parseYear("20");
        assertNull(year);
    }

    @Test
    public void testParseYear_NullInput() {
        Year year = Year.parseYear(null);
        assertNull(year);
    }

    @Test(expected = NullPointerException.class)
    public void testParseYearNullInput() {
        Year.parseYear(null);
    }

}
