package com.hadoop.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.hadoop.global.ICount;

public class Count implements ICount {

	public static Map<String, double[]> longMap = new HashMap<String, double[]>();
	
	public static Count newInstanse(){
		return new Count();
	}

	public Map<String, double[]> count(ArrayList<ArrayList<Object>> list) {
		// TODO Auto-generated method stub
		// need check

		double[] line = null;

		// count:startTime to endTime puls 1/speed
		// al:url;id;length;startTime;endTime;speed
		for (ArrayList<Object> al : list) {
			// init array line
			line = new double[Integer.parseInt(String.valueOf(al.get(2)))];

			// put the line
			if (line != null) {
				if (longMap.entrySet() != null) {
					Arrays.fill(line, 1);

					for (int i = Integer.parseInt(String.valueOf(al.get(3))); i <= Integer
							.parseInt(String.valueOf(al.get(4))); i++) {
						line[i] += (1 / Double.parseDouble(String.valueOf(al
								.get(5))));
					}
					longMap.put(String.valueOf(al.get(0)), line);
				} else {
					for (Map.Entry<String, double[]> shotMap : longMap
							.entrySet()) {
						if (shotMap.getKey().equals(String.valueOf(al.get(0)))) {
							for (int i = Integer.parseInt(String.valueOf(al
									.get(3))); i <= Integer.parseInt(String
									.valueOf(al.get(4))); i++) {
								shotMap.getValue()[i] += (1 / Double
										.parseDouble(String.valueOf(al.get(5))));
								longMap.put(shotMap.getKey(),
										shotMap.getValue());
							}
						} else {
							// function Arrays.fill: for(int
							// j=0;j<line.length;j++){line[j]=1;}
							Arrays.fill(line, 1);

							for (int i = (Integer) al.get(3); i <= (Integer) al
									.get(4); i++) {
								line[i] += (1 / Double.parseDouble(String
										.valueOf(al.get(5))));
							}
							longMap.put(String.valueOf(al.get(0)), line);
						}
					}
				}
			}
		}
		return longMap;
	}

}
