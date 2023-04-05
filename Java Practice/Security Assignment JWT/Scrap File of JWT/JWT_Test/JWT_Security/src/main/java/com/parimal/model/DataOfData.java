package com.parimal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataOfData
{

	static List<List<String>> dataList1 = null;

	static
	{
		dataList1 = new ArrayList<>();

		dataList1.add(Arrays.asList("Parimal", "Java"));
		dataList1.add(Arrays.asList("Lalu", "Blockchain"));
		dataList1.add(Arrays.asList("Kalu", "Node JS"));
		dataList1.add(Arrays.asList("Bulu", "Dot Net"));
	}

	public static List<List<String>> getData()
	{
		return dataList1;
	}
}
