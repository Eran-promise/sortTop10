package com.web.sort;

import java.util.Arrays;

/**
 * 选择排序(从小到大)
 * 思想：选择排序可以说是冒泡排序的改良版，不再是前一个数跟后一个数相比较， 而是在每一次循环内都由一个数去跟
 * 所有的数都比较一次，每次比较都选取相对较小的那个数来进行下一次的比较，并不断更新较小数的下标
 * 这样在一次循环结束时就能得到最小数的下标，再通过一次交换将最小的数放在最前面，通过n-1次循环之后完成排序。
 * 这样相对于冒泡排序来说，比较的次数并没有改变，但是数据交换的次数大大减少。
 * 
 * @author 18852
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,8,6,2,1,8};
		selectSort(arr);
	}
	
	public static void selectSort(int[] arr) {
		if(arr==null)
			return;
		int len=arr.length;
		//i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
		for(int i=0;i<len-1;i++) {
			//minIndex 用来保存每次比较后较小数的下标。
			int minIndex=i;
			//j控制比较次数，因为每次循环结束之后最小的数都已经放在了最前面，
			//所以下一次循环的时候就可以跳过这个数，所以j的初始值为i+1而不需要每次循环都从0开始，并且j<len即可
			for(int j=i+1;j<len;j++) {
				//每比较一次都需要将较小数的下标记录下来
				if(arr[minIndex]>arr[j]) {
					minIndex=j;
				}
			}
			//当完成一次循环时，就需要将本次循环选取的最小数移动到本次循环开始的位置。
			if(minIndex!=i) {
				int temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
			//打印每次循环结束之后数组的排序状态（方便理解）
			System.out.println("第"+(i+1)+"次循环之后效果："+Arrays.toString(arr));
		}
	}
}
