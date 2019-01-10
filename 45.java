
// 排序后先求出癞子个数
// 再求出前后两个数是否为排序数,如果不是便求出差,并将所有差相加
// 如果癞子个数大于差的和那么可以排序

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0)
            return false;
        int c = 0;
        int val = 0;
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length-1; i++){
            if(numbers[i] == 0) {
                c++;
                continue;
            }
            if(numbers[i+1] == numbers[i]){
                return false;
            }
            val += numbers[i+1] - numbers[i] - 1;
        }
        if(c >= val)
            return true;
        return false;
    }
}
