
// 寻找第n个小的丑数,则将第一个质数与2,3,5相乘,得到第二个最小的丑数,并移动相应的指针
// 再求下一个最小丑数,一次类推

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        // 第一个最小丑数
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        // 一直添加到index个丑数
        while(list.size()<index){
            int m2 = list.get(i2)*2;
            int m3 = list.get(i3)*3;
            int m5 = list.get(i5)*5;
            // 得到最小的丑数
            int min = Math.min(m2,Math.min(m3,m5));
            list.add(min);
            // 这里可能相等,因此每个指针都要进行比较
            if(min == m2) i2++;
            if(min == m3) i3++;
            if(min == m5) i5++;
        }
        return list.get(list.size()-1);
    }
}
