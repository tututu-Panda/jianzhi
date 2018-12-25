
// 本题给的字符串是StringBuffer,只有String类中含有替换的方法
// 故将其转换为String
// 但在利用String.replaceAll方法时,需注意:
// String.replaceAll替换时,是返回的新的字符串
// 因此需要定义一个新的字符串用于存储
//
//
// replaceAll (String regex, String replacement)
//
//
//

public class Solution {
    public String replaceSpace(StringBuffer str) {
        String str1 = str.toString();
        String s2 = "";
        s2 = str1.replaceAll(" ","%20");
        return s2;
    }
}
