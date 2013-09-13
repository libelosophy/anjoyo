package com.jh.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metadata {

	public Metadata() {
	}

	
	// 元信息 
	public static void main(String[] args) {
		try {

			Connection cc = JDBCDemo.getConnect();
			DatabaseMetaData md = cc.getMetaData();
			System.out.println(md.getDatabaseProductName()
					+ " " + md.getCatalogSeparator()
					+ " " + md.getDatabaseMajorVersion()
					+ " " + md.getCatalogTerm()
					+ " " + md.getDatabaseProductVersion()
					+ " " + md.getDriverMajorVersion()
					+ " " + md.getDriverMajorVersion()
					);
			ResultSet rs = md.getPrimaryKeys(null, null, "students");
			while(rs.next()){
				for(int i= 1; rs.getRow() !=0; i++){
					System.out.println(rs.getString(1) +" \n");
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
