package code_practice;

import org.junit.Test;

import java.util.Arrays;

public class VBST {

    private  int lastvalue = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null)
            return true;
        if(!isValidBST(root.left))
            return false;

        if (!firstNode && lastvalue>=root.val){
            return false;
        }
        firstNode = false;
        lastvalue = root.val;

        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }

    @Test
    public static void main(String[] args){
        int[] nums = new int[]{2,2,7,5,4,3,2,2,1};
        System.out.println(Arrays.toString(nums));
    }
}
class TreeNode{
    public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
}
