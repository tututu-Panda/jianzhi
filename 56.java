
// 利用递归求解

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)
            return null;

        if(pHead != null && pHead.next == null)
            return pHead;

        ListNode current;

        // 如果当前节点等于下一个节点
        if(pHead.next.val == pHead.val){
            current = pHead.next.next;
            // 定义下下个节点,然后找出与当前节点不相等的节点
            while(current != null && current.val == pHead.val)
                current = current.next;
            // 继续递归遍历
            return deleteDuplication(current);
        }
        else{
            current = pHead.next;
            // 不相等,则应该保证不断链,然后递归下一个
            pHead.next = deleteDuplication(current);
            return pHead;
        }
    }
}
