package com.terren.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;

public class jdbcUtil {
	private static String jdbcDriver ="";
	private static String jdbcUrl ="";
	private static String user ="";
	private static String password ="";
	static Connection connection  =null;
	
	static{
		try {
			InputStream inputStream =null;
			inputStream =jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			jdbcDriver =properties.getProperty("jdbcDriver");
			jdbcUrl =properties.getProperty("jdbcUrl");
			user =properties.getProperty("jdbcUser");
			password =properties.getProperty("jdbcPasswd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取链接
	public static Connection getConnection(){
		try {
			Class.forName(jdbcDriver);
			connection= DriverManager.getConnection(jdbcUrl,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//关闭链接
	public static void closeAll(PreparedStatement preparedStatement ,Connection connection, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//关闭链接
		public static void closeAll(Statement statement ,Connection connection, ResultSet rs){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement !=null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
