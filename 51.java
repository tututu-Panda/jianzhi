
// 首先根据规律可以得出
// B[0] = 1  * A1 * A2 * ... * An-1
// B[1] = A0 * A1 * A2 * ... * An-1
// B[2] = A0 * A1 * 1 *  ... * An-1
// ..
// ..
// B[n-1] = A0 * A1 *... * An-2
//
// 可以看出其可以划分为两个三角区域
// 一个下三角区域,一个上三角区域,且对角线为1,从上往下计算
//
// 那么可以先求出简单的下三角区域,定义B[0]=1 , 然后一次累计算出B[n] = B[n-1] * A[n-1]
// 其中B[n-1]是A数组中从0到n-2的类乘,所以需要再乘以一个A[n-1],才是整个B[n-1]的上三角结果
//
//
// 上三角区域需要从下往上计算
//
// 由于最后一项已经计算出来,所以应该从n-2项开始
// B[n] = B[n](之前根据下三角计算的部分结果) * temp(temp为1到A[n+1]的乘积)

public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
         if(len == 0)
            return B;

        // 计算下三角区域
        B[0] = 1;
        for(int i = 1 ; i < len; i++)
            B[i] = A[i-1] * B[i-1];

        // 计算上三角区域
        int temp = 1;
        for(int j = len-2; j >= 0; j--){
            temp *= A[j+1]; // 计算上三角区域的乘积
            B[j] *= temp;   // 求出最后的B[n]
        }
        return B;
    }
}
