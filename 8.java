
// 本题与斐波那契数列类似
// 但是本题的第一个数为1, 第二个数为2
// 再以斐波那契函数类推
//

public class Solution {
    public int JumpFloor(int target) {

        // 当target为1时, 只有一种方法
        if(target == 1){
            return 1;
        }

        // 当target为2时, 有两种方法
        if(target == 2){
            return 2;
        }


        int f1 = 1;
        int f2 = 2;

        // 当target大于1时, 斐波那契递增
        while(target-- > 1){
            // f1与f2想加的值赋值给f2
            f2 += f1;
            // 相当于把f2赋值给f1
            f1 = f2-f1;
        }
        return f1;
    }
}
