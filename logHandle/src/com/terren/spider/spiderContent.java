package com.terren.spider;

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
		//	ps =connection.prepareStatement("select tb1.contentid ,title,url ,context from content tb1 join   contentcontext tb2 on tb1.contentid=tb2.contentid  where 1=1 and tb2.context = ''");
			ps =connection.prepareStatement("select tb1.contentid ,title,url ,context from content tb1 join   contentcontext tb2 on tb1.contentid=tb2.contentid  where 1=1 and tb2.context like '%div%';");
			rSet=ps.executeQuery();
			Content content = new Content();
			while(rSet.next()){
				content.setContentid(rSet.getString(1));
				content.setTitel(rSet.getString(2));
				content.setUrl(rSet.getString(2));
				resultContents.add(content);
				System.out.println(rSet.getString(2));
				String  contentId = rSet.getString(1);
				System.out.println(contentId);
				System.out.println(rSet.getString(3));
				ps2 = connection.prepareStatement("replace into contentcontext (contentid,context) values (?,?)");
				String contentString =catchContext(rSet.getString(3),errmap);
				ps2.setString(1, contentId);
				ps2.setString(2, contentString);
				ps2.execute();
				;
				System.out.println("*****************************************************************************************************************");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		jdbcUtil.closeAll(ps, connection, rSet);
		System.out.println(errmap.size());
		
		
		
	}
	
	private static String catchContext(String url,Map<String, String> map){
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
				if(string.contains(".")||string.contains("。")||string.contains("?")||string.contains("!")){   //至少包含一个句号
					if(string.length()>7){
						list.add(element.ownText());
					}
				}
			}
		}
		String str =title+StringUtil.join(list, " ");
		System.out.println(title);
		
		
		System.out.println(str);
		System.out.println(document.text());
		return str;
	}
} 
