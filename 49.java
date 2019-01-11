
// 遍历字符串,如果遍历中存在ASCII码不在'0' 与 '9'之间的则返回0
// 否则便从高位到低位得到数字

public class Solution {
    public int StrToInt(String str) {
        int n = str.length();
        if(n == 0)
            return 0;
        int symbol = 1; // 定义符号位
        int start = 0;
        char[] c = str.toCharArray();
        // 第一得到符号位,如果没有则默认为正
            if(c[0] == '+'){
                start = 1;
            }else if(c[0] == '-'){
                start = 1;
                symbol = -1;
            }
        // 第二次遍历求数据,如果存在非数字,令sum为0,并退出
        int sum = 0;
        for(int i = start; i < n; i++){
            if(c[i] < '0' || c[i] > '9'){
                sum = 0;
                break;
            }
            // 从高位向低位求得数字,c[i] - '0',是因为c[i]为ASCII码,减去'0'的ASCII码,便得到该数字
            sum = sum * 10 + c[i] - '0';
        }
        return symbol * sum;
    }
}
