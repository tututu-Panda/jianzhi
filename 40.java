
// 利用HashMap与stack的特点
// 先将所有数据出现的次数存入HashMap,再遍历HashMap,将其中值为1的出栈

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        // 将所有值加入HashMap
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                int temp = map.get(array[i]);
                map.put(array[i],++temp);
            }
            else{
                map.put(array[i], 1);
            }
        }

        // 再遍历HashMap,找出值为1的数字
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                s.push(entry.getKey());
        }

        num2[0] = s.pop();
        num1[0] = s.pop();
    }
}
