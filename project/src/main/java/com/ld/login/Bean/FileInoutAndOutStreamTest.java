package com.ld.login.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * fileInputStream
 * fileOutputStream
 * @author lvdong
 *
 */
public class FileInoutAndOutStreamTest {
	/*public static void main(String[] args) throws Exception {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("C:\\poi\\file2.obj")));
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("C:\\poi\\objectFile.obj")));
		oos.writeObject(new ObjectStream());
		oos.flush();
		ObjectStream ob=(ObjectStream) ois.readObject();
		System.out.println(ob.date);
	}*/
	/**
	 * 读取pdf有问题 txt可以正常读取
	 * @param args
	 */
	/*public static void main(String[] args) {
		try {
			File file1=new File("C:\\poi\\file2.pdf");
			File file2=new File("C:\\poi\\testFile.pdf");
			if(!file2.exists()) {
				file2.createNewFile();
			}
			FileReader fd=new FileReader(file1);
			FileWriter fw=new FileWriter(file2);
			StringBuffer bf=new StringBuffer();
			char[] charArray=new char[256];
			int len=-1;
			while(fd.read(charArray)!=-1) {
				fw.write(charArray,0,charArray.length);
			}
			fw.flush();
			fw.close();
			fd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*public static void main(String[] args) {
		File file1=new File("C:\\poi\\HelloWorld.pdf");
//		File file2=new File("C:\\poi\\file2.pdf");
		FileInputStream fis;
		FileOutputStream fos;
		try {
			//InputStream ips=new FileInputStream("C:\\poi\\HelloWorld.pdf");
			fis=new FileInputStream("C:\\poi\\a.txt");
			fos=new FileOutputStream("C:\\poi\\file2.txt");
			byte[] by=new byte[4];
			int len=-1;
			while((len=fis.read(by))!= -1) {
				fos.write(by, 0, len);
			}
			fos.flush();
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
	}*/
}
