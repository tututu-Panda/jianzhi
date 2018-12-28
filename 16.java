
// 方法一: 递归方式
// 从第一个较小链表开始递归
//
//
// 方法二:非递归方式(比较耗时)
// 新建一个头结点,循环从两个链表中选较小的加入到头结点
//
//

public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }
        else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
}




public ListNode Merge(ListNode list1,ListNode list2) {
        // 新建头结点
        ListNode list3 =  new ListNode(-1);
        list3.next = null;
        // 保存新建的头结点,以免断链
        ListNode list4 = list3;

        while(list1 != null && list2 != null){
            // 选取较小的加入新链表
            if(list1.val > list2.val){
                list3.next = list2;
                list2 = list2.next;
            }else{
                list3.next = list1;
                list1 = list1.next;
            }
            list3 = list3.next;
        }

        // 将未遍历完的加入头结点
        while(list1 != null)
            list3.next = list1;
        while(list2 != null)
            list3.next = list2;
        return list4.next;
}
