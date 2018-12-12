package com.ld.filter.until;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.StringUtils;

import com.csvreader.CsvReader;

public class Test extends Thread{
	private long time;
	public static void main(String[] args) {
		resolveZip("C:\\Users\\lvdong\\Desktop\\data.zip");
	}
	private static void resolveZip(String locationPath) {
		List<Map<String,String>> resultList=new ArrayList();
		ZipFile zf =null;
		InputStream in=null;
		ZipInputStream zin=null;
		try {
			zf= new ZipFile(locationPath); 
			in=new BufferedInputStream(new FileInputStream(locationPath));
			zin=new ZipInputStream(in);
			ZipEntry ze;
			while((ze=zin.getNextEntry())!=null) {
				if(!ze.isDirectory()) {
					System.err.println("file -"+ze.getName()+" :"+ze.getSize()+"bytes");
					long size=ze.getSize();
					if(true) {
						BufferedReader br=new BufferedReader(new InputStreamReader(zf.getInputStream(ze),"UTF-8"));
						String str="";
						int i=0;
						while((str=br.readLine())!=null) {
							i++;
							if(i==1) {
								continue;
							}
							String[] strs=str.split(",");
							Map map=new HashMap();
							if(strs.length>3) {
								for(int j=0;j<strs.length;j++) {
									if(j==0) {
										map.put("code", strs[j]);
										System.out.println("code:"+strs[j]);
									}else if(j==3){
										map.put("checkFlag", strs[strs.length-1]);
										resultList.add(map);
										System.out.println("code:"+strs[strs.length-1]);
									}
								}
							}
						}
//						CsvReader cr=new CsvReader(zf.getInputStream(ze), Charset.forName("UTF-8"));
//						cr.readHeaders();
//						while(cr.readRecord()){
//							System.out.println(cr.getValues()[0]+","+cr.getValues()[1]+","+cr.getValues()[2]+","+cr.getValues()[3]);
//							System.out.println("length:"+StringUtils.isBlank(cr.getValues()[3]));
//							break;
//						}
//						br.close();
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
				zin.close();
				zf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
//		
//		Test test=new Test(2000);
//		test.execute();
//		System.out.println("此线程已启动");	
//		Timer timer=new Timer();
//		timer.scheduleAtFixedRate(new MyTask(), new Date(), 1000);
		
	}
	/**
	 * 初始化时间
	 * @param time
	 */
	public Test(long time) {
		this.time=time;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(time);
				send();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void execute() {
		this.start();
	}
	private void send() {
		System.out.println("任务执行："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
}
class MyTask extends TimerTask{
	@Override
	public void run() {
		System.out.println("task run");
	}
}
