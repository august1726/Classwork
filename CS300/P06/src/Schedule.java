//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Schedule
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

import java.util.Arrays;

/**
 * A schedule based on an array of available rooms and courses
 * 
 * @author August Bambenek
 */
public class Schedule {
  private Room[] rooms; //an array of the Room objects available for exams
  private Course[] courses; //an array of the Course objects which require exam rooms
  private int[] assignments; //n array where the integer at index N is the index of the room 
                             //that course[N] has been assigned to
  
  /**
   * initializes the rooms and courses arrays to the provided values, and creates an assignments 
   * array of the correct length where all values are -1, indicating that the corresponding course 
   * has not yet been assigned a room.
   * 
   * @param rooms - array of available rooms
   * @param courses - array of available courses
   */
  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[courses.length];
    Arrays.fill(this.assignments, -1);
  }
  
  /**
   * Initializes the rooms and courses arrays to the provided values and assignments to the 
   * provided assignments array
   * 
   * @param rooms - array of available rooms
   * @param courses - array of available courses
   * @param assignments - array of room assignments for all courses
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;
  }
  
  /**
   * returns the number of rooms available in this schedule
   * 
   * @return returns the number of rooms available in this schedule
   */
  public int getNumRooms() {
    return rooms.length;
  }
  
  /**
   * returns the Room object at the given index in the rooms array
   * 
   * @param index - index of the room in rooms array to be returned
   * @throws IndexOutOfBoundsException if input index is negative or larger than the largest index 
   * in the rooms array
   * @return returns the room at the index provided in rooms array
   */
  public Room getRoom(int index) {
    if(index < 0 || index >= rooms.length) {
      throw new IndexOutOfBoundsException("ERROR: index out of bounds for rooms array");
    }
    return this.rooms[index];
  }
  
  /**
   * returns the number of courses in this schedule
   * 
   * @return returns the number of courses in this schedule
   */
  public int getNumCourses() {
    return courses.length;
  }
  
  /**
   * returns the Course object at the given index in the courses array
   * 
   * @param index - index of the course in courses array to be returned
   * @throws IndexOutOfBoundsException if input index is negative or larger than the largest index 
   * in the courses array
   * @return returns the Course object at the given index in the courses array
   */
  public Course getCourse(int index) {
    if(index < 0 || index >= courses.length) {
      throw new IndexOutOfBoundsException("ERROR: index out of bounds for courses array");
    }
    return this.courses[index];
  }
  
  /**
   * returns true if and only if the course at the given index has been assigned a room; 
   * false otherwise
   * 
   * @param index - index of the course in courses array to be checked
   * @return returns true if and only if the course at the given index has been assigned a room; 
   * false otherwise
   */
  public boolean isAssigned(int index) {
    if(assignments[index] != -1) {
      return true;
    }
    return false;
  }
  
  /**
   * returns the Room object assigned to the course at the given index
   * 
   * @param index - index of the course to find the room assignment for
   * @throws IllegalArgumentException if the course has not been assigned a room
   * @throws IndexOutOfBoundsException with a descriptive error message if the given course index 
   * is invalid
   * @return returns the Room object assigned to the course at the given index
   */
  public Room getAssignment(int index) {
    if (index < 0 || index > assignments.length) {
      throw new IndexOutOfBoundsException("ERROR: index out of bounds for assignments array");
    }
    if (assignments[index] == -1) {
      throw new IllegalArgumentException("ERROR: course hasn't been assigned a room yet");
    }
    return rooms[assignments[index]];
  }
  
  /**
   * returns true if and only if all courses have been assigned to rooms; false otherwise
   * 
   * @return returns true if and only if all courses have been assigned to rooms; false otherwise
   */
  public boolean isComplete() {
    for(int i = 0; i < assignments.length; i++) {
      if(assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * returns a new Schedule object with the course at the first argument index assigned to the room 
   * at the second argument index
   * 
   * @param courseIndex
   * @param roomIndex
   * @throws IndexOutOfBoundsException with a descriptive error message if the given course or room 
   * index is invalid
   * @throws IllegalArgumentException with a descriptive error message if the given course has 
   * already been assigned a room, or if the room does not have sufficient capacity
   * @return returns a new Schedule object with the course at the first argument index assigned to 
   * the room at the second argument index
   */
  public Schedule assignCourse(int courseIndex, int roomIndex) {
    if (courseIndex < 0 || courseIndex > courses.length || roomIndex < 0 
        || roomIndex > rooms.length) {
      throw new IndexOutOfBoundsException("ERROR: an index is out of bounds");
    }
    if (assignments[courseIndex] != -1) {
      throw new IllegalArgumentException("ERROR: Course already assigned a room");
    }
    if (courses[courseIndex].getNumStudents() > rooms[roomIndex].getCapacity()) {
      throw new IllegalArgumentException("ERROR: not enough room for class");
    }
    int[] copyAssignments = Arrays.copyOf(assignments, assignments.length);
    copyAssignments[courseIndex] = roomIndex;
    Room[] copyRooms = Arrays.copyOf(rooms, rooms.length);
    copyRooms[roomIndex] = rooms[roomIndex].reduceCapacity(courses[courseIndex].getNumStudents());
    return new Schedule(copyRooms, courses, copyAssignments);
  }
  
  /**
   * returns a String representation of Each course and its room assignment in the schedule
   * 
   * @return returns a String representation of Each course and its room assignment in the schedule
   */
  @Override
  public String toString() {
    String line = "{";
    for(int i = 0; i < courses.length; i++) {
      line = line.concat(courses[i].getName() + ": ");
      if (assignments[i] == -1) {
        line = line.concat("Unassigned");
      }
      else {
        line = line.concat(rooms[assignments[i]].getLocation());
      }
      if (i < courses.length - 1) {
        line = line.concat(", ");
      }
    }
    return line.concat("}");
  }
  
}
