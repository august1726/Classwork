///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Month Calendar Maker
// Course:          Comp Sci 200, Term 1, 2021
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Original Code Created by Jim Williams and Devesh Shah
// 
// Refactored and edited by August Bambenek
//  
// 
// 
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;

/**
 * This class contains the entire program to print out a calendar
 * and find the day of a week for a given month/date/year.
 *
 * @author Jim Williams
 * @author Devesh Shah
 * @author August Bambenek
 */
public class Calendar {
    
    /**
     * This returns a specified character a specified amount of times
     * The most common use for this method is to evenly space out dates in a week
     * 
     * @param specifiedChar The character that will be printed out a specified number of times
     * @param numChars How many times to print out the specified character
     */
    public static void createNumberOfChars(char specifiedChar, int numChars) {
        for (int itemCount = 0; itemCount < numChars; itemCount++) {
            System.out.print(specifiedChar);      }
    }

    /**
     * This returns whether the specified year is a leap year.
     *
     * The algorithm is:
     *    Every year that is exactly divisible by four is a leap year, except for years that are exactly divisible
     *    by 100, but these centurial years are leap years if they are exactly divisible by 400. For example,
     *    the years 1700, 1800, and 1900 are not leap years, but the years 1600 and 2000 are.
     *    https://en.wikipedia.org/wiki/Leap_year
     *
     * @param year The year to determine whether it is a leap year.
     * @return true if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {

        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }

        } else {
            isLeapYear = false;
        }
        return isLeapYear;
    }

    /**
     * This returns the number of days in the specified month of year.
     *
     * @param month The month to return the number of days.
     * @param year The year is used for determining whether it is a leap year.
     * @return The number of days in the specified month of the year.
     */
    public static int getDaysInMonth(int month, int year) {
        int daysInMonth = 0;
        switch (month) {
            // 31 days
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;

            // 30 days
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;

            case 2: // 28 or 29 days
                if (isLeapYear(year)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
        }
        return daysInMonth;
    }

    /**
     * Returns the name of the month, given the number of the month.
     *
     * @param month The month where 1 is January and 12 is December.
     * @return The name of the month.
     */
    public static String getMonthName(int month) {
        String monthStr;
        switch (month) {
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            case 12:
                monthStr = "December";
                break;
            default:
                monthStr = "unknown";
                break;
        }
        return monthStr;
    }
    
    /**
     * Creates the top 3 rows above the Calendar that include the month, year, and names of each weekday
     *
     * @param month The month of the day chosen by the user
     * @param year  The year of the day chosen by the user
     */
    public static void topRowMaker(String month, int year) {
        final int TOTAL_WIDTH = 28;
        final char MONTH_HEADER_LINE_CHAR = '-';

        System.out.println();
        String topRow = month + " " + year;
        int spacesBefore = (TOTAL_WIDTH - topRow.length()) / 2;
        createNumberOfChars(' ', spacesBefore);
        System.out.println(topRow);
        createNumberOfChars(MONTH_HEADER_LINE_CHAR, TOTAL_WIDTH);
        System.out.println();
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * This prints out the days of the month in the correct day of the week column.
     *
     * @param startDay The day of the week of the 1st day of the month, where 0 is Sunday, 1 is Monday.
     * @param daysInMonth The number of days in the month.
     */
    public static void printMonthDays(int startDay, int daysInMonth) {
        final char CHAR_BETWEEN_DAYS = ' ';
        final int DAYS_IN_A_WEEK = 7;
        final int LOWEST_SINGLE_DIGIT_DAY = 1;
        final int HIGHEST_SINGLE_DIGIT_DAY = 9;

        createNumberOfChars(CHAR_BETWEEN_DAYS, startDay * 4);
        for (int day = 1; day <= daysInMonth; day++) {
            if (day >= LOWEST_SINGLE_DIGIT_DAY && day <= HIGHEST_SINGLE_DIGIT_DAY) {
                createNumberOfChars(CHAR_BETWEEN_DAYS, 2);
            } else {
                createNumberOfChars(CHAR_BETWEEN_DAYS, 1);
            }
            System.out.print(day);
            createNumberOfChars(CHAR_BETWEEN_DAYS, 1);
            startDay++;
            if (startDay % DAYS_IN_A_WEEK == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    /**
     * This method calculates the number of days between the two given dates for the same
     * calendar year
     * 
     * @param month1 The number (1-12) of the month of the first date
     * @param day1 The number of the first date
     * @param month2 The number (1-12) of the month of the second date
     * @param day2 The number of the second date
     * @param year The year that both dates are in
     * @return the number of days between the two specified dates
     */
    public static int getNumDaysBetweenDates(int month1, int day1, int month2, int day2, int year) {

        int numDays = 0;
        if (month1 == month2) {
            numDays = day2 - day1;
            return numDays;
        }

        // Add number of days for first month
        numDays += getDaysInMonth(month1, year) - day1;

        // Add number of days for in-between months
        for (int numMonths = (month1 + 1); numMonths < month2; numMonths++) {
            int daysInMonth = getDaysInMonth(numMonths, year);
            numDays += daysInMonth;
        }

        // Add number of days for last month
        numDays += day2;

        return numDays;
    }
    
    /**
     * This method finds which day of the week the specified date takes place on
     * 
     * @param month The number (1-12) of the month of the specified date
     * @param date The number of the specified date
     * @param year The year that the specified date takes place in
     * @param startDayOfWeek The day of the week that January 1st is on in the specified year
     * @return the name of the day of the week that the specified date takes place on
     */
    public static String getDayOfWeek(int month, int date, int year, int startDayOfWeek) {
        String dayOfWeek = " ";

        if (month <= 0 || month > 12 || date <= 0 || date > 31) {
            return "Invalid User Input";
        }

        // First calculate number of days between start of year and date
        int daysFromJanFirst = getNumDaysBetweenDates(1, 1, month, date, year);

        // Then do math to what day of week this corresponds to
        int dayOfWeekInt = daysFromJanFirst % 7;
        dayOfWeekInt = (startDayOfWeek + dayOfWeekInt) % 7;

        switch (dayOfWeekInt) {
            case 0:
                dayOfWeek = "Sunday";
                break;
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6:
                dayOfWeek = "Saturday";
                break;
        }

        return dayOfWeek;
    }

    /**
     * First prompts for the year and the day of the week of January 1st and then
     * prompts for any given date (month and day) of that same year that user
     * wants to find day of week for.
     * Prints out day of week for given date and a monthly calendar for given month.
     *
     * @param args  unused
     */
    public static void main(String[] args) {
        final char FIRST_MONTH = 1;
        final int DAYS_IN_A_WEEK = 7;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = input.nextInt();
        System.out.print("Enter day of week of Jan 1 (0-Sunday, 1-Monday, etc): ");
        int startDay = input.nextInt();
        int originalStartDay = startDay;

        System.out.println();
        System.out.println("Lets find the day of a week for any given date on this calendar year!");
        System.out.print("Enter Month of Desired Date (1-Jan, 2-Feb, etc): ");
        int monthOfDate = input.nextInt();
        System.out.print("Enter Day of Desired Date (1-1st of month, 2-2nd of month, etc): ");
        int dayOfDate = input.nextInt();
        System.out.println();
        System.out.println(getMonthName(monthOfDate) + " " + dayOfDate + ", " + year + " is a "
            + getDayOfWeek(monthOfDate, dayOfDate, year, originalStartDay));


        for (int month = FIRST_MONTH; month < monthOfDate; ++month) {
            int daysInMonth = getDaysInMonth(month, year);
            startDay = (startDay + daysInMonth) % DAYS_IN_A_WEEK;
        }
        String monthName = getMonthName(monthOfDate);
        topRowMaker(monthName, year);
        int daysInMonth = getDaysInMonth(monthOfDate, year);
        printMonthDays(startDay, daysInMonth);

    }
}
