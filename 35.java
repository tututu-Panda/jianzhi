
// 普通的两次遍历肯定不行,时间复杂度为o(n^2)
//
// 参考网上的答案,大多用的归并排序
//
// 1. 把数据从中间分为前后两个数组,然后递归到每个数组仅剩下一个数据项
//
// 2. 合并数组,合并时,如果前面的数组值array[i]大于后面的array[j],则前面数组i~mid都大于j,因此count = count + mid - i + 1
//
//
//

public class Solution {
    int count = 0;
    public int InversePairs(int [] array) {
        // 归并排序
        mergeSort(array,0, array.length-1);

        return count;
    }
    public void mergeSort(int[] array, int low, int high) {

        if(low >= high)
            return ;

        int mid = (low + high) >> 1;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);

        // 进行排序
        merge(array,low,mid,high);

    }

    public void merge(int[] array, int low, int mid, int high) {

        // 将最后的结果存储到temp数组,最后复制到array中
        int [] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;
        // 遍历两个数组, 将较小的存储到temp数组中
        while(i <= mid && j <= high){
            // 如果前面的数组值小于后面的数组值,则不构成逆序,前面的指针继续走
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            }
            // 如果前面的数组大于后面的数组值,则从i开始到mid都大于j,则逆序数总数便加上mid-i+1
            // 后面的指针继续走,继续统计
            else{
                temp[k++] = array[j++];
                count += mid - i + 1;
                count %= 1000000007;
            }
        }

        while(i <= mid)
            temp[k++] = array[i++];

        while(j <= high)
            temp[k++] = array[j++];

        // 将temp数组复制到array中,注意是从low开始存储
        // 因为每次传入的low不同,如果从0开始,那么复制的数组便会出错
        System.arraycopy(temp,0,array,low,temp.length);
        //for(k = 0; k < temp.length; k++)
         //   array[low + k] = temp[k];

    }
}
