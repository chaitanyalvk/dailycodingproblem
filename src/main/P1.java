package main;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

	For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class P1 {

	public static void main(String[] args) {
		
		int[] arr = {10,15,3,7};
		int k = 16;
		System.out.println(isPairThatSumsToKPresent(arr, k));

	}

	private static boolean isPairThatSumsToKPresent(int[] arr, int k) {
		
		Set<Integer> elemSet = new HashSet<>();
		for (int elem : arr) {
			if(elemSet.contains(k-elem))
				return true;
			elemSet.add(elem);
		}
		return false;
	}

}