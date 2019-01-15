
// 利用递归进行判断

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)
            return true;
        return isTrue(pRoot.left,pRoot.right);
    }


    boolean isTrue(TreeNode t1,TreeNode t2){
        if(t1 == null  && t2 == null)
            return true;
        if(t1 != null && t2 != null)
            // 判断值是否相等,判断t1的左边是否等于t2的右边,t1的右边是否等于t2的左边
            return t1.val == t2.val && isTrue(t1.left,t2.right) && isTrue(t1.right, t2.left);
        // 以上都不成立则返回false
        return false;
    }
}
