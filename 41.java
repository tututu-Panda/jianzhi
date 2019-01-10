
// 因为是连续数的所有和为某个数
// 因此该所有数可以利用数学规律,最低位数和最高位数的之和*之间的个数/2
// 便可以定义两个指针,一个低位指针,一个高位指针
// 当他们之间和的数小于某个数时,高位移动,低位不动
// 当之间和的数大于某个数时,低位移动,高位不动
// 一直遍历到低位与高位相等为止.

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        while(low < high){
            int all = (low + high) * (high - low + 1) / 2;
            if(all == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = low; i <= high; i++){
                    list.add(i);
                }
                result.add(list);
                low++;
            }
            else{
                if(all < sum){
                    high++;
                }else{
                    low++;
                }
            }
        }
        return result;
    }
}
