package com.web.sort;

import java.util.Arrays;

/**
 * 冒泡排序（从小到大）
 * 思想：对n个数进行排序，每次都是由前一个数跟后一个数比较，每循环一轮，
 * 就可以将最大的数移到数组的最后， 总共循环n-1轮，成功对数组排序。
 * @author 18852
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr= {3,8,6,2,1,8};
		bubbleSort(arr);
	}
	/**
	 * 排序
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		if(arr==null)
			return;
		int len=arr.length;
		//i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
		for(int i=0;i<len-1;i++) {
			//j控制比较次数，第i次循环内需要比较len-i次
			//但是由于是由arr[j]跟arr[j+1]进行比较，所以为了保证arr[j+1]不越界，j<len-i-1
			for(int j=0;j<len-i-1;j++) {
				//如果前一个数比后一个数大，则交换位置将大的数往后放。
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
			//打印每次循环结束之后数组的排序状态（方便理解）
			System.out.println("第"+(i+1)+"次循环之后效果："+Arrays.toString(arr));
		}
	}
}
