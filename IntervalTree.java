import java.util.*;
class Interval {
 int start, end;
 public Interval(int start, int end) {
 this.start = start;
 this.end = end;
 }
}
class IntervalTree {
 private TreeMap<Integer, Interval> treeMap;
 public IntervalTree() {
 this.treeMap = new TreeMap<>();
 }
 public void insertInterval(int start, int end) {
 treeMap.put(start, new Interval(start, end));
 }
 public void deleteInterval(int start, int end) {
 treeMap.remove(start);
 }
 public List<Interval> findOverlappingIntervals(int start, int end) {
 List<Interval> result = new ArrayList<>();
 for (Interval interval : treeMap.values()) {
 if (interval.start <= end && interval.end >= start) {
 result.add(interval);
 }
 }
 return result;
 }
}