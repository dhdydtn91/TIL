package Graph;

import java.util.Queue;

public class MaximumDepthOfBinaryTree {


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);

        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.right = new TreeNode(7);

        MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
        System.out.println(a.maxDepth(tree));

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax,rightMax)+1;


    }
}

class TreeNode{
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}