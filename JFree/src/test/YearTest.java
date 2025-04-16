package test;

import junit.framework.TestSuite;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Year;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class YearTest {
    Year year;



    // Default Constructor Passed
    private void arrange() {
        year = new Year();
    }
    @Test
    public void testYearDefaultCtor() {
        arrange();
        assertEquals(2025, year.getYear());
    }

    //Second Constructor=================================================
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

   //Passed but this is wrong constructor suppose to not create years out of range
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


    //Passed bec Exception was thrown
    @Test(expected = IllegalArgumentException.class)
    public void testYearIntCtorAboveRange() {
        //Arrange
        int year = 10000;

        //Act
        Year year3 = new Year(year);
    }


    //Third Constructor===============================================
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

    //4th Constructor ===================================
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
    //next==========================================================================================================












}
