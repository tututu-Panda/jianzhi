
// 如果有公共节点,首要前提是两个链表从某个节点开始,长度一致
// 因此必须先把两个链表的长度保持相同,长的先走几步,到达短的长度
//
// 所以步骤可以分为2步
// 1. 将两个链表的长度保持一致,长的先走 两个链表长度的差 的步数
// 2. 依次比较两个长度的值是否相同,相同则为第一个公共节点
//

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
             return null;
        int len1 = ListLength(pHead1);
        if(len1 > len2){
            pHead1 = walk(pHead1, len1-len2);
        }else{
            pHead2 = walk(pHead2, len2-len1);
        }
        while(pHead1 != null){
            if(pHead1.val == pHead2.val)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
    public int ListLength(ListNode list){
        int len = 0;
        while(list != null) {
            list = list.next;
            len++;
        }
        return len;
    }
    public ListNode walk(ListNode list, int len){
        while(len-- > 0){
            list = list.next;
        }
        return list;
    }
}
