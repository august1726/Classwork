import java.util.ArrayList;
import java.util.Iterator;
public class test {
  public static void main(String[] args) {
  ArrayList<String> list = new ArrayList<String>();
  list.add("A");
  list.add("B");
  list.add("C");
  Iterator<String> iter = list.iterator();
  while (iter.hasNext()) {
    System.out.print(iter.next());
  }
  }
}
