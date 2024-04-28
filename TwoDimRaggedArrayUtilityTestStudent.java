/*
 * Class: CMSC203  CRN 	34473
 * Instructor: Khandan Monshi
 * Description: This program is a test for TwoDimRaggedArrayUtility.java
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Andy Gunawan
*/

import static org.junit.Assert.*;
import org.junit.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class TwoDimRaggedArrayUtilityTestStudent {
	
    private double[][] dataSet1 = {{10, 20, 30}, {40, 50}, {60, 70, 80}};
    private double[][] dataSet2 = {{70, 20, 90, 40}, {50}, {80, 10, 30}, {110, 60, 70, 20}};
    private double[][] dataSet3 = {{17.2, 12.5, 19.3}, {15.9}, {18.1, 11.7, 13.3}, {21.6, 16.9, 17.3, 12.7}};
    private double[][] dataSet4 = {{-12.5, -15.3, 16.1}, {-14.4, 18.2}, {12.3, -17.5}, {-14.2, 17.3, -15.9, 12.6}};
    private File inputFile, outputFile;

    @Before
    public void setUp() throws Exception {
        outputFile = new File("TestOut.txt");
    }

    @After
    public void tearDown() throws Exception {
        dataSet1 = null;
        dataSet2 = null;
        dataSet3 = null;
        dataSet4 = null;
        
        inputFile = null;
        outputFile = null;   
    }

    @Test
    public void testGetTotal() {
    	 assertEquals(360.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
    	 assertEquals(650.0, TwoDimRaggedArrayUtility.getTotal(dataSet2), .001);
    	 assertEquals(176.5, TwoDimRaggedArrayUtility.getTotal(dataSet3), .001);
    	 assertEquals(-13.3, TwoDimRaggedArrayUtility.getTotal(dataSet4), .001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
        assertEquals(54.167, TwoDimRaggedArrayUtility.getAverage(dataSet2), .001);
        assertEquals(16.045, TwoDimRaggedArrayUtility.getAverage(dataSet3), .001);
        assertEquals(-1.209, TwoDimRaggedArrayUtility.getAverage(dataSet4), .001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(90.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), .001);
        assertEquals(50.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 1), .001);
        assertEquals(220.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 0), .001);
        assertEquals(68.5, TwoDimRaggedArrayUtility.getRowTotal(dataSet3, 3), .001);
        assertEquals(15.9, TwoDimRaggedArrayUtility.getRowTotal(dataSet3, 1), .001);
        assertEquals(3.8, TwoDimRaggedArrayUtility.getRowTotal(dataSet4, 1), .001);
        assertEquals(-0.2, TwoDimRaggedArrayUtility.getRowTotal(dataSet4, 3), .001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(110.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
        assertEquals(190.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 2), .001);
        assertEquals(41.1, TwoDimRaggedArrayUtility.getColumnTotal(dataSet3, 1), .001);
        assertEquals(-28.8, TwoDimRaggedArrayUtility.getColumnTotal(dataSet4, 0), .001);
        assertEquals(2.7, TwoDimRaggedArrayUtility.getColumnTotal(dataSet4, 1), .001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(30.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);
        assertEquals(80.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 2), .001);
        assertEquals(15.9, TwoDimRaggedArrayUtility.getHighestInRow(dataSet3, 1), .001);
        assertEquals(16.1, TwoDimRaggedArrayUtility.getHighestInRow(dataSet4, 0), .001);
        assertEquals(18.2, TwoDimRaggedArrayUtility.getHighestInRow(dataSet4, 1), .001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 2));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet4, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet4, 1));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(60.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), .001);
        assertEquals(50.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 1), .001);
        assertEquals(12.5, TwoDimRaggedArrayUtility.getLowestInRow(dataSet3, 0), .001);
        assertEquals(-14.4, TwoDimRaggedArrayUtility.getLowestInRow(dataSet4, 1), .001);
        assertEquals(-17.5, TwoDimRaggedArrayUtility.getLowestInRow(dataSet4, 2), .001);
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(80.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), .001);
        assertEquals(60.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 1), .001);
        assertEquals(21.6, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet3, 0), .001);
        assertEquals(18.2, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet4, 1), .001);
        assertEquals(16.1, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet4, 2), .001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet3, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet4, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet4, 2));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(20.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), .001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 2), .001);
        assertEquals(15.9, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet3, 0), .001);
        assertEquals(-14.4, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet4, 0), .001);
        assertEquals(-17.5, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet4, 1), .001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 2));
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet3, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet4, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet4, 1));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(80.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
        assertEquals(110.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), .001);
        assertEquals(21.6, TwoDimRaggedArrayUtility.getHighestInArray(dataSet3), .001);
        assertEquals(18.2, TwoDimRaggedArrayUtility.getHighestInArray(dataSet4), .001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(10.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
        assertEquals(10.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), .001);
        assertEquals(11.7, TwoDimRaggedArrayUtility.getLowestInArray(dataSet3), .001);
        assertEquals(-17.5, TwoDimRaggedArrayUtility.getLowestInArray(dataSet4), .001);
    }

    @Test
    public void testWriteToFile() throws FileNotFoundException {
        double[][] array = null;
        try {
            TwoDimRaggedArrayUtility.writeToFile(dataSet4, outputFile);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
        array = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertEquals(-12.5, array[0][0], .001);
        assertEquals(-15.3, array[0][1], .001);
        assertEquals(16.1, array[0][2], .001);
        assertEquals(-14.4, array[1][0], .001);
        assertEquals(18.2, array[1][1], .001);
        assertEquals(12.3, array[2][0], .001);
        assertEquals(-17.5, array[2][1], .001);
        assertEquals(-14.2, array[3][0], .001);
        assertEquals(17.3, array[3][1], .001);
        assertEquals(-15.9, array[3][2], .001);
        assertEquals(12.6, array[3][3], .001);
    }


    @Test
    public void testReadFile() {
        double[][] array = null;
        try {
            inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.print("-2.5 -5.3 6.1\n" + "-4.4 8.2\n" + "2.3 -7.5\n" + "-4.2 7.3 -5.9 2.6");
            inFile.close();
            array = TwoDimRaggedArrayUtility.readFile(inputFile);
            assertEquals(-2.5, array[0][0], .001);
            assertEquals(-5.3, array[0][1], .001);
            assertEquals(6.1, array[0][2], .001);
            assertEquals(-4.4, array[1][0], .001);
            assertEquals(8.2, array[1][1], .001);
            assertEquals(2.3, array[2][0], .001);
            assertEquals(-7.5, array[2][1], .001);
            assertEquals(-4.2, array[3][0], .001);
            assertEquals(7.3, array[3][1], .001);
            assertEquals(-5.9, array[3][2], .001);
            assertEquals(2.6, array[3][3], .001);
        } catch (FileNotFoundException e) {
            fail();
        }
        try {
            assertEquals(0.0, array[1][2], .001);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
        try {
            assertEquals(0.0, array[2][2], .001);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}
