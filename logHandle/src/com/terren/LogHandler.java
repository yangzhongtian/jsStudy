package com.terren;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 目标  1，查询当日的uv pv 
 * 	2 ，查询 新访回访 uv pv
 * @author Administrator
 *
 */
public class LogHandler {
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
			while((tempString = bReader.readLine())!=null){
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
			int newR=0;
			int oldR=0;
			int otherTyp=0;
			for(int h =0;h<list.size();h++){
				NewsLog log = list.get(h);
				if((log.getVisitType()).equals("0")){
					mapN.put(log.getCookie(), "");
					newR++;
				}else if((log.getVisitType()).equals("1")){
					mapO.put(log.getCookie(), "");
					oldR++;
				}else if((log.getVisitType()).equals("-")) {
					otherTyp++;
				}
				
				map.put(list.get(h).getCookie(), "s");
			}
			System.out.println("uv数"+map.size()+"  pv数"+list.size());
			System.out.println("新访: uv数="+mapN.size()+" ,pv数="+newR);
			System.out.println("回访: uv数="+mapO.size()+" ,pv数="+oldR);
			System.out.println("-: "+otherTyp);
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
		
		while(stringTokenizer.hasMoreTokens()){
			if( i==10){
				String string =stringTokenizer.nextToken("").trim();
				dealAgent(string,lo);
				break;
			}else{
				switch (i) {
				case 0:
					lo.setTime(stringTokenizer.nextToken());
					break;
				case 1:
					lo.setIp(stringTokenizer.nextToken());
					break;
				case 2:
					lo.setCookie(stringTokenizer.nextToken());
					break;
				case 3:
					lo.setVisitType(stringTokenizer.nextToken());
					break;
				case 4:
					lo.setUrl(stringTokenizer.nextToken());
					break;
				case 5:
					lo.setRefer(stringTokenizer.nextToken());
					break;
				case 6:
					lo.setLength(stringTokenizer.nextToken());
					break;
				case 7:
					lo.setTitle(stringTokenizer.nextToken());
					break;
				case 8:
					lo.setCodeing(stringTokenizer.nextToken());
					break;
				case 9:
					lo.setCollected(stringTokenizer.nextToken());
					break;
				
				default:
					break;
				}
			}
			i++;
//			System.out.println(stringTokenizer.nextToken());
		
		}
	}
	
	//对userAgent处理
	public static void dealAgent(String str, NewsLog lo){
	   str =str.substring(1,str.length()-1);
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
//		System.out.println(str);
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		StringTokenizer str2= new StringTokenizer(str);
		int z=0;
		while(str2.hasMoreTokens()){
			
			switch (z) {
			case 0:
				lo.setvTime(str2.nextToken("\""));
				break;
			case 1:
				lo.setUa(str2.nextToken("\""));
				break;
			case 2:
				str2.nextToken("\"");
				break;
			default:
				str2.nextToken(" ");
				break;
			}
			z++;
		}
	}
}  
