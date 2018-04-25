package com.web.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 思想：
 * @author 18852
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {72,6,57,88,60,42,83,73,48,85};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {
		if(arr==null) {
			return;
		}
		int len=arr.length;
		//构建大顶堆
		for(int i=len/2-1;i>=0;i--) {
			adjustHeap(arr,i,len);
		}
		//
		for(int j=len-1;j>0;j--) {
			swap(arr,0,j);
			adjustHeap(arr,0,j);
		}
	}
	
	public static void adjustHeap(int[] arr,int i,int j) {
		int temp=arr[i];
		for(int k=2*i+1;k<j;k=2*k+1) {
			if(k+1<j && arr[k]<arr[k+1]) {
				k++;
			}
			if(arr[k]>temp) {
				arr[i]=arr[k];
				i=k;
			}
		}
		arr[i]=temp;
	}
	
	public static void swap(int[] arr, int num1,int num2) {
		int temp=arr[num1];
		arr[num1]=arr[num2];
		arr[num2]=temp;
	}
}
