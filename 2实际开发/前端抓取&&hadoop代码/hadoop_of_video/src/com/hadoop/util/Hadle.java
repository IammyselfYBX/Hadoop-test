package com.hadoop.util;

import java.util.ArrayList;
import com.hadoop.global.IHandle;
import com.hadoop.service.impl.Video;
import com.hadoop.service.impl.VideoBehavior;

public class Hadle implements IHandle{
	public boolean handle(Video video, VideoBehavior behavior) {
		// TODO Auto-generated method stub
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(video.getUrl());
		al.add(video.getId());
		al.add(video.getLength());
		al.add(behavior.getStartTime());
		al.add(behavior.getEndTime());
		al.add(behavior.getSpeed());
		return true; 
	}
}
