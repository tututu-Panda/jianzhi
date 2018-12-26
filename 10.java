
// 类似斐波那契数列
// f(n) = f(n-1) + f(n-2)
//

public class Solution {
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        if(target  == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int i1 = 1;
        int i2 = 2;
        while(target-- > 2){
            i2 += i1;
            i1 = i2 - i1;
        }

        return i2;
    }
}
