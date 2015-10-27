package com.terren;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LogHandler {
	public static void main(String[] args) {
		ReadFileLine("E:/FileWorkEcplise/.china.com.cn.full_webdig_201408121640.log");
	}
	
	//按行读取文件
	public static void ReadFileLine(String  filePath){
		File file = new File(filePath);
		try {
			BufferedReader  bReader = new BufferedReader(new FileReader(file));
			int line =0;
			String tempString ="";
			while((tempString = bReader.readLine())!=null && line <1){

				dealString(tempString);
				line++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//对每行String 进行处理
	public static void dealString(String str){
		StringTokenizer stringTokenizer = new StringTokenizer(str);
		int i=0;
		while(stringTokenizer.hasMoreTokens()){
			if( i==10){
				String string =stringTokenizer.nextToken("").trim();
				dealAgent(string);
				break;
			}else{
				System.out.println(stringTokenizer.nextToken().trim());
			}
			i++;
//			System.out.println(stringTokenizer.nextToken());
		}
	}
	
	//对userAgent处理
	public static void dealAgent(String str){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(str);
		StringTokenizer str2= new StringTokenizer(str,"\"");
		int z=0;
		while(str2.hasMoreTokens()){
			if (z>0) {
				System.out.println(str2.nextToken(" "));
			}
		}
	}
}
