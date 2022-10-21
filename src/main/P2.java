package main;

import java.util.Arrays;

/*
 * Given an array of integers, return a new array such that each element at index i of the new array 
 * is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. 
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

 */
public class P2 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Arrays.stream(getProductOfOtherElements(arr)).forEach(elem -> System.out.println(elem));
		System.out.println();
		
		int[] arr2 = {3,2,1};
		Arrays.stream(getProductOfOtherElements(arr2)).forEach(elem -> System.out.println(elem));
	}

	private static int[] getProductOfOtherElements(int[] arr) {
		
		int[] prefixProduct = new int[arr.length];
		for (int i=0;i<arr.length;i++) {
			prefixProduct[i] = i > 0 ? prefixProduct[i-1]*arr[i-1] : 1 ;
		}
		
		int[] suffixProduct = new int[arr.length];
		for (int i=arr.length-1;i>=0;i--) {
			suffixProduct[i] = i < arr.length - 1 ? suffixProduct[i+1]*arr[i+1] : 1 ;
		}
		
		int[] result = new int[arr.length];
		for (int i=0;i<arr.length;i++) {
			result[i] = prefixProduct[i] * suffixProduct[i];
		}
		return result;
	}

}
