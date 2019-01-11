
// 方法一:递归

public class Solution {
    public int Sum_Solution(int n) {
        if(n == 1)
            return 1;
        else
            return Sum_Solution(n-1)+n;
    }
}



// 方法二:逻辑与 与递归,停止条件为,如果某个为假,那么后面不计算
//
public class Solution {
    public int Sum_Solution(int n) {
        int ans = n;
        // 当n-1为0时,左边为false,因此后面不会继续循环,便只会计算前面的所有和
        boolean b = (ans!=0) && ((ans += Sum_Solution(n-1))!=0);
        return ans;
    }
}

