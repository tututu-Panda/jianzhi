
// 实现获取最小值,可以通过两个栈实现
// 一个普通栈实现入栈和出栈
// 一个最小栈,进行最小值的插入
// 但在普通栈插入的时候,如果值依旧比最小值大,那么应该再插入一个最小值,方便以后进行出栈操作

public class Solution {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    public void push(int node) {
        s1.push(node);
        // 如果最小栈为空
        if(s2.isEmpty())
            s2.push(node);
        // 如果比最小栈还小
        else if(node <= this.min()){
            s2.push(node);
        }
        // 如果比最小栈中的值大,则应该再次插入最小值
        else{
            s2.push(s2.peek());
        }
    }
    public void pop() {
        s1.pop();
        s2.pop();
    }
    public int top() {
        return s1.peek();
    }
    public int min() {
        return s2.peek();
    }
}
