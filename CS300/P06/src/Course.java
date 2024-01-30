//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Course
// Course:   CS 300 Spring 2022
//
// Author:   August Bambenek
// Email:    abambenek@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Contains data for a school course
 * 
 * @author August Bambenek
 */
public class Course {
  private String name; //the name of the course, e.g. “CS300”
  private int numStudents; //the number of students enrolled in the course, e.g. 250

  /**
   * initializes the data fields to the values of the arguments. If the provided integer is 
   * negative (<0), throws an IllegalArgumentException with a descriptive error message.
   * 
   * @param name - name of the course
   * @param numStudents - number of students enrolled in the course 
   * @throws IllegalArgumentException with a descriptive error message if the provided integer is 
   * negative (<0)
   */
  public Course(String name, int numStudents) {
    if (numStudents < 0) {
      throw new IllegalArgumentException("ERROR: numStudents can't be less than zero");
    }
    this.name = name;
    this.numStudents = numStudents;
  }

  /**
   * returns the name of this course
   * 
   * @return returns the name of this course
   */
  public String getName() {
    return this.name;
  }

  /**
   * returns the number of students enrolled in this course
   * 
   * @return returns the number of students enrolled in this course
   */
  public int getNumStudents() {
    return this.numStudents;
  }

}
