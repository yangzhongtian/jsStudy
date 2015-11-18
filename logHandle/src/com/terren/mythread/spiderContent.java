package com.terren.mythread;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.terren.model.Content;
import com.terren.mythread.Read;
import com.terren.util.jdbcUtil;

public class spiderContent {
	public static void main(String[] args) throws IOException {
		Connection connection =null;
		PreparedStatement ps =null;
		PreparedStatement ps2 =null;
		ResultSet rSet= null;
		Map<String, String> errmap =new HashMap<String, String>();
		
		List<Content> resultContents = new ArrayList<Content>();
		try {
			connection=jdbcUtil.getConnection();
			ps =connection.prepareStatement("select * from content where 1=1");
			rSet=ps.executeQuery();
			Content content = new Content();
			while(rSet.next()){
				content.setContentid(rSet.getString(1));
				content.setTitel(rSet.getString(2));
				content.setUrl(rSet.getString(3));
				resultContents.add(content);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		jdbcUtil.closeAll(ps, connection, rSet);
		System.out.println(errmap.size());
		
			int length = resultContents.size();
			int left = length%5;
			int perLength = (length-left)/5;
			
		
			
			Read read1 = new Read(resultContents);
			Read read2 = new Read(resultContents);
			Read read3 = new Read(resultContents);
			Read read4 = new Read(resultContents);
			Read read5 = new Read(resultContents);
			
			read1.start();
			read2.start();
			read3.start();
			read4.start();
			read5.start();
	}
	
	
} 
