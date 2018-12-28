
// 首先想到的就是通过递归的方式实现
// 既然是判断子树,那么应该首先找到子树所在位置
// 又与因为子树的头结点相等的可能有多个,因此需要全部遍历完才行

public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean b = false;
        if(root1 != null && root2 != null){
            // 如果找到子树的节点就进行判断是否为子树
            if(root1.val == root2.val){
                b = HasSubtree1(root1,root2);
            }
            // 如果不是该子树,那么还应该继续找,因为还可能存在另一个相等的头结点
            if(b == false){
                b = HasSubtree(root1.left,root2);
            }
            if(b == false){
                b = HasSubtree(root1.right,root2);
            }
        }
        return b;
    }
    public boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        // 当二叉树遍历完为null后,证明该二叉树为子树
        if(root2 == null)
            return true;
        // 如果原二叉树遍历完而可疑二叉树没有遍历完,那么该二叉树不是子树
        if(root1 == null)
            return false;
        // 如果两个二叉树的值不同也不是
        if(root1.val != root2.val){
            return false;
        }
        // 如果值相等且都不空,那么继续遍历
        return HasSubtree1(root1.left,root2.left) && HasSubtree1(root1.right,root2.right);
    }
