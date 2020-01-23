package com.hadoop.global;

import com.hadoop.service.impl.Video;
import com.hadoop.service.impl.VideoBehavior;

public interface IHandle {
	 
	/*
     * 将输入转成一行数据
     */
	boolean handle(Video video, VideoBehavior behavior);
	
}
