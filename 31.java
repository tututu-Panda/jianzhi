
// 1.分治法
// 对于n = 12, 可以拆分为01~09, 10~12 f(12) = f(10-1)+f(12-10)+3, 其中3代表最高位1的数字个数,这里就是10,11,12
//
// 对于n = 132, 可以拆分为0~99,100~132,即f(132) = f(100-1)+f(132-100)+33, 其中33代表最高位为1的数字的个数,这里就是100-132百位数字的1出现了33次
//
// 对于n = 232, 可以拆分为0~99,100~232, 即f(232) = 2*f(100-1)+f(32)+100, 因为232大于199,所以它包括了所有最高位为1的数字,即100~199,共100个
//
// 于是得出,最后加的常数C只根最高位是否为1有关
// 当最高位为1时, C = n % 最高位 + 1 (去掉最高位后,剩下的数字加1)
// 当最高位大于1时, C = 10 ^ (bit - 1) (10的最高位减1次方)
//
//

int CountOne(int n){
    long count = 0;

    if(n == 0)
        count = 0;

    else if(n > 1 && n < 10)
        count = 1;

    else{

        long highest = n ;  // 表示最高位的数字

        // 求出最高位位数
        int bit = 0;
        while(highest >= 10){

            highest = highest / 10;
            bit++;
        }
        // 求出最高位的权重,相当于求出10的最高位次方(如bit = 3, 则weight = 10^3 = 1000)
        int weight = (int)Math.Pow(10,bit);

        // f(n) = f(weight - 1) + f(n-weight) + C
        if(highest == 1){

            count = CountOne(weight-1) + CountOne(n-weight) + (n - weight + 1);

        }

        else{

            count = highest * CountOne(weight - 1) + CountOne(n - highest * weight) + weight;

        }
    }
    return count;

}



// 2. 找出每个位置出现1的频率, 将它们加起来
//
// 当百位数 >= 2时, 百位为1的情况又(a/10+1)*100个数字 如31256, a=312,b=56, (a/10+1)对应于0~31,且每一个数字对应范围是100个数字(末尾0~99)
//
// 当百位数 = 1时, 共有(a / 10) * 100 + (b + 1)
//
// 当百位数 = 0 时, 共有(a / 10) * 100个数
//
// 统一表达方式,即当百位数>=2或=0时,有[(a+8)/10]*100, 当百位=1时,有[(a+8)/10]*100+(b+1)
//
// 即[(a+8)/10]*100+(a%10==1)?(b+1):0;
//
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
         for (long m = 1; m <= n; m *= 10)
            // 左边为高位数的1的个数,右边为低位数的1的个数
            // n / m % 10 得到高位数
            // n % m + 1为低位1的个数
            ones += (n/m + 8) / 10 * m
                +(n/m % 10 == 1 ? n%m + 1 : 0);
         return ones;
    }
}
