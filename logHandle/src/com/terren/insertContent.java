package com.terren;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.border.TitledBorder;

import com.terren.util.DealLogUitl;
import com.terren.util.JSEscape;
import com.terren.util.Lookup3Hash;
import com.terren.util.jdbcUtil;

public class insertContent {
	public static void main(String[] args) {
		Connection connection=jdbcUtil.getConnection();
		PreparedStatement psPreparedStatement =null;
		ResultSet rst =null;
		List<NewsLog> list = DealLogUitl.ReadFileLine("E:/FileWorkEcplise/.china.com.cn.full_webdig_201408121640.log");
		Map<Long ,NewsLog> map  = new HashMap<Long,NewsLog>();
		Lookup3Hash hasUtil = new Lookup3Hash();
		String  url =null;
		//获取稿件 ，去掉重复
		for (NewsLog newsLog : list) {
			url = newsLog.getUrl();
			long contentid= hasUtil.toID(url.split("[?]")[0]);
			NewsLog newsLog2  = map.get(contentid);
			if(newsLog2 ==null){
				newsLog.setUrl(url.split("[?]")[0]);
				map.put(contentid, newsLog);
			}	
		}
		Set<Entry<Long, NewsLog>> entries = map.entrySet();
		
		System.out.println(map.size());
		long bef =System.currentTimeMillis();
		System.out.println("bef:"+bef );
		try {
			psPreparedStatement = connection.prepareStatement("insert into content (contentid,url,title) values (?,?,?)");
			String title =null;
			for (Entry<Long, NewsLog> entry : entries) {
				NewsLog newsLog =entry.getValue();
				title = newsLog .getTitle();
				 title = JSEscape.js_unescape(title, "utf-8", "utf-8");
				long contentid = hasUtil.toID(newsLog.getUrl());
				System.out.println(contentid);
				psPreparedStatement.setLong(1, contentid);
				psPreparedStatement.setString(2,newsLog.getUrl());
				psPreparedStatement.setString(3, title);
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
