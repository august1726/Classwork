
public class PracticeTester {
  public static boolean testIndexOfOversizeArray() {
    String[] data = new String[] {"S", "Z", "U", "O", "R", null, null, null, null};
    int size = 5;
    if(Practice.IndexOf("S", data, size) != 0) {
      System.out.println("First successful search test scenario failed");
      return false;
    }
    if(Practice.IndexOf("R", data, size) != 4) {
      System.out.println("Second successful search test scenario failed");
      return false;
    }
    return true;
  }
}
