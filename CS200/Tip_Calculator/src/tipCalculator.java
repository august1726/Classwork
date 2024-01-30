import java.util.Scanner;
import java.lang.Math;

public class BMI {
    
    public static double bmi(double heightMeters, double weightKilos) {
        double bmi = weightKilos / (Math.pwr(heightMeters);
        return bmi;
    }
    
    public static void testBMI() {
        System.out.println( "bmi(1.778, 79.5)=" + bmi(1.778, 79.5) + " should be ~25");
        System.out.println( "bmi(1.828, 54.5)=" + bmi(1.828, 54.5) + " should be ~16");
        //what additional cases can you find or create? 
    }
    
    public static double inchesToMeters( double inches) {
        final double METERS_IN_INCH = 0.0254;
        return inches / METERS_IN_INCH;
    }
    
    public static void testInchesToMeters() {
        System.out.println("inchesToMeters(1)= " + inchesToMeters(1) + " should be 0.0254");
        System.out.println("inchesToMeters(12)= " + inchesToMeters(12) + " should be 0.3048");
        //add additional test cases
    }
    
    public static double feetToInches( double feet) {
      return feet / 12; 
    }
    
    public static void testFeetToInches() {
        System.out.println("feetToInches(1)= " + feetToInches(1) + " should be 12");
        //add additional test cases
    }
    
    public static double poundsToKilograms( double pounds) {
        return pounds/2.20462;
    }
    
    public static void testPoundsToKilograms() {
        System.out.println("poundsToKilograms(2.2)= " + poundsToKilograms(2.2) + " should be 1");
        System.out.println("poundsToKilograms(1)= " + poundsToKilograms(1) + " should be 0.453592");
        //add additional test cases
    }   
    
    public static void main(String[] args) {
        //  testBMI();
        //  testInchesToMeters();
        //  testFeetToInches();
        //  testPoundsToKilograms();
            
            Scanner input = new Scanner( System.in);
            
            System.out.print("Height (meters): ");
            double heightMeters = input.nextDouble();
            
            System.out.print("Weight (kilograms): ");
            double weightKilos = input.nextDouble();
            
            double bmi = bmi( heightMeters, weightKilos);
            
            System.out.println("BMI: " + bmi);
            
            //finish...
            
    }

}
}