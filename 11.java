

// 思路就是转换为2进制字符串,然后求字符串中的1的个数
//
//
//
// ps: 看到个天秀的代码:
//
// Integer.toBinaryString(n).replaceAll("0","").length();
//

public class Solution {
    public int NumberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0","").length(); }
}
//

public class Solution {
    public int NumberOf1(int n) {
        int i = 0;
        String s = Integer.toBinaryString(n);
        //System.out.println(s);
        Pattern p = Pattern.compile("1");
        Matcher m = p.matcher(s);

        while(m.find()){
            i++;
        }


        return i;
    }
}
