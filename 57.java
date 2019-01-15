
// 情况一: 该节点含有右子树:那么直接找到右子树的最左节点
//
// 情况二: 该节点不含右子树,如果其位于其父节点的左边,则直接返回父节点,否则继续向上寻找

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
            return null;
        // 含有右子树,如果右子树含有子树,则找到右子树的最左节点
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        // 不含有右子树
        while(pNode.next != null){
            // 如果节点位于左边,则返回父节点
            if(pNode.next.left == pNode)
                return pNode.next;
            // 否则继续向上寻找
            pNode = pNode.next;
        }
        // 没找到,则返回null(位于根节点的最右边)
        return null;
    }
}
