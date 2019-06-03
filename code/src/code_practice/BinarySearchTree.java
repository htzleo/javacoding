package code_practice;

import org.junit.Test;

public class BinarySearchTree {
    /* Class containing left and right child of current node and key value*/
    public static TreeNode1 sortedArrayToBST(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode1 root = null;
        root = recursion(A, 1, len, root);
        A = null;
        return root;
    }
    public static TreeNode1 recursion(int[] array, int lhs, int rhs, TreeNode1 root)
    {
        if(lhs <= rhs)
        {
            int mid = (lhs + rhs + 1) >> 1;
            root = new TreeNode1(array[mid-1]);
            root.left = recursion(array, lhs, mid - 1, root.left);
            root.right = recursion(array, mid + 1, rhs, root.right);
        }
        return root;
    }

    @Test
    public static void main(String[] args){
        int[] num = {23,2,24,56,78,4,6,2};
        TreeNode1 node = sortedArrayToBST(num);

    }
}
class TreeNode1 {
      public int val;
      public TreeNode1 left, right;
      public TreeNode1(int val) {
          this.val = val;
          this.left = this.right = null;
      }
}
