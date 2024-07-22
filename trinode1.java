class TrieNode {
 boolean isEndOfWord;
 TrieNode[] children;
 public TrieNode() {
 isEndOfWord = false;
 // Initialize children array for 26 lowercase English letters
 children = new TrieNode[26];
 }
}
class Trie {
 private TrieNode root;
 public Trie() {
 // Initialize the Trie with an empty root node
 root = new TrieNode();
 }
 public void insert(String word) {
 TrieNode node = root;
 // Traverse each character in the word
 for (char c : word.toCharArray()) {
 // Calculate index for current character 'c'
 int index = c - 'a';
 // If current character node does not exist, create a new node
 if (node.children[index] == null) {
 node.children[index] = new TrieNode();
 }
 // Move to the next node
 node = node.children[index];
 }
 // Mark the end of the word
 node.isEndOfWord = true;
 }
 public boolean search(String word) {
 TrieNode node = root;
 // Traverse each character in the word
 for (char c : word.toCharArray()) {
 int index = c - 'a';
 // If current character node does not exist, return false
 if (node.children[index] == null) {
 return false;
 }
 // Move to the next node
 node = node.children[index];
 }
 // Return true if we reached the end of a valid word
 return node.isEndOfWord;
 }
 public boolean startsWith(String prefix) {
 TrieNode node = root;
 // Traverse each character in the prefix
 for (char c : prefix.toCharArray()) {
 int index = c - 'a';
 // If current character node does not exist, return false
 if (node.children[index] == null) {
 return false;
 }
 // Move to the next node
 node = node.children[index];
 }
 
 return true;
 }
}
public class trinode1 {
 public static void main(String[] args) {


 trie.insert("apple");
 trie.insert("banana");
 trie.insert("apricot");
 System.out.println(trie.search("apple")); 
 System.out.println(trie.search("apricot"));
 System.out.println(trie.search("banana")); 
 System.out.println(trie.search("orange"));

 System.out.println(trie.startsWith("ap")); 
 System.out.println(trie.startsWith("ban"));
 System.out.println(trie.startsWith("ora"));
 }
}