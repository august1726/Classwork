
public class Student {

  // data fields
  private static final String CAMPUS = "UW_Madison"; // campus name
  // a static final data field CANNOT be initialized in the constructor or within any other method
  private String first; // first name of this student
  private String last; // last name of this student
  private final int UNIQUE_ID; // campus unique id of this student
  private static int nextUniqueID = 100; // unique id to be assigned to the next student
  private static int numberOfStudents; // number of students created so far
  
  // constructor(s)
  public Student(String first, String last) {
    this.first = first;
    this.last = last;
    this.UNIQUE_ID = nextUniqueID; // instance final fields MUST be initialized in the constructor
    nextUniqueID++;
    numberOfStudents++;
  }

  // accessors/mutators
  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public static String getCampus() {
    return CAMPUS;
  }

  public int getUniqueID() {
    return UNIQUE_ID;
  }

  public static int getNumberOfStudents() {
    return numberOfStudents;
  }
  
  // other methods
  
}
