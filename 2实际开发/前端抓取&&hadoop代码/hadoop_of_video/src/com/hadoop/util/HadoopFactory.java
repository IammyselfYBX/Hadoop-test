package com.hadoop.util;

public class HadoopFactory {
	//creat a new Object
	public static HadoopFactory newInstanse(){
		return new HadoopFactory();
	}
	
	private Object execute(Object[] params){
		return false;
	}
	
	private	boolean exec(Object[] params){
		Object obj = execute(params);
		if(obj instanceof Boolean){
			Boolean b = (Boolean)obj;
			return b.booleanValue();
		}
		return false;
	}
}
