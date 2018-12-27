
// 1.以空间换时间
// 将所有奇数复制到一个数组前面,所有偶数复制到一个数组后面,再将该数组复制到目标数组
//
//
// 2. 直接插入方法
// 当下标的数为奇数时,将其插入到是偶数的前面
//
//

public void reOrderArray(int [] array) {
       int k = 0;

        int [] arr1 = new int[array.length];

        for(int i = 0 ; i < array.length; i++){

            if(array[i] % 2 == 1){
                arr1[k++] = array[i];
            }

        }
        for(int i = 0 ; i < array.length; i++){

            if(array[i] % 2 == 0){
                arr1[k++] = array[i];
            }

        }

        // 从源数组arr1的0开始,复制到目标数组array从下标0开始,复制length的长度
       System.arraycopy(arr1,0,array,0,arr1.length);

}


public void reOrderArray(int [] array) {
       for(int i = 0 ; i < array.length; i++){

            if(array[i] % 2 == 1 && i != 0){
                int j = i-1;
                int temp = array[i];
                for(; j>=0 && array[j] % 2 == 0; j--){
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
    }
}
