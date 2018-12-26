
// 本题与斐波那契类似,都是通过递增实现
//
// 首先,如果n=1 ,则有1种跳法. n=2, 有2种
// 但n=3时, 与斐波那契不同,需要自身加1, 因为可以直接通往n
// 故 f(n)=f(n-1)+f(n-2)+...+f(1)+1;
//
//
//
// 查看他人求解时,另一种思路是根据公式
// f(n) = 2^(n-1)
// 因此可以直接通过位运算求解
// 向左移动一位,即实现了乘以二的操作
// f(n) = 1 << (target-1)
//

public class Solution {
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int i1 = 1;
        int i2 = 2;
        int i3 = 0;
        while(target-- > 2){
            i3 += i1+i2+1;
            i1 = i2;
            i2 = i3-i2-1;
        }

        return i3;
    }
}
