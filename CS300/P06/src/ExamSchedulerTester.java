//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exam Scheduler Tester
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

import java.util.ArrayList;

/**
 * Tests the public methods in Course, Room, Schedule, and Exam Scheduler
 * 
 * @author August Bambenek
 */
public class ExamSchedulerTester {
  
  /**
   * tests public methods in Course()
   * 
   * @return returns true if tests pass, returns false if any tests fail
   */
  public static boolean testCourse() {
    Course course1 = new Course("CS300", 150);
    if (!course1.getName().equals("CS300")) {
      System.out.println("testCourse() getName() failed");
      return false;
    }
    if (course1.getNumStudents() != 150) {
      System.out.println("testCourse() getNumStudents() failed");
      return false;
    }
    try {
      Course course2 = new Course("CS400", -10);
      System.out.println("testCourse() faied to throw IllegalArgument Exception for negative "
          + "input");
    } catch (IllegalArgumentException e) {
      return true;
    }
    System.out.println("testCourse() faied to catch IllegalArgument Exception");
    return false;
  }
  
  /**
   * tests public methods in Room()
   * 
   * @return returns true if tests pass, returns false if any tests fail
   */
  public static boolean testRoom() {
    Room room1 = new Room("test", 200);
    if (room1.getCapacity() != 200) {
      System.out.println("testRoom() getCapacity() failed");
      return false;
    }
    if (!room1.getLocation().equals("test")) {
      System.out.println("testRoom() getLocation() failed");
      return false;
    }
    room1 = room1.reduceCapacity(100);
    if (room1.getCapacity() != 100) {
      System.out.println("testRoom() getCapacity() failed after decreasing capacity");
      return false;
    }
    try {
      room1.reduceCapacity(300);
      System.out.println("testRoom() failed to throw IllegalArgumentException when reducing "
          + "capacity by more than capacity");
    } catch (IllegalArgumentException e) {
      
    }
    try {
      Room room2 = new Room("test", -20);
    } catch (IllegalArgumentException e) {
      return true;
    }
    System.out.println("testRoom() failed to catch IllegalArgumentException when capacity was "
        + "negative");
    return false;
  }
  
  /**
   * tests accessor methods in Schedule()
   * 
   * @return returns true if all tests pass, returns false if any tests fail
   */
  public static boolean testScheduleAccessors() {
    Room[] rooms = {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses = {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 75)};
    Schedule schedule = new Schedule(rooms, courses);
    if (schedule.getNumRooms() != 3) {
      System.out.println("testScheduleAccessors() getNumRooms() failed");
      return false;
    }
    if (schedule.getNumCourses() != 3) {
      System.out.println("testScheduleAccessors() getNumCourses() failed ");
      return false;
    }
    
    return true;
  }
  
  /**
   * tests the assignCourse() method in the Course() class
   * 
   * @return returns true if all tests pass, returns false if any tests fail
   */
  public static boolean testAssignCourse() {
    Room[] rooms = {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses = {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 75)};
    Schedule schedule = new Schedule(rooms, courses);
    schedule = schedule.assignCourse(2, 2);
    if (!schedule.isAssigned(2)) {
      System.out.println("testAssignCourse() failed at detecting if one room has been assigned");
      return false;
    }
    try {
      schedule.assignCourse(0, 4);
      System.out.println("testAssignCourse() failed to throw IndexOutOfBoundsException");
    } catch(IndexOutOfBoundsException e) {
      
    }
    try {
      schedule.assignCourse(0, 2);
      System.out.println("testAssignCourse() failed to throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      
    }
    schedule = schedule.assignCourse(0, 0);
    schedule = schedule.assignCourse(1, 1);
    if (!schedule.isComplete()) {
      System.out.println("testAssignCourse() failed to detect if case was complete");
      return false;
    }
    return true;
  }
  
  /**
   * tests the findAllSchedules() method in the ExamScheduler() class
   * 
   * @return returns true if all tests pass, returns false if any tests fail
   */
  public static boolean testFindAllSchedules() {
    Room[] rooms = {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses = {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 75)};
    ArrayList<Schedule> allPossible = ExamScheduler.findAllSchedules(rooms, courses);
    if (allPossible.size() != 2) {
      System.out.println("testFindAllSchedules() failed for normal case");
      return false;
    }
    Room[] rooms1 = {new Room("Room1", 1), new Room("Room2", 15), new Room("Room3", 7)};
    Course[] courses1 = {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 9)};
    ArrayList<Schedule> allPossible1 = ExamScheduler.findAllSchedules(rooms1, courses1);
    if (allPossible1.size() != 0) {
      System.out.println("testFindAllSchedules() failed for case with no valid schedules");
      return false;
    }
    Room[] rooms2 = {new Room("Room1", 75), new Room("Room2", 100), new Room("Room3", 15)};
    Course[] courses2 = {new Course("CS200", 15), new Course("CS300", 80), new Course("CS400", 70)};
    ArrayList<Schedule> allPossible2 = ExamScheduler.findAllSchedules(rooms2, courses2);
    if (allPossible2.size() != 2) {
      System.out.println("testFindAllSchedules() failed for case with two classes in one room");
      return false;
    }
    return true;
  }
  
  /**
   * tests the findSchedule() method in ExamScheduler() class
   * 
   * @return returns true if all tests pass, returns false if any tests fail
   */
  public static boolean testFindSchedule() {
    Room[] rooms = {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses = {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 75)};
    try {
      Schedule schedule = ExamScheduler.findSchedule(rooms, courses);
    } catch(IllegalStateException e) {
      System.out.println("testFindSchedule() failed for normal case");
      return false;
    }
    Room[] rooms1 = {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 50)};
    Course[] courses1 = {new Course("CS200", 50), new Course("CS300", 110), 
        new Course("CS400", 75)};
    try {
      Schedule schedule1 = ExamScheduler.findSchedule(rooms1, courses1);
    } catch(IllegalStateException e) {
      System.out.println("testFindSchedule() failed for case that doesn't work on first time");
      return false;
    }
    Room[] rooms2 = {new Room("Room1", 20), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses2 = {new Course("CS200", 200), new Course("CS300", 110), 
        new Course("CS400", 75)};
    try {
      Schedule schedule2 = ExamScheduler.findSchedule(rooms2, courses2);
    } catch(IllegalStateException e) {
      return true;
    }
    System.out.println("testFindSchedule() failed for case with no valid schedules");
    return false;
  }
  
  /**
   * main method
   * 
   * @param args - unused
   */
  public static void main(String[] args) {
    System.out.println("testCourse(): " + testCourse());
    System.out.println("testRoom(): " + testRoom());
    System.out.println("testScheduleAccessors(): " + testScheduleAccessors());
    System.out.println("testAssignCourse(): " + testAssignCourse());
    System.out.println("testFindAllSchedules(): " + testFindAllSchedules());
    System.out.println("testFindSchedule(): " + testFindSchedule());
  }
}
