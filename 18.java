
// 通过递归实现左右子树的互换
// 可以通过先循环到最左子树再交换
// 也可以先交换再循环
//

public class Solution {
    public void Mirror(TreeNode root) {
        if(root != null ){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
