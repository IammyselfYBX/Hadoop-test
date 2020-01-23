package hadoop.video.util;

import java.util.Date;

import hadoop.video.service.impl.Video;

public class GetLine {
	public static GetLine newInstase(){
		return new GetLine();
	}
	public void getLine(Video video){
		String s = new String();
		s=video.getUrl()+"-"+video.getId()+"-"+video.getLength()+"-"+(int)Math.round(video.getStartTime())+"-"+(int)Math.round(video.getEndTime())+"-"+video.getSpeed()+"+";
		String path = new String();
		path = "C:/Users/84492/Desktop/test/test"+video.getId();
		TextTransfer.newInstanse().save(path, s);
	}
}
