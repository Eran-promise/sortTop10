package com.web.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 思想：就是将待排序数据拆分成多个关键字进行排序，也就是说，基数排序的实质是多关键字排序。
 * 多关键字排序的思路是将待排数据里德排序关键字拆分成多个排序关键字；
 * 第1个排序关键字，第2个排序关键字，第3个排序关键字......然后，根据子关键字对待排序数据进行排序。
 * @author 18852
 *
 */
public class RedixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {720,6,57,88,60,42,83,73,48,85};
		redixSort(arr,10,3);
		System.out.println(Arrays.toString(arr));
	}

	public static void redixSort(int[] arr, int radix, int d) {  
        // 缓存数组  
        int[] tmp = new int[arr.length];  
        // buckets用于记录待排序元素的信息  
        // buckets数组定义了max-min个桶  
        int[] buckets = new int[radix];  
  
        for (int i = 0, rate = 1; i < d; i++) {  
  
            // 重置count数组，开始统计下一个关键字  
            Arrays.fill(buckets, 0);  
            // 将data中的元素完全复制到tmp数组中  
            System.arraycopy(arr, 0, tmp, 0, arr.length);  
  
            // 计算每个待排序数据的子关键字  
            for (int j = 0; j < arr.length; j++) {  
                int subKey = (tmp[j] / rate) % radix;  
                buckets[subKey]++;  
            }  
  
            for (int j = 1; j < radix; j++) {  
                buckets[j] = buckets[j] + buckets[j - 1];  
            }  
  
            // 按子关键字对指定的数据进行排序  
            for (int m = arr.length - 1; m >= 0; m--) {  
                int subKey = (tmp[m] / rate) % radix;  
                arr[--buckets[subKey]] = tmp[m];  
            }  
            rate *= radix;  
        }  
  
    }
}
