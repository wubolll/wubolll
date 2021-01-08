 package com.SuperMark.dao;

import java.sql.*;

public class Database{
	public static Connection conn;
	public Connection database() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=电子商城";// test为你的数据库名
		String userName="sa";//你的数据库用户名
		String userPwd="123456";//你的密码
		try {
			Class.forName(driverName);
			System.out.println("加载驱动成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		try {
			conn = DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("连接数据库成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}
		return conn;
	}
	public static void main(String[]args) {
		new Database().database();
	}
}


