package com.jh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {

	static final String USER_NAME = "root";
	static final String PASSWORD = "";
	static final String TABLE_NAME = "students";
	static final String CLOMUN_GENDER = "gender";
	static final String CLOMUN_NAME = "name";			
	static final String CLOMUN_ID = "_id" ;
	
	public JDBCDemo() {
	}

	public static void main(String[] args) {
		
		JDBCBasic();
		advanceedQuery("jiang","1");
		
	}

	
	public static Connection getConnect() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. get the sql Connection 得到SQL 连接 (java.sql.Connection)
		Connection cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=UTF-8",USER_NAME,PASSWORD );
		
		return cc;		
	}
	
	
	// Advanced Query
	public static void advanceedQuery(String name , String id) {
		String sql = "select * from students where name=? "; //& " + CLOMUN_NAME + " =? "  ;
		try {
			/*// 1. load Mysql driver 装载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. get the sql Connection 得到SQL 连接 (java.sql.Connection)
			Connection cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=UTF-8",USER_NAME,PASSWORD );
			*/
			
			Connection cc = getConnect();
			
			// 3. USE CONNECTION OBJECT TO CREATE Statement(java.sql.Statement) object 创建 语句
			PreparedStatement ps =  cc.prepareStatement(sql);
			ps.setString(1, "jiang");
			//ps.setString(1, id);
			System.out.println(sql);
			
			// 4. Use Statement to execute SQL statement  executeQuery return a ResultSet 执行查询
			ResultSet rs =  ps.executeQuery(); // 无需sql
	
			
			// 5. Operate on the result set 操作结果集
			// before  use getxxxx u should use rs.next()
			/*while(rs.next()){
				System.out.println( rs.getString(1) + " " +  rs.getString(2) + " " + rs.getString(3) );
			}*/
			
			// 6.回收数据库资源 关闭 ResultSet Statement Connection 等资源 
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(cc != null){
				cc.close();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	/**
	 * 
	 */
	public static void JDBCBasic() {
		String sql = "select * from " + TABLE_NAME ;//+ " where " + CLOMUN_ID + " = 1";
		try {
			// 1. load Mysql driver 装载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. get the sql Connection 得到SQL 连接 (java.sql.Connection)
			Connection cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=UTF-8",USER_NAME,PASSWORD );
			
			// 3. USE CONNECTION OBJECT TO CREATE Statement(java.sql.Statement) object 创建 语句
			PreparedStatement ps =  cc.prepareStatement(sql);
			
			// 4. Use Statement to execute SQL statement  executeQuery return a ResultSet 执行查询
			ResultSet rs =  ps.executeQuery(sql);
			
			// 5. Operate on the result set 操作结果集
			// before  use getxxxx u should use rs.next()
			while(rs.next()){
				System.out.println( rs.getString(1) + " " +  rs.getString(2) + " " + rs.getString(3) );
			}
			
			// 6.回收数据库资源 关闭 ResultSet Statement Connection 等资源 
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(cc != null){
				cc.close();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
