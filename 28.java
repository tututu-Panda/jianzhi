
// 首先找出数组中出现次数最多的数
// 然后确定该数出现的次数进行比较即可

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int c = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] == c)
                count++;
            else{
                if(count == 0){
                    c = array[i];
                    count = 1;
                }else{
                    count--;
                }
            }
        }
        for(int i = 0; i < array.length; i++){
            if(c == array[i])
                count++;
        }
        if(count <= array.length/2 )
            return 0;
        return c;
    }
}
