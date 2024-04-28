/*
 * Class: CMSC203  CRN 	34473
 * Instructor: Khandan Monshi
 * Description: This program gets an ragged array and returns various information about the array
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Andy Gunawan
*/

import java.io.*; 
import java.util.*; 

public class TwoDimRaggedArrayUtility 
{

    public static double[][] readFile(File file) throws FileNotFoundException 
    {
        List<double[]> dataList = new ArrayList<>();
        try (Scanner inputFile = new Scanner(file)) 
        {
            while (inputFile.hasNextLine()) 
            {
                String[] tokens = inputFile.nextLine().trim().split("\\s+");
                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) 
                {
                    row[i] = Double.parseDouble(tokens[i]);
                }
                dataList.add(row);
            }
        }
        return dataList.toArray(new double[0][]);
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException 
    {
        try (PrintWriter outputFile = new PrintWriter(file)) 
        {
            for (double[] row : data) 
            {
                for (int col = 0; col < row.length; col++) 
                {
                    outputFile.print((col > 0 ? " " : "") + row[col]);
                }
                outputFile.println();
            }
        }
    }

    //finds the sum of the array
    public static double getTotal(double[][] data) 
    {
        double total = 0;
        for (double[] row : data) 
        {
            for (double value : row) 
            {
                total += value;
            }
        }
        return total;
    }
    
    //gets the average of the array
    public static double getAverage(double[][] data) 
    {
        double totalValue = 0;
        int totalCount = 0;
        for (double[] row : data) 
        {
            for (double value : row) 
            {
                totalValue += value;
                totalCount++;
            }
        }
        return totalValue / totalCount;
    }
    
    //finds the sum of row
    public static double getRowTotal(double[][] data, int row) 
    {
        double totalValue = 0;
        for (double value : data[row]) 
        {
            totalValue += value;
        }
        return totalValue;
    }

    //finds the sum of a column
    public static double getColumnTotal(double[][] data, int col) 
    {
        double totalValue = 0;
        for (double[] row : data) 
        {
            if (col < row.length) 
            {
                totalValue += row[col];
            }
        }
        return totalValue;
    }
    
    //finds the highest value in a row
    public static double getHighestInRow(double[][] data, int row) 
    {
        if (row >= data.length || data[row] == null) 
        {
            return Double.NEGATIVE_INFINITY;
        }
        double max = Double.NEGATIVE_INFINITY;
        for (double value : data[row]) 
        {
            if (value > max) 
            {
                max = value;
            }
        }
        return max;
    }
    
    // finds the highest value in a row index
    public static int getHighestInRowIndex(double[][] data, int row) 
    {
        if (row >= data.length || data[row] == null) 
        {
            return -1;
        }
        double max = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int col = 0; col < data[row].length; col++) 
        {
            if (data[row][col] > max) {
                max = data[row][col];
                index = col;
            }
        }
        return index;
    }

    //finds the lowest value in a row
    public static double getLowestInRow(double[][] data, int row) 
    {
        if (row >= data.length || data[row] == null) 
        {
            return Double.POSITIVE_INFINITY;
        }
        double min = Double.POSITIVE_INFINITY;
        for (double value : data[row]) 
        {
            if (value < min) 
            {
                min = value;
            }
        }
        return min;
    }
    
    //finds the lowest value in a given row index
    public static int getLowestInRowIndex(double[][] data, int row) 
    {
        if (row >= data.length || data[row] == null) 
        {
            return -1;
        }
        double min = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int col = 0; col < data[row].length; col++) 
        {
            if (data[row][col] < min) 
            {
                min = data[row][col];
                index = col;
            }
        }
        return index;
    }
    
    //Finds the highest value in a column
    public static double getHighestInColumn(double[][] data, int col) 
    {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) 
        {
            if (col < row.length && row[col] > max) 
            {
                max = row[col];
            }
        }
        return max;
    }

    //finds the highest value in a given column index
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int indexMax = -1;
        double max = Double.NEGATIVE_INFINITY;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length && data[row][col] > max) {
                max = data[row][col];
                indexMax = row;
            }
        }
        return indexMax;
    }
    
    //Finds the lowest value in a column
    public static double getLowestInColumn(double[][] data, int col) 
    {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) 
        {
            if (col < row.length && row[col] < min) 
            {
                min = row[col];
            }
        }
        return min;
    }
    
    //Finds the lowest value in a given column index
    public static int getLowestInColumnIndex(double[][] data, int col) 
    {
        int indexMin = -1;
        double min = Double.POSITIVE_INFINITY;
        for (int row = 0; row < data.length; row++) 
        {
            if (col < data[row].length && data[row][col] < min) 
            {
                min = data[row][col];
                indexMin = row;
            }
        }
        return indexMin;
    }

    //Finds the maximum value in a ragged array
    public static double getHighestInArray(double[][] data) 
    {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) 
        {
            for (double value : row) 
            {
                if (value > max) 
                {
                    max = value;
                }
            }
        }
        return max;
    }
    
    //Finds the Lowest value in a ragged array
    public static double getLowestInArray(double[][] data) 
    {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) 
        {
            for (double value : row) 
            {
                if (value < min) 
                {
                    min = value;
                }
            }
        }
        return min;
    }

}
