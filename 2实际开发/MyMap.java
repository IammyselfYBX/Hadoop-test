package com.map;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MyMap extends Mapper<LongWritable,Text,Text,IntWritable>{
	
	private final static IntWritable line = new IntWritable();
	   private Text word = new Text();
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		     StringTokenizer itr = new StringTokenizer(value.toString());
		     int i =1;
		     while (itr.hasMoreTokens()) {
		    	 line.set(i);
		    	 word.set(itr.nextToken());
		    	 context.write(word, line);
		    	 i++;
		     }

		}



}