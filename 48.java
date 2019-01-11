
// 利用自加自减实现

public class Solution {
    public int Add(int num1,int num2) {
        if(num1 > 0){
            while(num1-- != 0){
                num2++;
            }
        }
        else if (num1 < 0){
            while(num1++ != 0){
                num2--;
            }
        }
        return num2;
    }
}
