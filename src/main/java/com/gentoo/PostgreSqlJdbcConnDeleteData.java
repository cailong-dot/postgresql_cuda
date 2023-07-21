package com.gentoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSqlJdbcConnDeleteData {
	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
			   .getConnection("jdbc:postgresql://localhost:5432/gentoo",
			   "gentoo", "Glare+day!Dog");
			c.setAutoCommit(false);
			System.out.println("连接数据库成功！");
			stmt = c.createStatement();
			String sql = "UPDATE COMPANY set SALARY = 250 where ID=1 ";
			stmt.executeUpdate(sql);
			c.commit();
			ResultSet rs = stmt.executeQuery("select * from company order by id");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println(id + "," + name + "," + age + "," + address.trim() + "," + salary);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("删除数据成功！");
	}
}