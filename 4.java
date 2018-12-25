
// 本题与王道书上的类似,但王道上的是c语言且给定的(A,B,l1,h1,l2,h2)
// 可以直接调用长度
//
//
//
//
// 本题的难点在于如何传入数组
// 经过查询资料,找到了数组的copy方法
// Arrays.copyOfRange(int[] original, int from, int to) // to是不包含的!!!
// 但是这个copy方法是赋值给新的数组的,所以需要重新申请一个新数组存放
//
//
//
//
//
// 首先先序遍历的第一个节点为根节点,中序遍历的根节点的左边为左子树,右边为右子树
// 根据此规律便可以利用递归的思想
// 先找到先序中的根节点,在遍历中序,找到根节点,存储该位置到i中
// 再根据i将左右两边划分
// 先序遍历的左子树为(1---left),中序遍历的左子树为(0---left-1) 但是copyOfRange方法查找的范围不包含to,因此left = i+1
// 同理,先序遍历的右子树为(pre.len-right+1---pre.len), 中序遍历的右子树为(in.len-right+1, in.len)
//
//
//
//
//
// 与本题类似的还有中序和后序,只是序号求的位置不一样而已,方法类似
//
//

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int i = 0;

        // 当数组长度为0时,即不存在数了
        // 返回null
        if(pre.length == 0 )
            return null;

        // 首先找到根结点
        TreeNode root = new TreeNode(pre[0]);

        // 从中序遍历中找到根节点的下标
        while(root.val != in[i]){
            i++;
        }


        // 算出左子树的最后一个数的下标
        int left = i+1;

        // 算出右子树的最后一个数的下标
        int right = in.length-i;

        // 当左子树不为空时
        if(left != 0){
            // 将左子树数据,存储到新数组中,继续遍历
            int [] leftpre =  Arrays.copyOfRange(pre,1,left);
            int [] leftin = Arrays.copyOfRange(in,0,left-1);
            root.left = reConstructBinaryTree(leftpre, leftin);
        }else{
            // 当左子树不存在时,返回null
            root.right = null;
        }

        // 当右子树不为空时
        if(right != 0){
            // 方法同理,找下标,复制到新数组,继续遍历
            int [] rightpre =  Arrays.copyOfRange(pre,pre.length-right+1,pre.length);
            int [] rightin = Arrays.copyOfRange(in,in.length-right+1,in.length);
            root.right = reConstructBinaryTree(rightpre,rightin);
        }else{
            root.right = null;
        }


        return root;
    }
}
