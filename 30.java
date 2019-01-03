
// 求连续的最大数,则起始点可以为中间的数
// 那么当某个连续数想加小于0时,应该重新计算最大值

public class Solution {

    int max = 0;
    public int FindGreatestSumOfSubArray(int[] array) {
        int curmax = 0;         // 定义当前最大值
        int max = 0x80000000;   // 定义负无穷,即最大数

        for(int i = 0; i < array.length; i++){
            // 如果之前想加的数已经小于或等于0了,那么需要重新开始求最大连续数
            if(curmax <= 0)
                curmax = array[i];
            // 否则继续相加
            else{
                curmax += array[i];
            }
            if(curmax > max)
                max = curmax;
        }
        return max;
    }
}
