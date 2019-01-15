
// 如果有环
// 那么可以定义一个快指针,一个慢指针,一个快指针,快指针循环都比慢指针快一步
// 如果相遇了那么一定包含环,且快指针比慢指针多走了环的一圈
//
// 那么再根据相遇的点,可以循环一遍,求出环中个数
// 再定义两个指针,一个快指针比慢指针多走了环中的个数的步数
// 然后两个指针同时走,相遇的地方即为入口

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        // 求出相遇的地方
        ListNode meetnode = meetingNode(pHead);

        if(meetnode == null)
            return null;
        // 求出环中个数
        int num = 1;
        ListNode p1 = meetnode;
        while(p1.next != meetnode){
            num++;
            p1 = p1.next;
        }
        p1 = pHead;


        // 快指针多走环中的个数的步数
        while(num-- > 0){
            p1 = p1.next;
        }
        ListNode p2 = pHead;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode meetingNode(ListNode head){
        if(head == null)
            return null;
        // 定义慢指针
        ListNode slow = head.next;
        if(slow == null)
            return null;
        // 定义快指针
        ListNode fast = slow.next;
        // 如果相遇,肯定包含环,且已经走了一圈
        // 如果不相遇则不包含环
        while(slow != null && fast != null){
            if(slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
            // 每次都比慢指针多走一步
            if(slow != fast){
                fast = fast.next;
            }
        }
        return null;
    }
}
