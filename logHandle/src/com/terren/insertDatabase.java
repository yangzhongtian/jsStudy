package com.terren;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.lang.model.element.NestingKind;

import com.terren.util.DealLogUitl;
import com.terren.util.Lookup3Hash;
import com.terren.util.jdbcUtil;



public class insertDatabase {
	public static void main(String[] args) {
		
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement psPreparedStatement =null;
			ResultSet rst =null;
			List<NewsLog> list = DealLogUitl.ReadFileLine("E:/FileWorkEcplise/.china.com.cn.full_webdig_201408121640.log");
			Map<Long ,NewsLog> map  = new HashMap<Long,NewsLog>();
			Lookup3Hash hasUtil = new Lookup3Hash();
			String  url =null;
			for (NewsLog newsLog : list) {
				url = newsLog.getUrl();
				long contentid= hasUtil.toID(url.split("[?]")[0]);
				NewsLog newsLog2  = map.get(contentid);
				if(newsLog2 ==null){
					newsLog.setPv(1);
					map.put(contentid, newsLog);
					
				}else{
					newsLog2.setPv(newsLog2.getPv()+1);
				}		
			}
			Set<Entry<Long, NewsLog>> entries = map.entrySet();
			System.out.println(map.size());
			long bef =System.currentTimeMillis();
			System.out.println("bef:"+bef );
			try {
				psPreparedStatement = connection.prepareStatement("insert into mylogs (contentid,url,title,pv) values (?,?,?,?)");
				for (Entry<Long, NewsLog> entry : entries) {
					NewsLog newsLog =entry.getValue();
					long contentid = hasUtil.toID(newsLog.getUrl());
					psPreparedStatement.setLong(1, contentid);
					psPreparedStatement.setString(2,newsLog.getUrl().split("[?]")[0].length()>100?"toolong":newsLog.getUrl().split("[?]")[0]);
					psPreparedStatement.setString(3, newsLog.getTitle()!=null&&newsLog.getTitle().length()>30?newsLog.getTitle().substring(0, 30):newsLog.getTitle());
					psPreparedStatement.setLong(4, newsLog.getPv());
					psPreparedStatement.execute();
				}
				long aft  =System.currentTimeMillis();
				System.out.println("插入数据库用时+"+(aft-bef));
				jdbcUtil.closeAll(psPreparedStatement, connection,rst);
				System.out.println("database end");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
