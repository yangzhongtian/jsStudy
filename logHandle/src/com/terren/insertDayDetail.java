package com.terren;

import java.awt.RenderingHints.Key;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.lang.model.element.VariableElement;

import com.terren.util.DealLogUitl;
import com.terren.util.Lookup3Hash;
import com.terren.util.jdbcUtil;

public class insertDayDetail {
	private static  Lookup3Hash hasUtil = new Lookup3Hash();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Connection connection=jdbcUtil.getConnection();
		PreparedStatement psPreparedStatement =null;
		ResultSet rst =null;
		List<NewsLog> list = DealLogUitl.ReadFileLine("E:/FileWorkEcplise/.china.com.cn.full_webdig_201408121640.log");
		Map<Long ,NewsLog> map  = new HashMap<Long,NewsLog>();
		//Lookup3Hash hasUtil = new Lookup3Hash();
		String  url =null;
		String key =null;
		// 按天划分 出map
		Map<String,List<NewsLog>> mapDay = new HashMap<String, List<NewsLog>>();
		String day=null ;
		List<NewsLog> daylist =null;
		for (NewsLog newsLog : list) {
			day=dealtime(newsLog.getTime());
			daylist= (List<NewsLog>) mapDay.get(day);
			if(daylist==null){
				list = new ArrayList<NewsLog>();
				list.add(newsLog);
				mapDay.put(day, list);
			}else {
				daylist.add(newsLog);
			}
		}
			System.out.println("daymapSize="+map.size());
		
			Set<Entry<String, List<NewsLog>>> entrys = mapDay.entrySet();
			for (Entry<String, List<NewsLog>> entry2 : entrys) {
				List<NewsLog> list2 =entry2.getValue();
				dealDay(list2);
				System.out.println("===========================================================");
			}
			
		
		
			long bef =System.currentTimeMillis();
		
			long aft  =System.currentTimeMillis();
			System.out.println("插入数据库用时+"+(aft-bef));
			jdbcUtil.closeAll(psPreparedStatement, connection,rst);
			System.out.println("database end");
		
	}
	
	
	protected static void dealDay(List<NewsLog> logs){
		String url =null;
		Map<Long ,NewsLog> map  = new HashMap<Long,NewsLog>();
		for (NewsLog newsLog : logs) {
			url = newsLog.getUrl();
			long contentid= hasUtil.toID(url.split("[?]")[0]);
			NewsLog newsLog2  = map.get(contentid);
			String cookie = newsLog.getCookie();
			if(newsLog2 ==null){
				newsLog.setPv(1);
				Set<String> set = new HashSet<String>();
				set.add(cookie);
				newsLog.setSet(set);
				map.put(contentid, newsLog);
			}else{
				newsLog2.setPv(newsLog2.getPv()+1);
				newsLog2.getSet().add(cookie);
			}		
		}
		insert(map);
	}
	
	protected static void insert(Map<Long, NewsLog> map){
		Connection connection=jdbcUtil.getConnection();
		PreparedStatement psPreparedStatement =null;
		ResultSet rst =null;
		Set<Entry<Long, NewsLog>> entries = map.entrySet();
		try {
			psPreparedStatement = connection.prepareStatement("insert into content_day (contentid,day,pv,uv) values (?,?,?,?)");
			for (Entry<Long, NewsLog> entry : entries) {
				NewsLog newsLog =entry.getValue();
				long contentid = hasUtil.toID(newsLog.getUrl());
				psPreparedStatement.setLong(1, contentid);
				psPreparedStatement.setString(2,dealtime(newsLog.getTime()));
				psPreparedStatement.setLong(3, newsLog.getPv());
				psPreparedStatement.setLong(4,newsLog.getSet().size());
				System.out.println(psPreparedStatement);
				boolean flag=	psPreparedStatement.execute();
			}
			jdbcUtil.closeAll(psPreparedStatement, connection,rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String dealtime(String string){
		String string2 =null;
		Date date = new Date(Long.parseLong(string)*1000);
		string2 =date.toString();
		return string2;
	}
	
}
