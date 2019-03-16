
// 1. 复制每个节点, 并将其插入该节点的后面 如:复制A得到A1,将其插入A后面
// 2. 遍历链表,将A的随机指针的下个元素赋值给A1  A1->radom = A->random->next
// 3. 将链表拆分为原链表和复制后的链表

public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
          return null;


        // 保存头指针,防止断链
        RandomListNode temp = pHead;
        // 遍历头指针
        while(temp != null){
            // 复制节点A
            RandomListNode t = new RandomListNode(temp.label);
            // 复制节点A
            t.next = temp.next;
            // 将A1插入A的下一个
            temp.next = t;
            // 移动A指针
            temp = t.next;
        }

        // 赋值head指针,继续遍历
        temp = pHead;
        while(temp != null){
            // 复制A的下一个指针,因为A1为复制A的下一个,所以random必须复制下一个
            RandomListNode t = temp.next;
            if(temp.random != null){
                // 复制random指针(A->A1->B->B1->C->C1->D->D1  如果A->Random = D ,则需要复制A1->random = D1)
                t.random = temp.random.next;
            }
            temp = t.next;
        }
        // 得到复制后的头指针
        RandomListNode clone = pHead.next;
        RandomListNode tep;
        temp = pHead;
        // 将原链表还原
        // 因为现在链表为A->A1->B->B1->C->C1
        while(temp.next != null){
            tep = temp.next;
            temp.next = tep.next;
            temp = tep;
        }
        return clone;
    }
}
