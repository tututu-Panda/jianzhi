

// 从左往右,从上往下是递增的
// 因此如果从左上角或右下角开始进行比较,无法得知具体应该往哪儿方向递增或递减
// 所以只能从左下角或右上角开始
// 从左下角开始,则当前数大于target时,往右移动一行
// 当前数小于target时,往上移动一行

// !!! 注意: 因为二维数组可能存在行数与列数不等的情况. 如:[[]] 行为1,列为0
//           所以必须分开获取行数和列数

public class Solution {

    public boolean Find(int target, int [][] array) {
        int i, j;
        int k = array.length-1;
        i = k; j = 0;
        while( i >= 0 && j <= array[0].length-1){
            if(array[i][j] == target)
                return true;
            //比当前数大
            else if(array[i][j] > target){
                i--;
            }
            // 比当前数小
            else{
                j++;
            }

        }
        return false;
    }
}
