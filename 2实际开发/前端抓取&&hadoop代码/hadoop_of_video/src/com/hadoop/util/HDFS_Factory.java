package com.hadoop.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFS_Factory {
	public static HDFS_Factory newIstanse() {
		return new HDFS_Factory();
	}
	
	//inputPath is the localFile's Path outputPath is the hdfs's Path
	public void uplode(String inputPath, String outputPath) {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://master:9000");
		try {
			Path localPath = new Path(inputPath);
			Path hdfsPath = new Path(outputPath);
			FileSystem fs = FileSystem.newInstance(conf);
			fs.copyFromLocalFile(localPath, hdfsPath);
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	//inputPath is the hdfs's Path outputPath is the localFile's Path
	public void downlode(String inputPath, String outputPath) {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://master:9000");
		try {
			Path localPath = new Path(inputPath);
			Path hdfsPath = new Path(outputPath);
			FileSystem fs = FileSystem.newInstance(conf);
			fs.copyFromLocalFile(hdfsPath, localPath);
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
