package com.terren;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.terren.util.jdbcUtil;



public class insertDatabase {
	public static void main(String[] args) {
		Connection connection=jdbcUtil.getConnection();
		PreparedStatement psPreparedStatement =null;
		psPreparedStatement = connection.prepareStatement("select * from ")
	}
}