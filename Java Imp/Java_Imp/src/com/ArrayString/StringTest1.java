package com.ArrayString;

public class StringTest1
{
	public static void main(String[] args)
	{
		String str = "I,am,parimal,biswas";

		String reverse1 = Jio(str).trim();

		System.out.println(reverse1);
	}

	private static String Jio(String str)
	{
		String[] arr = str.split(",");

		String strNew = "";
		for (int i = arr.length - 1; i >= 0; i--)
		{
			strNew += arr[i].trim() + " ";
		}

		return strNew;

	}
}
