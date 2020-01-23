package com.job;


import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.been.Use;
import com.map.MyMap;
import com.reduse.MyReduse;

public class TestJob {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		@SuppressWarnings("deprecation")
		Job job = new Job();
		job.setJarByClass(Job.class);
		job.setJobName("Max_temperature");
		Use u = new Use();
		u.setIp("");
		FileInputFormat.addInputPath(job, new Path("hdfs://"+u.getIp()+"/test/input/testin"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://"+u.getIp()+"/test/output"));
		
		job.setMapperClass(MyMap.class);
		job.setReducerClass(MyReduse.class);
		
		/*
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		System.out.println("Map "+job.getMapOutputKeyClass()+job.getMapOutputValueClass());
		//设置Map函数的输出类型
		*/
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		System.out.println("Put "+job.getOutputKeyClass()+job.getOutputValueClass());
		//设置输出的文件类型
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
