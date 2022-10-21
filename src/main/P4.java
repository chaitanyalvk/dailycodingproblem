package main;

/*
 * Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */
public class P4 {

	public static void main(String[] args) {
		int[] arr = {3, 4, -1, 1};
		
		System.out.println(findFirstMissingPositiveInteger(arr));
		
		int[] arr2 = {-10,10,2,0,5};
		
		System.out.println(findFirstMissingPositiveInteger(arr2));
		
		int[] arr3 = {2,1,0};
		
		System.out.println(findFirstMissingPositiveInteger(arr3));

	}

	private static int findFirstMissingPositiveInteger(int[] arr) {
		
		for(int i=0; i<arr.length;i++) {
			while((i+1 != arr[i]) && (arr[i]>0 && arr[i]<=arr.length)) {
				swap(arr, i, arr[i]-1);
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			if(i+1!=arr[i]) return i+1;
		}
		
		return arr.length + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
