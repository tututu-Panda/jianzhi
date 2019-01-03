
// 找出最小的k个数,那么想到了最小堆
// java中可以通过PriorityQueue实现最小堆
// 其也可以实现最大堆

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length || input.length == 0)
            return list;
        Queue<Integer> pq = new PriorityQueue<>(input.length);
        for(int i = 0; i < input.length; i++){
            pq.add(input[i]);
        }
        for(int i = 0; i < k; i++){
            list.add(pq.poll());
        }
        return list;
    }
}
