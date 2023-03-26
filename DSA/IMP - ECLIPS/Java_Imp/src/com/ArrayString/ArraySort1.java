package com.ArrayString;

public class ArraySort1
{
	public static void Sort1(int arr[])
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = 0; j < arr.length - 1; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args)
	{
		int arr[] =
		{ 2, 5, 7, 8, 6, 56, 14, -2 };
		ArraySort1.Sort1(arr);

		for (int i = 0; i < arr.length - 1; i++)
		{
			System.out.println(arr[i]);
		}

	}
}
