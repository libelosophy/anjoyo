package com.jh.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JDBCProcedure {

	public JDBCProcedure() {
		
	}

	public static void main(String[] args) {
		try {
			addStudent("wan", "female");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @throws SQLException
	 */
	public static void addStudent(String name, String gender) throws SQLException {
		Connection cc = null;
		CallableStatement csmt = null;

		ResultSet rs = null;
		try {
			//获得连接
			cc = JDBCDemo.getConnect();
			// 创建调用存储过程的语句
			csmt = cc.prepareCall("{call insert_student(?,?)}"); 
		
			//调用语句的参数设定
			csmt.setString(1, name);
			csmt.setString(2, gender);
			csmt.execute();
			System.out.println("已经执行。");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if( csmt != null){
				csmt.close();
			}
			if(cc != null){
				cc.close();
			}
			
			
		}
	}

}
