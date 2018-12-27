
// 通过定义两个指针实现,快指针比慢指针快k个
// 当快指针走到第k个位置时,两个指针同时移动,那么当快指针走到末尾时,慢指针便是倒数第k个数
//

public ListNode FindKthToTail(ListNode head,int k) {
        // 定义两个指针,q快p指针k个数
        ListNode p = head;
        ListNode q = head;

        if (head == null || k <= 0)
            return null;

        // 进行移动,移动k个,如果中途q的下一个为空那么该数不存在
        for(int i = 1; i < k; i++){
            if(q.next == null)
                return null;
            q = q.next;
        }
        if(q == null){
            return null;
        }

        // 两个指针同时移动
        while(q.next != null){
            q = q.next;
            p = p.next;
        }
        return p;
}
