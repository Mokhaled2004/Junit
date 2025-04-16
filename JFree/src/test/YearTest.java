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
















}
