
// 本题所给数组为二叉排序树的后序遍历,即LRT,所以最后一位为根节点
// 所以可以通过根节点判断出左右子树
//
// 首先判断出左边小于根节点的,得到中间值,即大于根节点的
// 再判断右边是否都大于根节点,如果右边存在小于根节点的,即得到的右边下标不等于所传入数组的长度,则错误
//
// 如果成功,则依次通过递归实现左右子树的判断
//
//

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int length = sequence.length;
        if(length == 0)
            return false;
        boolean b = isBST(sequence, 0, length-1);
        return b;
    }
    public boolean isBST(int [] seq, int l, int h){
        // 遍历到最后为1个节点时,则正确
        if(l == h)
            return true;
        // 找到左边小于root的子树,右边大于root的子树,mid为中间分界点
        int mid = l;
        while(seq[mid] < seq[h] && mid < h) mid++;
        // 判断右边是否为大于root的子树
        int right = mid;
        while(seq[right] > seq[h] && right < h) right++;
        // 即在右边存在小于root的子树,则返回false
        if(right < h)
            return false;
        // 如果只存在一个分支
        if(mid == l || mid == h)
            return isBST(seq,l,h-1);
        else{
            // 递归判断左右子树是否正确
            return isBST(seq,l,mid-1) && isBST(seq,mid,h-1);
        }
    }
}
