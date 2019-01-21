
// 利用中序遍历找出第k小的数

// 如:{8,6,5,7} 找出k = 1
// 首先递归到最左边的5,然后继续找5的最左边,发现是空,那么index参数需要+1,发现相等,返回5
//
// 5的递归结束,返回到6,此时root = 6, node = 5.
// 需要继续向上返回5

public class Solution {
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot != null){
            // 递归到最左边
            TreeNode node = KthNode(pRoot.left,k);

            //递归结束条件: 如果node不为空,则返回该node,即已经找到了该第k个节点,需要向上返回
            if(node != null)
                return node;

            // index参数+1,如果与所给k相等,那么返回proot,因为递归并没有结束,因此需要继续逐层返回
            index++;
            if(index == k)
                return pRoot;

            // 继续递归到最右边
            node = KthNode(pRoot.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
}
