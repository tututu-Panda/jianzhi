
// 一. 暴力统计,直接循环数组,然后统计个数
//
// 二. 由于是排序数组,因此可以通过二分法求解,找到第一个出现k的位置,再找到最后一个出现k的位置
// 两者中间的个数加1便是出现的次数

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int high = HighPositon(array,k);
        int low = LowPositon(array,k);
        return high - low + 1;
    }
     public int HighPositon(int[] array, int k) {

        int low = 0;
        int high = array.length-1;
        int mid;
        while(low <= high){
            mid = (low + high) >> 1;
            // 注意是"<=",找出最后一个出现k的位置
            if(array[mid] <= k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return high;
    }

    public int LowPositon(int[] array, int k) {

        int low = 0;
        int high = array.length-1;
        int mid;
        while(low <= high){
            mid = (low + high) >> 1;
            // 注意为是"<",找到第一个出现k的位置
            if(array[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
}
