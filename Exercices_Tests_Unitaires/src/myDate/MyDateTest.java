package myDate;
import static org.junit.Assert.*;

import junit.framework.TestCase;

public class MyDateTest extends TestCase {

    /*
     *    * Test method for {@link MyDate#getDay()}.
     */
    public void testGetDay() {
        MyDate d = new MyDate(31, 12, 2006);
        assertEquals(31, d.getDay());
    }

    /**
     * Test method for {@link MyDate#getMonth()}.
     */
    public void testGetMonth() {
    	MyDate d = new MyDate(31, 12, 2006);
        assertEquals(12, d.getMonth());
    }

    /**
     * Test method for {@link MyDate#getYear()}.
     */
    public void testGetYear() {
    	MyDate d = new MyDate(31, 12, 2006);
        assertEquals(2006, d.getYear());
    }

    /**
     * Test simple valid dates
     */
    public void testSimpleValidDates() {
        boolean b = MyDate.isValidDate(1, 1, 2000);
        assertTrue(b);
        b = MyDate.isValidDate(25, 12, 2000);
        assertTrue(b);
    }

    /**
     * Test simple invalid dates
     */
    public void testSimpleInvalidDates() {
        boolean b = MyDate.isValidDate(0, 1, 2000);
        assertFalse("0 est invalide pour le jour", b);
        b = MyDate.isValidDate(32, 12, 2000);
        assertFalse(b);
    }

    /**
     * Test valid limit dates
     */
    public void testValidLimitDates() {
        boolean b = MyDate.isValidDate(31, 1, 2000);
        assertTrue("31 janvier est une date valide", b);
    }

    /**
     * Test invalid limit dates
     */
    public void testInvalidLimitDates() {
        boolean b = MyDate.isValidDate(31, 4, 2000);
        assertFalse("31 avril est une date invalide", b);
    }

    /**
     * Test February valid limit dates
     */
    public void testFebruaryValidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2000);
        assertTrue("29 f�vrier 2000 est une date valide", b);
    }

    /**
     * Test February invalid limit dates
     */
    public void testFebruaryInvalidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2001);
        assertFalse("29 f�vrier 2001 est une date valide", b);
    }
    
    public void testWhenDayIsNegative() {
    	boolean b = MyDate.isValidDate(-10, 2, 2000);
    	assertFalse("Un nombre n�gatif est invalide pour le jour" , b);
    }
    
    public void testWhenDayIsBiggerThan31() {
    	boolean b = MyDate.isValidDate(-33, 12, 2001);
    	assertFalse("Le jour ne peut etre plus grand que 31" , b);
    }
    
    public void testWhenMonthIsSmallerThan1() {
    	boolean b = MyDate.isValidDate(2, 0, 1999);
    	assertFalse("Le mois ne peut etre plus petit que 1" , b);
    }
    
    public void testWhenMonthIsBiggerThan12() {
    	boolean b = MyDate.isValidDate(3, 14, 1997);
    	assertFalse("Le mois ne peut etre plus grand que 12" , b);
    }
    
    public void testWhenYearIsSmallerThan1000() {
    	boolean b = MyDate.isValidDate(1, 1, 100);
    	assertFalse("L'ann�e ne peut etre plus petite que 1000" , b);
    }
    
    public void testWhenYearIsBiggerThan3000() {
    	boolean b = MyDate.isValidDate(1, 1, 4000);
    	assertFalse("L'ann�e ne peut etre plus grande que 4000" , b);
    }
    
    public void testNextDay() {
    	MyDate d = new MyDate(30, 12, 2006);
    	MyDate d2 = new MyDate(31, 12, 2006);
    	d.nextDay();
    	assertEquals(d.getDay(), d2.getDay());
    	assertEquals(d.getMonth(), d2.getMonth());
    	assertEquals(d.getYear(), d2.getYear());
    }
    
    public void testNextDayWhenLimitDayIsReached() {
    	MyDate d = new MyDate(31, 11, 2006);
    	MyDate d2 = new MyDate(1, 12, 2006);
    	d.nextDay();
    	assertEquals(d.getDay(), d2.getDay());
    	assertEquals(d.getMonth(), d2.getMonth());
    	assertEquals(d.getYear(), d2.getYear());
    }
    
    public void testNextDayWhenLimitDayIsReachedForMonthWith30Days() {
    	MyDate d = new MyDate(30, 4, 2006);
    	MyDate d2 = new MyDate(1, 5, 2006);
    	d.nextDay();
    	assertEquals(d.getDay(), d2.getDay());
    	assertEquals(d.getMonth(), d2.getMonth());
    	assertEquals(d.getYear(), d2.getYear());
    }
    
    public void testNextDayForFebruaryInBisextilYear() {
    	MyDate d = new MyDate(28, 2, 2000);
    	MyDate d2 = new MyDate(29, 2, 2000);
    	d.nextDay();
    	assertEquals(d.getDay(), d2.getDay());
    	assertEquals(d.getMonth(), d2.getMonth());
    	assertEquals(d.getYear(), d2.getYear());
    }
    
    public void testNextDayForFebruaryInNormalYear() {
    	MyDate d = new MyDate(28, 2, 2001);
    	MyDate d2 = new MyDate(1, 3, 2001);
    	d.nextDay();
    	assertEquals(d.getDay(), d2.getDay());
    	assertEquals(d.getMonth(), d2.getMonth());
    	assertEquals(d.getYear(), d2.getYear());
    }
    
    public void testWhenLimitMonthIsReached() {
    	MyDate d = new MyDate(31, 12, 2006);
    	MyDate d2 = new MyDate(1, 1, 2007);
    	d.nextDay();
    	assertEquals(d.getDay(), d2.getDay());
    	assertEquals(d.getMonth(), d2.getMonth());
    	assertEquals(d.getYear(), d2.getYear());
    }

}