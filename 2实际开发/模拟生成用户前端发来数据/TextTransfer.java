import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TextTransfer {
	
	public static TextTransfer newInstanse(){
		return new TextTransfer();
	}
	
	
	public String read(File file){
		String result = readText(file);
		return result;
	}
	public boolean save(String path, String content){
		return writeText(path, content);
	}
	
	private String readText (File file){
		StringBuilder result = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s =null;
			while((s = br.readLine())!=null){
				result.append(s+System.lineSeparator());
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result.toString();
	}
	
	private boolean writeText (String path, String content){
		try{
			File textName = new File(path);
			String result = new String();
			if(!textName.exists()){
				boolean hasFile = textName.createNewFile();
				if(hasFile){
					result = content;
				}
			}else{
				result = readText(textName).trim()+content;
				
			}
			try(FileWriter writer = new FileWriter(textName);BufferedWriter out = new BufferedWriter(writer)){
				out.write(result);
				out.flush();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}
}
