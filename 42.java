
// 方法一(参考他人):定义两个指针,一个低,一个高
// 如果高与低所指数字相加为sum,则将其添加
// 否则,如果相加<sum, 那么最大指针不需要移动,往右移动最低指针,因为这个该最低指针所指的数在该数组中已经不可能存在数相加为sum
// 同理,如果相加>sum,需要往左移动最大指针

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        int low = 0, high = array.length - 1;
        while(low < high){
            if(array[low] + array[high] == sum) {
                list.add(array[low]);
                list.add(array[high]);
                break;
            }

            while(low < high && array[low] + array[high] < sum) ++low;
            while(low < high && array[low] + array[high] > sum) --high;

        }
        return list;
    }
}




// 方法二:利用HashMap,遍历从最低位开始,将该数需要的数加入map中,再一次遍历寻找该数需要的数,第一次找到的即为最小
// 首先遍历一边数组,加该数与所需相加为sum的数添加到value与key中
// 在遍历一次数组,从最低往高找,如果map中,包含该key,添加到list中

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            int other = sum - array[i];
            map.put(other,array[i]);
        }
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                list.add(array[i]);
                list.add(map.get(array[i]));
                break;
            }
        }
        return list;
    }
}
