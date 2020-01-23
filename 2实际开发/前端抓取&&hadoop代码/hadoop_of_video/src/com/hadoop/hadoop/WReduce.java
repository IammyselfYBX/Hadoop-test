package com.hadoop.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WReduce extends Reducer<Text, Text, Text, Text> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.mapreduce.Reducer#reduce(KEYIN,
	 * java.lang.Iterable, org.apache.hadoop.mapreduce.Reducer.Context) reduce类
	 */
	private Text result = null;

	public void reduce(Text key, Text values, Context context)
			throws IOException, InterruptedException {
			result = new Text();
			result = values;
			context.write(key, result);
	}
}
