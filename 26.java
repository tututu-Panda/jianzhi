
// 考虑通过中序遍历,将节点的左右子树更改为左右链表
// 需要注意的是返回的是双向链表的头结点,故最后返回的时候应该返回最左节点

public class Solution {
     TreeNode pre = null;
     public TreeNode Convert(TreeNode pRootOfTree) {

         if(pRootOfTree == null)
             return pRootOfTree;
        // 更改节点指向
        Convert1(pRootOfTree);
        // 这里需要返回最左节点
        TreeNode root = pRootOfTree;
        while(root.left!=null)
            root = root.left;
        return root;
    }
    public void Convert1(TreeNode pRootOfTree) {
        // 1.有序:即中序遍历
        // 2. 双向链表
        // 3. 只能调节指针,则需要保存前指针,但后指针怎么实现?(后指针如果存在,则然前指针指向后指针)
       if(pRootOfTree == null)
           return ;
        Convert1(pRootOfTree.left);

        // 调整左节点
        pRootOfTree.left = pre;
        // 调整右节点
        if(pre != null){
            pre.right = pRootOfTree;
        }

        pre = pRootOfTree;

        Convert1(pRootOfTree.right);
    }
}
