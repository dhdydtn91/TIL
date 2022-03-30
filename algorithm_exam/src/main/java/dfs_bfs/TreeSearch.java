package dfs_bfs;

import java.util.Stack;

public class TreeSearch {

  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.right = new Node(3);
    node.right.left = new Node(6);
    node.right.right = new Node(7);

    solution(node);
  }

  private static void solution(Node node) {
    Stack<Node> stack =new Stack();
    stack.push(node);
    while(!stack.isEmpty()){
      Node pop = stack.pop();
      if(pop.right != null){
        stack.push(pop.right);
      }
      System.out.println(pop.val);

      if(pop.left != null){
        stack.push(pop.left);
      }
    }

  }

}

class Node {
  int val;
  Node left , right;

  public Node(int val) {
    this.val = val;
  }

  public Node(Node left, Node right) {
    this.left = left;
    this.right = right;
  }

  public Node(int val, Node left, Node right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}