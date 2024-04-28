/*
 * Class: CMSC203  CRN 	34473
 * Instructor: Khandan Monshi
 * Description: This program is a test for HolidayBonus.java
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Andy Gunawan
*/

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {
    
    private double[][] salesData; 
    
    @Before
    public void setUp() {
        salesData = new double[][] {
            {1000.50, 2000.75, 1500.00},  
            {800.00, 1200.50},           
            {950.00, 2150.00, 1800.00},   
            {1900.00}                      
        };
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertNotNull(bonuses);
        assertEquals(salesData.length, bonuses.length);
        for (int i = 0; i < bonuses.length; i++) {
            assertTrue(bonuses[i] >= 0);
        }
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);
        assertTrue( totalBonus >= 0);
        double expectedTotal = 0;
        for (double bonus : HolidayBonus.calculateHolidayBonus(salesData)) {
            expectedTotal += bonus;
        }
        
        assertEquals(expectedTotal, totalBonus, 0.001);
    }
}
