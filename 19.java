
// 通过对矩阵进行四个循环实现对数组的顺时针读取,因此定义四个变量,left,right,top,bottom
// 1.从左往右读取, 从left一直读取到right
//
// 2.从上往下读取,但读取的时候应该在top的下一层,否则会造成重复读取
//
// 3.从右往左读取,此时最右边一层已经读取了,因此应该从right-1开始读取
//
// 4.从下往上读取,此时最下边一层,以及最上面一层都已经读取了,所以应该从bottom-1开始,读取到top+1
//

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList l = new ArrayList();

        int row = matrix.length;
        int columns = matrix[0].length;
        if( row == 0 || columns == 0)
            return l;
        int left = 0;
        int top = 0;
        int right = columns-1;

        while(left <= right && top <= bottom ){

            // 从左往右
            for(int i=left; i <= right; i++) l.add(matrix[top][i]);

            // 从上往下
            for(int i=top+1; i <= bottom; i++) l.add(matrix[i][right]);

            // 从右往左
            if(top != bottom)   // 此处是为了确保矩阵不规则时,重复读取数据
                for(int i=right-1; i >= left; i--) l.add(matrix[bottom][i]);

            // 从下往上
            if(left != right)
                for(int i=bottom-1; i > top; i--) l.add(matrix[i][left]);

            left++; right--; top++; bottom--;

        }


        return l;
    }
}
