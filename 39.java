
//从下往上递归求树的高度,判断高度是否大于1

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        // 平衡二叉树的特点是左右子树高度差的绝对值小于等于1
        if(root == null)
            return true;
        // 递归到最下节点
        IsBalanced_Solution(root.left);
        IsBalanced_Solution(root.right);

        // 求最下面节点的高度
        int lh = TreeDepth(root.left);
        int rh = TreeDepth(root.right);

        int b = Math.abs(lh - rh);
        if(b > 1)
            return false;
        return true;
    }
    public int TreeDepth(TreeNode root){
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
