package com.BinarySearch;

import java.util.Arrays;

public class BinarySearch
{
	public static void main(String[] args)
	{
		int arr[] = new int[]
		{ 5, 9, 2, 0, 7, 3, 6 };

		int searching = 99;

		if (Jio(arr, searching))
		{
			System.out.println("Yes Found");
		}
		else
		{
			System.out.println("Not found");
		}
	}

	public static boolean Jio(int arr[], int key)
	{
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int low = 0;
		int high = arr.length - 1;

		while (low <= high)
		{
			int mid = (low + high) / 2;
			System.out.println(arr[mid]);
			if (key == arr[mid])
			{
				return true;
			}
			else if (key < arr[mid])
			{
				high = mid - 1;

			}
			else
			{
				low = mid + 1;
			}

		}

		return false;
	}
}
