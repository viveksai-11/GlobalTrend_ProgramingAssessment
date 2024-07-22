import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class ConcurrentModificationDemo {
 public static void main(String[] args) {

 List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
 
 try {
 for (String s : list) {
 if (s.equals("B")) {
 list.remove(s); 
 }
 }
 } catch (Exception e) {
 System.out.println("Concurrent modification exception");
 }

 Iterator<String> iterator = list.iterator();
 while (iterator.hasNext()) {
 String s = iterator.next();
 if (s.equals("B")) {
 iterator.remove(); // Safe to remove element "B" using iterator
 }
 }

 System.out.println("List after removing 'B': " + list);
 }
}
