package com.hadoop.hadoop;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WJob {
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 */
	/*
	 * Job类，用于调用map和reduce函数
	 */
	public static WJob newInstanse(){
		return new WJob();
	}
	
	public void job() throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * if(args.length !=2){
		 * System.err.println("Usage: MaxTemperature <input path> <output path>"
		 * ); System.exit(-1); }
		 */
		long startTime = System.currentTimeMillis();

		@SuppressWarnings("deprecation")
		Job job = new Job();
		job.setJarByClass(WJob.class);
		job.setJobName("hadoop_of_video");

		FileInputFormat.addInputPath(job, new Path(
				"hdfs://master:9000/WHadoop/input/output"));
		// 输入路径
		FileOutputFormat.setOutputPath(job, new Path(
				"hdfs://master:9000/WHadoop/output"));
		// 输出路径

		job.setMapperClass(WMap.class);
		System.out.println(job.getMapperClass());
		job.setReducerClass(WReduce.class);
		System.out.println(job.getReducerClass());

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		System.out.println("Map " + job.getMapOutputKeyClass()
				+ job.getMapOutputValueClass());
		// 设置Map函数的输出类型

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		System.out.println("Put " + job.getOutputKeyClass()
				+ job.getOutputValueClass());
		// 设置输出的文件类型
		// System.out.println(job.waitForCompletion(true));
		System.out.println(job.waitForCompletion(true) ? true : false);

		long endTime = System.currentTimeMillis();
		System.out.println(((endTime - startTime) / 1000));
	}

}
