package com.terren;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.terren.util.jdbcUtil;



public class insertDatabase {
	public static void main(String[] args) {
		try {
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement psPreparedStatement =null;
			psPreparedStatement = connection.prepareStatement("");
			ResultSet rSet = psPreparedStatement.executeQuery();
			while(rSet.next()){
				System.out.println(rSet.getInt(1));
				System.out.println(rSet.getString(2));
				System.out.println(rSet.getString(3));
			}
			
			jdbcUtil.closeAll(psPreparedStatement, connection, rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
