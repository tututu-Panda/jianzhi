
// 求二叉树的深度,可以利用递归求左右两个子树的最大值+1

public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int lh = TreeDepth(root.left);
        int rh = TreeDepth(root.right);
        if(lh > rh)
            return lh+1;
        else
            return rh+1;
    }
}
