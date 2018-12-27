
public ListNode ReverseList(ListNode head) {
        // 保存已经反转的链表
        ListNode pre = null;
        // 保存未反转的链表
        ListNode next = null;
        while(head != null){
            // 保存head.next,保证head不会断链,并保存为反转的数据(next = 2->3->4)
            next = head.next;
            // 反转链表,让当前节点指向前一个节点(1->2->3->4   null<-1 2->3->4)
            head.next = pre;
            // 移向下一个节点,继续反转(pre = 1)
            pre = head;
            // 将未反转的节点赋给head,继续循环(haed = 2->3->4)
            head = next;
        }
        return pre;
}
