package com.terren.test;

import java.sql.Time;

import com.terren.util.TimeProxy;



public class testString extends TimeProxy {
	public static void main(String[] args) {
		testString.execute();
	}
	
	public static void testMethod(){
		for(int i=0;i<220000;i++){
			i=i*i/3;
			System.out.println(i);
		}
	}
}
