package com.terren.test;

import java.util.ArrayList;
import java.util.List;

public class Tst {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <100; i++) {
			list.add(i);
		}
		List list2 = list.subList(1, 2);
		prn(list2);
		
	}
	
	public static  void prn(List<Integer> list) {
		for(int z : list){
			System.out.println(z);
		}
		
	}
}
