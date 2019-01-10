
// 方法一:利用subString,substring返回的是字符串从某个位置开始到某个位置结束的子串
// 那么就将str累加一次,并求出n相对于字符串的偏移量,再返回该str从n开始到n+len的子串

public class Solution {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0)
            return "";
        n %= len;
        str += str;
        return str.substring(n,n+len);
    }
}

// 方法二:利用转置XY  YX = (X^T Y^T) ^ T
// 先将str中前n的字符交换
// 再将str中后面所有交换
// 再一次交换str中全部字符,便得到所求字符
//
public class Solution {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0)
            return "";
        char[] s = str.toCharArray();
        reverse(s,0,n-1);
        reverse(s,n,len-1);
        reverse(s,0,len-1);
        return String.valueOf(s);
    }
    public  void reverse(char[] s, int low, int high){
        char temp;
        while(low < high) {
            temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }

    }
}
