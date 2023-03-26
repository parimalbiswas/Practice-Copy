package com.ArrayString;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest1
{

	public static void Jio(int arr[], int limit)
	{

		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }

		List<Integer> innerList = new ArrayList<>();
		List<List<Integer>> outerList = new ArrayList<>();

		// System.out.println("+++++++++++++++++");
		for (int i = 0; i < arr.length; i++)
		{

			// System.out.println("====================");
			innerList.add(arr[i]);
			// System.out.println(innerList);

			if ((i + 1) % limit == 0)
			{

				outerList.add(new ArrayList<>(innerList));
				innerList.removeAll(innerList);
			}

		}

		outerList.add(new ArrayList<>(innerList));

		System.out.println(outerList);
	}

	public static void main(String[] args)
	{
		int arr[] =
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int limit = 3;

		ArrayTest1.Jio(arr, limit);

	}

}
