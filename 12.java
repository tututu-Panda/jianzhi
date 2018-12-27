
// 1.传统方法:时间复杂度为O(n)
// 这里次方数如果负数,则把它转换为整数再取导数即可

public double Power(double base, int exponent) {
        if(base == 0)
            return 0;
        int ex = abs(exponent);
        double b = 1;
        for(int i = 0; i < ex; i++){
            b *= base;
        }
        if(exponent < 0)
            return 1/b;
        return b;
}


// 2.快速幂方法:
// 通过二进制形式,将幂化为: a^11 = (a ^ (2 ^ 3)) *( a ^(2 ^ 1)) *( a^(2 ^ 0));
// 因此可以通过以为实现,复杂度为O(logn)
//
//
public static double Power(double base, int exponent) {

        double res = 1;
        int ex = abs(exponent);

        while(ex!=0){
            // 当二进制位数为1时,结果乘以翻倍的基数
            // 为0时表示该二进制所在基数为0,结果不用乘以基数
            if((ex&1) ==1){
                res *= base;
            }
            base *= base;   // 翻倍
            ex >>= 1;   // 右移一位
        }
        if(exponent < 0)
            return 1/res;

        return res;

}
