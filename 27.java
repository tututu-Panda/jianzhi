
// 1. 递归实现
// (1)对于无重复的情况
//
// 固定第一个字符,递归取得首位后面的各种字符串组合
// 再把第一个字符与后面每个字符交换,并同样递归获得首位后面的字符串组合
//
//
// (2)对于重复的情况
// 如果一个数与后面的数字相同那么这两个数就不必进行交换了,因为结果相同
// 如:abb,第一个数与后面两个数交换得到bab,bba. 然后abb中第二个数和第三个数相同就不用进行交换
// 但是对bab,第二个数和第三个数不同,则需要交换,得到bba
// 由于这里的bba和开始交换的结果相同,则重复了,因此次方法不行
//
//
// 换种思维,对于abb,第一个数a与第二个数b交换得到bab,然后考虑第一个数与第三个数交换
// 此时由于第三个数等于第二个数,所以第一个数就不再与第三个数交换了
// 再考虑bab,它的第二个数与第三个数交换可以解决bba,此时全排列完成.

public class Solution {
    public void swap(char[] chars, int i, int j) {

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

    }
    public void PermutationHelper(char[] chars, int i, ArrayList<String> list) {

        // 当递归到最后一个数时,添加到集合中
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }
        else{

            // 定义Hashset,防止交换重复
            Set<Character> charset = new HashSet<>();

            for(int j = i; j < chars.length; j++){

                // 当位置为第一个时或不包含在防重集合中,则进行递归
                if(j == i || !charset.contains(chars[j])){
                    // 将该数添加到防重集合中
                    charset.add(chars[j]);
                    // 进行自身交换(相当于abc中,i为c,j为c,c与c进行交换)
                    swap(chars,i,j);
                    // 继续遍历
                    PermutationHelper(chars,i+1,list);
                    // 进行交替交换(相当于abc中,i为b,j为c,b与c进行交换)
                    swap(chars,j,i);
                }

            }
        }

    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();

        if(str != null && str.length() > 0){
            PermutationHelper(str.toCharArray(),0,list);
            // 按照全排列排序
            Collections.sort(list);
        }

        return list;
    }
}
