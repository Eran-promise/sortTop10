package com.web.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 思想：总体概括就是从上到下递归拆分，然后从下到上逐步合并
 * 递归拆分：先把待排序数组分为左右两个子序列，再分别将左右两个子序列拆分为四个子子序列，以此类推
 * 直到最小的子序列元素的个数为两个或者一个为止。
 * 逐步合并（一定要注意是从下到上层级合并，可以理解为递归的层级返回）：将最底层的最左边的一个子序列排序，然后将从左到右第二个子序列进行排序，再将这两个排好序的
 * 子序列合并并排序，然后将最底层从左到右第三个子序列进行排序.....
 * 合并完成之后记忆完成了对数组的排序操作
 * @author 18852
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,8,6,2,1,8};
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 递归拆分
	 * @param arr 待拆分数组
	 * @param left 待拆分数组最小下标
	 * @param right 待拆分数组最大下标
	 */
	public static void mergeSort(int[] arr,int left,int right) {
		int mid=(left+right)/2; //中间下标
		if(left<right) {
			mergeSort(arr,left,mid);//递归拆分左边
			mergeSort(arr,mid+1,right);//递归拆分右边
			sort(arr,left,mid,right);//合并左右
		}
	}
	
	/**
	 * 合并两个有序子序列
	 * @param arr 待合并数组
	 * @param left 待合并数组最小下标
	 * @param mid 待合并数组中间下标
	 * @param right 待合并数组最大下标
	 */
	public static void sort(int[] arr,int left,int mid,int right) {
		int[] temp=new int[right-left+1]; //临时数组，用来保存每次合并年之后的结果
		int i=left;
		int j=mid+1;
		int k=0;//临时数组的初始下标
		//这个while循环能够初步筛选出待合并的了两个子序列中的较小数
		while(i<=mid && j<=right) {
			if(arr[i]<=arr[j]) {
				temp[k++]=arr[i++];
			}else {
				temp[k++]=arr[j++];
			}
		}
		//将左边序列中剩余的数放入临时数组
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		//将右边序列中剩余的数放入临时数组
		while(j<=right) {
			temp[k++]=arr[j++];
		}
		//将临时数组中的元素位置对应到真真实的数组中
		for(int m=0;m<temp.length;m++) {
			arr[m+left]=temp[m];
		}
	}
}
