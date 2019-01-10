
// 先将str利用空格转为char字符组
// 再从后往前加到新的str中
// 注意最后一个字符不需要空格

public class Solution {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] st = str.split(" ");
        StringBuffer s = new StringBuffer();
        for(int i = st.length-1; i >= 0; i--){
            if(i > 0){
            s.append(st[i]+" ");
            }else{
            s.append(st[i]);
            }
        }
        return s.toString();
    }
}
