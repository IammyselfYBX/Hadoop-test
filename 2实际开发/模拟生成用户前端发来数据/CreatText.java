import java.util.ArrayList;

public class CreatText {

	public static CreatText newInstanse() {
		return new CreatText();
	}

	public static int i = 0;
	public boolean creatText(String path, int dataNumber){
		String content = new String();
		for(String s : randomData(dataNumber)){
			content+=s;
			i++;
			System.out.println(i);
		}
		return TextTransfer.newInstanse().save(path, content);
	}
	
	// al:url;id;length;startTime;endTime;speed
	private ArrayList<String> randomData(int dataNumber) {
		ArrayList<String> resultSet = new ArrayList<String>();
		for(int i=0;i<dataNumber;i++){
			long length = randomLength();
			long[] useTime = randomUseTime(length);
			if(i==0){
				resultSet.add("+");
			}
			if(i<dataNumber){
				resultSet.add(randomUrl()+"-"+i+"-"+length+"-"+useTime[0]+"-"+useTime[1]+"-"+randomSpeed()+"+");
			}else{
				resultSet.add(randomUrl()+"-"+i+"-"+length+"-"+useTime[0]+"-"+useTime[1]+"-"+randomSpeed());
			}
		}
		return resultSet;
	}

	private String randomUrl() {
		String url = null;
		String mainurl = "www.hadoopvideo.com/v/";
		String plus = null;
		
		long vid = (long) (Math.random() * 99);
		plus = String.valueOf(vid);
		String supplement = new String();
		for (int j = 0; j < (2 - plus.length()); j++) {
			supplement += "0";
		}
		url = mainurl + supplement + plus;
		return url;
	}

	private long randomLength() {
		// 1s=24frames
		// limit frames from 1440 to 86400
		long frames = (long) (Math.random() * 3540 )+ 60;
		return frames;
	}
	private long[] randomUseTime(long length){
		
		long startTime = (long)(Math.random()*length);
		long endTime =(long)(Math.random()*(length-startTime))+startTime;
		long[] useTime = new long[]{startTime,endTime};
		return useTime;
	}
	private double randomSpeed(){
		double[] speed = {0.5,0.75,1,1.25,1.5,2,2.5};
		int i = (int)(Math.random()*speed.length);
		return speed[i];
	}
}
