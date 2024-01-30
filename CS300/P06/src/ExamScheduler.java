//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exam Scheduler
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
// Persons:         CSLC (CS Learning Center)
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * Contains methods that generate schedules given arrays of rooms and courses
 * 
 * @author August Bambenek
 */
public class ExamScheduler {
  
  /**
   * returns a valid Schedule for the given set of rooms and courses, or throws an 
   * IllegalStateException if no such schedule exists. This method should contain only a call to 
   * the helper method, providing an empty starting Schedule
   * 
   * @param rooms - array of available rooms
   * @param courses - array of available courses
   * @throws IllegalStateException if no possible schedule exists
   * @return returns a valid schedule for the given rooms and courses
   */
  public static Schedule findSchedule(Room[] rooms, Course[] courses) {
    try {
      return findScheduleHelper(new Schedule(rooms, courses), 0);
    } catch (IllegalStateException e) {
      throw new IllegalStateException("ERROR: no possible schedule could be made");
    }
  }
  
  /**
   * recursive method that assigns all unassigned courses in a Schedule beginning from the index 
   * provided as an argument
   * 
   * @param schedule - schedule provided as input to be modified 
   * @param index - index of the course to be assigned
   * @throws IllegalStateException if an invalid schedule was made
   * @return returns a valid complete schedule
   */
  private static Schedule findScheduleHelper(Schedule schedule, int index) {
    if (index >= schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        return schedule;
      } 
      else {
        throw new IllegalStateException("ERROR: invalid schedule");
      }
    }
    else if (schedule.isAssigned(index)) {
      return findScheduleHelper(schedule, index + 1);
    }
    else {
      for(int i = 0; i < schedule.getNumRooms(); i++) {
        if (schedule.getCourse(index).getNumStudents() <= schedule.getRoom(i).getCapacity()) {
          try {
            return findScheduleHelper(schedule.assignCourse(index, i), index + 1);
          } catch (IllegalStateException e) {
            continue;
          }
        }
      }
      return findScheduleHelper(schedule, index + 1);
    }
  }
  
  /**
   * returns an ArrayList containing all possible Schedules for the given set of rooms and courses. 
   * (If none can be created, this ArrayList is empty.)
   * 
   * @param rooms - array of available rooms
   * @param courses - array of available courses
   * @return returns an ArrayList of all valid schedules given the input rooms and courses
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
    Schedule schedule = new Schedule(rooms, courses);
    return findAllSchedulesHelper(schedule, 0);
  }
  
  /**
   * recursive method that assigns all unassigned courses in a Schedule in ALL POSSIBLE ways, 
   * beginning from the index provided as an argument
   * 
   * @param schedule - schedule provided as input to be modified
   * @param index - index of the course to find a room for
   * @return returns an ArrayList containing all valid schedules
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
    ArrayList<Schedule> allPossible = new ArrayList<Schedule>();
    if (index >= schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        allPossible.add(schedule);
      }
    }
    else if (schedule.isAssigned(index)) {
      allPossible.addAll(findAllSchedulesHelper(schedule, index + 1));
    }
    else {
      for(int i = 0; i < schedule.getNumRooms(); i++) {
        if (schedule.getCourse(index).getNumStudents() <= schedule.getRoom(i).getCapacity()) {
          allPossible.addAll(findAllSchedulesHelper(schedule.assignCourse(index, i), index + 1));
        }
      }
    }
    return allPossible;
  }
  
}
