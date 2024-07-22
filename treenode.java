import java.util.*;
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) {
 val = x;
 }
}
class Codec {
 // Encodes a tree to a single string.
 public String serialize(TreeNode root) {
 if (root == null) {
 return "null";
 }
 Queue<TreeNode> queue = new LinkedList<>();
 StringBuilder sb = new StringBuilder();
 queue.add(root);
 while (!queue.isEmpty()) {
 TreeNode node = queue.poll();
 if (node == null) {
 sb.append("null,");
 } else {
 sb.append(node.val).append(",");
 queue.add(node.left);
 queue.add(node.right);
 }
 }
 return sb.toString();
 }
 // Decodes your encoded data to tree.
 public TreeNode deserialize(String data) {
 if (data.equals("null")) {
 return null;
 }
 String[] values = data.split(",");
 Queue<TreeNode> queue = new LinkedList<>();
 TreeNode root = new TreeNode(Integer.parseInt(values[0]));
 queue.add(root);
 int i = 1;
 while (!queue.isEmpty()) {
 TreeNode node = queue.poll();
 if (!values[i].equals("null")) {
 node.left = new TreeNode(Integer.parseInt(values[i]));
 queue.add(node.left);
 }
 i++;
 if (!values[i].equals("null")) {
 node.right = new TreeNode(Integer.parseInt(values[i]));
 queue.add(node.right);
 }
 i++;
 }
 return root;
 }
}