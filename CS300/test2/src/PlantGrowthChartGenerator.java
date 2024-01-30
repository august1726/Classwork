///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: August Bambenek
// Campus ID: 9083041492
// WiscEmail: abambenek@wisc.edu
//                        (TODO: fill this out)
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//
// This file contains ONE class. You will need to complete the implementation
// this class with respect to the provided requirements in the TODO tags for
// full credit.
//
// When creating new exception objects, including messages within these objects
// is optional.
////////////////////////////////////////////////////////////////////////////////

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

import java.util.ArrayList;

/**
 * This class models a generator of the growth chart of a specific plant in a given number of days.
 * Starting from an initial height, the plant's height growths with a specific growth step every
 * day.
 *
 * NOTE: You may NOT add any additional data fields to this class. You may NOT add any additional 
 * methods to this class
 */
public class PlantGrowthChartGenerator {
  // instance fields
  private String name; // name of the plant whose growth chart will be generated
  private final int INITIAL_HEIGHT; // the height of the plant at day ONE.
  private int growthStep; // the amount the plant grows each day
  private ArrayList<Integer> chart; // list of heights of the plant starting from day ONE.


  /**
   * Creates a new plant growth chart generator.
   * 
   * @param name          name of the specific plant
   * @param initialHeight initial height of the plant
   * @param growthStep    daily growth step of the plant
   */
  public PlantGrowthChartGenerator(String name, int initialHeight, int growthStep) {
    this.name = name;
    this.INITIAL_HEIGHT = initialHeight;
    this.growthStep = growthStep;
    chart = new ArrayList<Integer>();
    // TODO initialize chart to an empty arraylist of Integers
    

  }

  /**
   * Returns the size of the generated chart
   * 
   * @return the size of the generated chart
   */
  public int size() {
    // TODO returns the size of the chart
    return chart.size();
  }


  /**
   * Generates the growth chart of a specific plant in the last daysCount days.
   * 
   * @param daysCount the number of days in the chart to generate
   * @throws IllegalArgumentException if daysCount is less or equal to zero
   */
  public void generateChart(int daysCount) {
    // TODO
    // 1. throw an IllegalArgumentException if daysCount is less or equal to zero
    if (daysCount <= 0) {
      throw new IllegalArgumentException("ERROR: daysCount must be greater than zero");
    }
    
    chart.clear(); // empty the chart
    

    // 2. Make a call to generateGrowthChartHelper with the correct list of input arguments
    // to generate the growth chart of the plant starting from its initial height.
    // At day ONE, the height of the plant is INITIAL_HEIGHT, and this height will increase by
    // growthStep on each of the remaining days (until 0 days remain)
    generateGrowthChartHelper(INITIAL_HEIGHT, daysCount);
  }

  /**
   * Recursive Helper method. 
   * Generates the heights of the plant over daysRemaining days, starting from currentHeight,
   * and adds these heights to the chart
   * 
   * @param currentHeight current height of the plant
   * @param daysRemaining number of days left to add to the chart
   */
  public void generateGrowthChartHelper(int currentHeight, int daysRemaining) {
    // base case -- provided in the next commented line
    if (daysRemaining == 0) return;
    
    // TODO implement recursive case
    // 1. define the recursive case
    // 2. add the current height to the chart
    // 3. make a correct recursive call with the correct updates to BOTH arguments
    chart.add(currentHeight);
    generateGrowthChartHelper(currentHeight + growthStep, daysRemaining - 1);
  }

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

  /**
   * Returns a String representation of the contents of the chart (each element is separated by a
   * single space)
   * 
   * @return a String representation of the chart
   */
  @Override
  public String toString() {
    String s = "";
    // TODO
    // Traverse the chart list and add its content to s
    // (elements stored in the chart must be separated by a single space).
    for (int i = 0; i < chart.size(); i++) {
      s = s.concat(chart.get(i) + " ");
    }
    
    return s.trim();

  }

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

  /**
   * Checks the correctness of the implementation of generateChart() method
   * 
   * @return true if no bug is detected by this tester method, false otherwise
   */
  public static boolean testGeneratePlantGrowthChart() {
    try {
      // create a new plant growth generator
      PlantGrowthChartGenerator mintChart = new PlantGrowthChartGenerator("mint", 10, 2);

      // test base case
      mintChart.generateChart(1);
      String expectedChart = "10";

      if (mintChart.size() != 1)
        return false;
      if (mintChart.toString() == null || !mintChart.toString().trim().equals(expectedChart))
        return false;

      // test recursive case
      mintChart.generateChart(7);
      expectedChart = "10 12 14 16 18 20 22";
      if (mintChart.size() != 7)
        return false;
      if (mintChart.toString() == null || !mintChart.toString().trim().equals(expectedChart))
        return false;

    } catch (Exception e1) {
      e1.printStackTrace();
      return false;

    } catch (StackOverflowError e2) {
      System.out.println("StackOverflowError thrown!");
      return false;
    }
    return true;
  }

  /**
   * Implements a demo of this program
   */
  public static void demo() {
    PlantGrowthChartGenerator mintChart = new PlantGrowthChartGenerator("mint", 10, 2);
    mintChart.generateChart(1);
    System.out
        .print("Growth Chart of " + mintChart.name + " in the first day: ");

    System.out.println(mintChart);
    mintChart.generateChart(5);
    System.out.print(
        "Growth Chart of " + mintChart.name + " in the last " + mintChart.size() + " days: ");
    System.out.println(mintChart);
    mintChart.generateChart(7);
    System.out.print(
        "Growth Chart of " + mintChart.name + " in the last " + mintChart.size() + " days: ");
    System.out.println(mintChart);
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    demo();
    System.out.println("testGeneratePlantGrowthChart(): " + testGeneratePlantGrowthChart());

  }

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

}
