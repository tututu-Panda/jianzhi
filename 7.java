
// 本题的一般方法是通过递归实现,但是如果给的数据过大
// 会造成递归的栈溢出,因此此方法无法通过面试
//
// 于是可以通过方法内的循环,而不是通过递归实现
// 这样很大程度上节约了内存空间
//


public class Solution {
    public int Fibonacci(int n) {
        int f1 = 0, f2 = 1;
        while(n-- > 0){
            f2 += f1;
            f1 = f2 - f1;
        }
        return f1;
    }
}
