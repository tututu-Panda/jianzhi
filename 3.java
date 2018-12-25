
// 可以直接利用递归的方式
// 首先一直递归到最后,然后将其添加到新的链表中
//
//
public class Solution {

    // 只能是全局变量,否则无法更新
    ArrayList<Integer> l1 = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        // 递归
        if(listNode != null){
            this.printListFromTailToHead(listNode.next);
            // 将数据添加到list中
            l1.add(listNode.val);
        }
        return l1;
    }
}
