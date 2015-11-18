package com.terren.util;

abstract public class TimeProxy { 
	public  static  void  execute(){
		long bef = System.currentTimeMillis();
		long  befFMemory = Runtime.getRuntime().freeMemory();
		
		 testMethod();
		
		long aftFMemor = Runtime.getRuntime().freeMemory();
		long aft = System.currentTimeMillis();
		System.out.println("project execute beforeTime:"+bef);
		System.out.println("project execute afterTime:"+aft);
		System.out.println("project execute Time"+(aft-bef));
		System.out.println("***************************************************");
		System.out.println("project execute beforeFreeMemory:"+befFMemory);
		System.out.println("project execute afterFreeMemory:"+befFMemory);
		System.out.println("project execute useFreeMemory:"+(aftFMemor-befFMemory));
	}
	
	public static void  testMethod() {
		// TODO Auto-generated method stub
		
	}
}
