package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);

        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);

        MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
        System.out.println(a.maxDepth_DFS(tree));

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax,rightMax)+1;
    }

    public int maxDepth_BFS(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i< size ; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(queue.size() > 0)
                depth++;
        }

        return depth;
    }

    public int maxDepth_DFS(TreeNode root) {
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int cnt = value.pop();
            max = Math.max(max,cnt);

            if(node.left != null ){
                stack.push(node.left);
                value.push(1+cnt);
            }
            if(node.right != null){
                stack.push(node.right);
                value.push(1+cnt);
            }
        }

        return max;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}