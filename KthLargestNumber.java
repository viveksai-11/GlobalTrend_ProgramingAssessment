import java.util.Arrays;
import java.util.Scanner;
 public class KthLargestNumber {
 public static void main(String[] args) {

 Scanner sc = new Scanner(System.in);
 System.out.println("Enter the value of k:");
 int k = sc.nextInt();
 System.out.println("enter the size of array ");
 int n=sc.nextInt();
 int[] a = new int[n];
 System.out.println("Enter the elements of the array:");
 for (int i = 0; i < n; i++) {
 a[i] = sc.nextInt(); }
 sc.close();
 Arrays.sort(a);
 if (k > 0 && k <= a.length) {
 System.out.println("The " + k + "-th largest element is: " + a[a.length - k]);
}
else {
 System.out.println("Invalid input for k");
 }
 }
}