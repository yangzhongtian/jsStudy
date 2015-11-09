package com.terren;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class printLog {
	public static void main(String[] args) {
		ReadFileLine("E:/FileWorkEcplise/.china.com.cn.full_webdig_201408121640.log");
	}
	
	//按行读取文件
	public static void ReadFileLine(String  filePath){
		long befMem =Runtime.getRuntime().freeMemory();
		System.out.println("程序开始前的剩余内存"+befMem);
		File file = new File(filePath);
		BufferedReader  bReader =null;
		try {
			bReader = new BufferedReader(new FileReader(file));
			int line =0;
			System.out.println();
			long bef = System.currentTimeMillis();
			
			String tempString="";
			List<NewsLog> list = new ArrayList<NewsLog>();
			while((tempString = bReader.readLine())!=null&&line<1){
				NewsLog newsLog1  = new  NewsLog();
				dealString(tempString,newsLog1);
				line++;
				list.add(newsLog1);
				
			}
			long aft  = System.currentTimeMillis();
			
			System.out.println("用时:"+(aft-bef)+"毫秒");
			
			System.out.println("总共条数:"+list.size()+"条");
			Map <String,String> map  = new HashMap<String, String>();
			Map <String,String> mapN  = new HashMap<String, String>();
			Map <String,String> mapO  = new HashMap<String, String>();
		/*****************新访和回访的Uv*************************/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long aftMem = Runtime.getRuntime().freeMemory();
		System.out.println("消耗后的剩余内存"+aftMem);
		System.out.println("消耗内存:"+(befMem-aftMem)/(1024*1024)+"m");
	}
	
	//对每行String 进行处理
	public static void dealString(String str,NewsLog lo){
		StringTokenizer stringTokenizer = new StringTokenizer(str);
		int i=0;
		System.out.println(str);
		while(stringTokenizer.hasMoreTokens()){
			if( i==10){
				String string =stringTokenizer.nextToken("").trim();
				dealAgent(string,lo);
				break;
			}else{
				System.out.println(stringTokenizer.nextToken());
			}
			i++;
		}
	}
	
	//对userAgent处理
	public static void dealAgent(String str, NewsLog lo){
	   str =str.substring(1,str.length()-1);

		StringTokenizer str2= new StringTokenizer(str);
		int z=0;
		while(str2.hasMoreTokens()){
			if(z<3){
				System.out.println(str2.nextToken("\""));
			}else if(z>2){
				System.out.println(str2.nextToken(" "));
			}
			z++;
		}
	}
}
