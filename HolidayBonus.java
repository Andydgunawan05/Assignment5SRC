/*
 * Class: CMSC203  CRN 	34473
 * Instructor: Khandan Monshi
 * Description: This program calculates the bonus amount a store gets
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Andy Gunawan
*/

public class HolidayBonus {
  
    private static final double HIGH_BONUS = 5000.00; 
    private static final double LOW_BONUS = 1000.00;  
    private static final double OTHER_BONUS = 2000.00; 


    public static double[] calculateHolidayBonus(double[][] sales) 
    {
        double[] bonuses = new double[sales.length];
        for (int row = 0; row < sales.length; row++) 
        {
            for (int col = 0; col < sales[row].length; col++) 
            {    
                int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(sales, col);
                int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(sales, col);
                if (row == highestIndex) {
                    bonuses[row] += HIGH_BONUS;
                } else if (row == lowestIndex) {
                    bonuses[row] += LOW_BONUS;
                } else {
                    bonuses[row] += OTHER_BONUS;
                }
            }
        }

        return bonuses;
    }

    //Calculates the total holiday bonus for the district
    public static double calculateTotalHolidayBonus(double[][] sales) 
    {
        double[] bonuses = calculateHolidayBonus(sales);
        double totalBonus = 0;
        for (double bonus : bonuses) 
        {
            totalBonus += bonus;
        }

        return totalBonus;
    }
}
