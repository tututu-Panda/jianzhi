
// 将其加入list集合中,再通过重写排序方法,进行排序

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int n;
        // 定义返回的字符串
        StringBuilder s= new StringBuilder();

        ArrayList<Integer> list= new ArrayList<>();

        n=numbers.length;

        // 将数组加入list集合中
        for(int i=0;i<n;i++){
            list.add(numbers[i]);

        }

        // 利用lambda重写sort排序
        // 比较两个数字的大小进行排序
        list.sort((str1, str2) -> {
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;
            return s1.compareTo(s2);
        });

        for(int j:list){
            s.append(j);
        }
        return s.toString();
    }
}
