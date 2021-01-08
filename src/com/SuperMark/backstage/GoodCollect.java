package com.SuperMark.backstage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable; 
 
class Good implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String GoodName;
	String GoodNum;
	
	public Good(String goodName, String goodNum) {
		super();
		GoodName = goodName;
		GoodNum = goodNum;
	}
}

public class GoodCollect{
	public void CollectInfor(String Userid,String Goodname,String Goodnum) {
		Good good=new Good(Goodname,Goodnum);
		try {
			File file=new File("C:\\Users\\Lenovo\\Desktop\\SuperMark\\"+Userid+"GoodCollect.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			ObjectOutputStream oop=new ObjectOutputStream(new FileOutputStream(file));
			oop.writeObject(good);
			oop.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
