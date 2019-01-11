
// 利用linkedList的特性,进行删除操作
// 求需要删除的数字,那么应该为该数与总容量的余数,删除该数
// 再将该数作为第一个数,继续求需要删除的数
// 便可以通过一个数bt,第一次令为0,第二次赋值为余数,依次类推,直到只剩下一个数为止

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0)
            return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        int bt = 0;
        while(list.size()>1){
            // 从bt开始,求m-1的位置
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }
        return list.get(0);
    }
}
