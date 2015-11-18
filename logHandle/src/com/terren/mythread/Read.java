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
import com.terren.util.jdbcUtil;


public class Read extends Thread {
	List<Content> list;
	
	@Override
	public void run() {
		Connection connection =null;
		PreparedStatement ps =null;
		PreparedStatement ps2 =null;
		ResultSet rSet = null;
		Map<String, String> errmap =new HashMap<String, String>();
		connection=jdbcUtil.getConnection();
		for(Content content : list){
			try {
				ps2 = connection.prepareStatement("insert into contentcontext (contentid,context) values (?,?)");
				String contentString =catchContext(content.getUrl(),errmap);
				ps2.setString(1, content.getContentid());
				ps2.setString(2, contentString);
				ps2.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		jdbcUtil.closeAll(ps2, connection, rSet);
	}
	
	public Read(List<Content> list) {
		this.list = list;
	}
	
	private static String catchContext(String url,Map<String, String> map){
		System.out.println(url);
		Document document=null;
		try {
			document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("获取文档错误错误");
			map.put("url","获取文档错误");
			return  "抓取错误" ;
			
		}
		Elements elements = document.getAllElements();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		List list = new ArrayList<String>();
		String string=null;
		String title =document.title();
		for(Element element : elements){
			string =element.ownText();
			if(!element.tagName().equals("a")){
				if(string.contains(".")||string.contains("。")){   //至少包含一个句号
					if(string.length()>7){
						list.add(element.ownText());
					}
				}
			}
		}
		String str =StringUtil.join(list, " ");
		System.out.println(title);
		System.out.println(title+str);
		System.out.println(document.text());
		return str;
	}
}
