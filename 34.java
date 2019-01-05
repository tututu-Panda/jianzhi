
// 首先想到的是通过一个键值对存储
// 如果出现的字符串是第一次出现,那么它的值便为1
// 如果出现的字符串已经存在,那么便将存储的值加1
// 最后再一次遍历字符串,找到在键值对存储中的值,如果为1则该字符为唯一一个
//
//
// 我选择的是HashMap,看网上说HashMap存储元素具有无序性,不能使用,应该使用LinkedHashMap
// 因为LinkedHashMap是使用双链表维护条目的,链表顺序按照插入的顺序进行排序,而HashMap按照散列表的形式进行排序,具有无序性
// 但是这里并没有用到LinkedHashMap的特性,我们只需要存储字符串出现的次数,然后再一次遍历字符串得到字符串在Map中存储的值即可

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i),++time);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
