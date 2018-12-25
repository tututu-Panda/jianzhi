
// 队列是先进先出的,栈是后进先出
// 因此通过两个栈实现队列可以
// 栈1进行入,栈2进行出
// 栈2出的时候,先把栈1进的内容反回来,然后出栈
// 再把栈2剩下的内容重新push到栈1
//
//

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }


    public int pop() {
        int i;

        // 当栈1不为空时, 将栈的内容返回来赋值给栈2,及先进的就在栈2的第一个了
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        // 出栈
        i = stack2.pop();

        // 当出栈后栈2不为空,又将栈1的内容还原
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return i;
    }
}
