import java.util.*;
public class Palindrome {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter a string: ");
 String input = sc.nextLine();
 sc.close();
 if (isPalindrome(input)) {
 System.out.println("Palindrome");
 } else {
 System.out.println("Not a palindrome");
 }
 }
 
 public static boolean isPalindrome(String str) {
 // Remove all non-alphanumeric characters and convert to lowercase
 String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
 int left = 0;
 int right = cleanStr.length() - 1;
 while (left < right) {
 if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
 return false; // Characters do not match, not a palindrome
 }
 left++;
 right--;
 }
 return true; 
 }
}