package com.parimal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class DataOfData
{
	private List<List<String>> dataList1 = null;

	public DataOfData()
	{
		dataList1 = new ArrayList<>();

		dataList1.add(Arrays.asList("Parimal", "Java"));
		dataList1.add(Arrays.asList("Lalu", "Blockchain"));
		dataList1.add(Arrays.asList("Kalu", "Node JS"));
		dataList1.add(Arrays.asList("Bulu", "Dot Net"));
	}

}
