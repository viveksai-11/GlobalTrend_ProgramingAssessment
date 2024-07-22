
public class ContainerWithMostWater {
 public int maxArea(int[] height) {
 int maxArea = 0;
 int left = 0, right = height.length - 1;
 while (left < right) {
 int width = right - left;
 int currentHeight = Math.min(height[left], height[right]);
 maxArea = Math.max(maxArea, width * currentHeight);
 if (height[left] < height[right]) {
 left++;
 } else {
 right--;
 }
 }
 return maxArea;
 }
}