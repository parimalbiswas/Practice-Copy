package com.ArrayString;

public class StringTest2
{

	public static void main(String[] args)
	{
		String str = "I,am,parimal,biswas";
		String strNew = "";

		String[] arr = str.split(",");

		for (int i = 0; i < arr.length; i++)
		{
			if (i == arr.length - 1)
			{
				strNew += Jio(arr[i].trim()) + "";
			}
			else
			{
				strNew += Jio(arr[i].trim()) + ",";
			}
		}

		System.out.println(strNew);

	}

	private static String Jio(String str)
	{
		String strNew = "";
		for (int i = str.length() - 1; i >= 0; i--)
		{
			strNew += str.charAt(i);

		}
		return strNew;

	}
}
