
// 方法一: 可以通过直接排序后,选出第一个值,即为最小数
//
//
// 方法二: 利用二分方法,找到最小数
// 首先找到数组的中间数
// ①  如果该中间数比最高位大时,那么该数组是把后半部分旋转到前面的,所以需要在后半部分查找最小值
//
// ②  如果该中间数比最高位小时, 那么该数组的旋转并没有影响前半部分,所以需要在前半部分查找最小值
//
// ③  如果该中间数与最高位相等时,无法判断具体位置, 只能从最高位往前一个个查找最小的
//


public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(len == 0){
            return 0;
        }
        int low = 0, high = len-1;
        while(low < high){
            int mid = (low + high) / 2;
            // 当中间的数比最高位大时,最小数一定在mid的右半部分
            if(array[mid] > array[high]){
                low = mid+1;
            }
            // 当中间的数与最高位相等时,无法判断具体位置,只能一个个试
            else if (array[mid] == array[high]){
                high = high - 1;
            }
            // 当中间的数比高位小时,最小数一定在mid的左半部分
            else{
                high = mid;
            }
        }
        return array[low];
    }
}
