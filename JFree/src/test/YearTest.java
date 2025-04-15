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





}
