package com.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class SecondLargestElement
{
	public static void main(String[] args)
	{
		int arr[] =
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		SecondLargestElement.Jio(arr);

	}

	private static void Jio(int[] arr)
	{
		List<Integer> asList = Arrays.asList(2, 8, 47, 1, 0, 2, 0, 9, 2, 6, 5, 2, 22);

		System.out.println(asList);

		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 8, 47, 1, 0, 2, 0, 9, 2, 6, 5, 2, 22));

		System.out.println(arrayList);

		TreeSet<Integer> treeSet = new TreeSet<>(arrayList);
		System.out.println(treeSet);

		ArrayList<Integer> sortList = new ArrayList<>(treeSet);

		System.out.println(sortList);

		System.out.println(sortList.get(sortList.size() - 2));

	}

}
