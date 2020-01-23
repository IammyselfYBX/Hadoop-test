package com.hadoop.hadoop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.hadoop.util.Count;

public class WMap extends Mapper<LongWritable, Text, Text, Text> {
	/*
	 * Map类
	 */
	private static Text line = null;
	private Text url = null;
	private static Map<String,double[]> instantMap = null;

	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Object>> mapArray = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> al = new ArrayList<Object>();
		StringTokenizer itr = new StringTokenizer(value.toString(), "+");
		StringTokenizer shotItr = null;
		// count()
		// al:url;id;length;startTime;endTime;speed
		while (itr.hasMoreTokens()) {
			al = new ArrayList<Object>();
			shotItr = new StringTokenizer(itr.nextToken().toString(), "-");
			while(shotItr.hasMoreTokens()){
				al.add(shotItr.nextToken());
			}
			mapArray.add(al);
		}
		instantMap = Count.newInstanse().count(mapArray);
		for(Map.Entry<String, double[]> entryMap : instantMap.entrySet()){
			url = new Text(entryMap.getKey());
			String s = new String();
			s+="[";
			for(int i = 0; i < entryMap.getValue().length; i++){
				s+=String.format("%.2f", entryMap.getValue()[i]);
				if(i < entryMap.getValue().length-1){
					s+=",";
				}
			}
			s+="]\r\n";
			line = new Text(s);
			context.write(url, line);
		}

	}
}
