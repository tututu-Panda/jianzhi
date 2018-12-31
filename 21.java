
// 通过辅助栈模拟栈的出栈序列,最后判断栈是否为空
// 1. 首先将入栈顺序入辅助栈,然后找到弹出元素与栈顶相等的元素
// 2. 当找到后,出栈数列位置则向后移动一位,继续判断弹出元素是否等于辅助栈的栈顶元素,不相等则继续入栈

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        // 用于标识弹出序列的下标
        int PopIndex = 0;
        for(int i = 0; i < pushA.length; i++){
            // 首先将入栈顺序入辅助栈
            s.push(pushA[i]);
            // 当辅助栈不为空且辅助栈的栈顶元素与弹出序列相等时
            // 将其出栈,弹出下标加一位
            while(!s.isEmpty() && popA[PopIndex] == s.peek()){
                s.pop();
                PopIndex++;
            }
        }
        return s.isEmpty();
    }
}
