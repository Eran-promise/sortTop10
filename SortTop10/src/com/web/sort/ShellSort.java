package com.web.sort;

import java.util.Arrays;

/**
 * 希尔排序（由小到大）
 * 思想：希尔排序也称为"缩小增量排序"，原理是先将需要排的数组分成多个子序列
 * 这样每个子序列的元素个数就很少，再分别对每个对子序列进行插入排序。在该数组基本有序后
 * 再进行一次直接插入排序就能完成对整个数组的排序。所以，要采用跳跃分割的策略。这里引入
 * “增量”的概念，将相距某个增量的记录两两组合成一个子序列，然后对每个子序列进行直接插入排序
 * 这样得到的结果才会使基本有序（即小的在前边，大的在后边，不大不小的在中间）。希尔排序就是
 * 直接插入排序的升级版。
 * 
 * @author 18852
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,8,6,2,1,8,4,2,5,7,20};
		shellSort(arr);
	}
	/**
	 * 排序
	 * @param arr
	 */
	public static void shellSort(int[] arr) {
		if(arr==null)
			return;
		int len=arr.length;//数组的长度
		int k=len/2;//初始的增量为数组长度的一半
		//while循环控制按增量的值来划不同分子序列，每完成一次增量就减少为原来的一半
		//增量的最小值为1，即最后一次对整个数组做直接插入排序
		while(k>0) {
			//里边其实就是升级版的直接插入排序了，是对每一个子序列进行直接插入排序，
			//所以直接将直接插入排序中的‘1’变为‘k’就可以了。
			for(int i=k;i<len;i++) {
				int j=i;
				int target=arr[i];
				while(j>=k && target<arr[j-k]) {
					arr[j]=arr[j-k];
					j-=k;
				}
				arr[j]=target;
			}
			//不同增量排序后的结果
			System.out.println("增量为"+k+"排序之后："+Arrays.toString(arr));
			k/=2;
		}
	}
	
}
