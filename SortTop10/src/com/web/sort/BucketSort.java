package com.web.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * 思想：桶排序其实就是计数排序的强化版，需要利用一个映射函数
 * 首先定义有限个数个桶，然后将待排序数组内的元素按照函数映射的
 * 关系分别放入不同的桶里边，现在不同的桶里边的数据已经做了区分，比如
 * A桶里的数要么全部大于B桶，要么全部小于B桶里的数。但是A，B桶各自里边的数
 * 还是乱序的。所以要借助其他排序方式（快速，插入，归并）分别对每一个元素个数大于一
 * 的桶里边的数据进行排序。最后再将桶里边的元素按照顺序依次放入待排序数组中即可。
 * @author 18852
 *
 */
public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {72,6,57,88,60,42,83,73,48,85};
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bucketSort(int[] arr) {
		if(arr==null)
			return;
		int len=arr.length;
		//定义桶的个数，这里k的值要视情况而定，这里我们假设待排序数组里的数都是[0,100)之间的。
		int k=10;
		//用嵌套集合来模拟桶，外层集合表示桶，内层集合表示桶里边装的元素。
		List<List<Integer>> bucket=new ArrayList<>();
		//for循环初始化外层集合即初始化桶
		for(int i=0;i<k;i++){
			bucket.add(new ArrayList<>());
		}
		//循环是为了将待排序数组中的元素通过映射函数分别放入不同的桶里边
		for(int i=0;i<len;i++) {
			bucket.get(mapping(arr[i])).add(arr[i]);
		}
		//这个循环是为了将所有的元素个数大于1的桶里边的数据进行排序。
		for(int i=0;i<k;i++) {
			if(bucket.size()>1) {
				//因为这里是用集合来模拟的桶所以用java写好的对集合排序的方法。
				//其实应该自己写一个方法来排序的。
				Collections.sort(bucket.get(i));
			}
			 
		}
		//将排好序的数重新放入待排序数组中
		int m=0;
		for(List<Integer> list:bucket) {
			if(list.size()>0) {
				for(Integer a:list) {
					arr[m++]=a;
				}
			}
		}
	}
	/**
	 * 映射函数
	 * @param num
	 * @return 
	 */
	public static int mapping(int num) {
		return num/10;
	}
}
