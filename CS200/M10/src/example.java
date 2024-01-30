import java.util.ArrayList;

public class example {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        list.add( new ArrayList<String>());
        System.out.println(list);                             

        list.add( new ArrayList<String>());
        System.out.println(list);                             

        list.add(1, new ArrayList<String>());
        System.out.println(list);                             

        list.get(1).add("D");
        System.out.println(list);                             

        list.set(0, list.get(1));
        System.out.println(list);                             

        list.get(2).clear();
        System.out.println(list);                    
    }
}
