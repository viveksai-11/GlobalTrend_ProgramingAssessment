import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
class LRUCache {
 private int capacity;
 private Map<Integer, Integer> cache;
 private LinkedList<Integer> accessOrder;
 public LRUCache(int capacity) {
 this.capacity = capacity;
 this.cache = new HashMap<>();
 this.accessOrder = new LinkedList<>();
 }
 public int get(int key) {
 if (cache.containsKey(key)) {
 // Move the accessed key to the front of the access order
 accessOrder.remove((Integer) key);
 accessOrder.addFirst(key);
 return cache.get(key);
 } else {
 return -1;
 }
 }
 public void put(int key, int value) {
 if (cache.containsKey(key)) {
 // Update the value and move the key to the front of the access order
 cache.put(key, value);
 accessOrder.remove((Integer) key);
 accessOrder.addFirst(key);
 } else {
 if (cache.size() >= capacity) {
 // Evict the least recently used key-value pair
 int lruKey = accessOrder.removeLast();
 cache.remove(lruKey);
 }
 // Add the new key-value pair and move the key to the front of the access order
 cache.put(key, value);
 accessOrder.addFirst(key);
 }
 }
}
public class cache {
 public static void main(String[] args) {
 // Example usage of LRUCache
 LRUCache cache = new LRUCache(2); // Capacity is 2
 cache.put(1, 1);
 cache.put(2, 2);
 System.out.println(cache.get(1)); 
 cache.put(3, 3); // Evicts key 2
 System.out.println(cache.get(2)); // Output: -1 (key 2 not found)
 cache.put(4, 4); // Evicts key 1
 System.out.println(cache.get(1));//-1 (key 1 not found)
 System.out.println(cache.get(3)); // Output: 3
 System.out.println(cache.get(4)); // Output: 4
 }
}