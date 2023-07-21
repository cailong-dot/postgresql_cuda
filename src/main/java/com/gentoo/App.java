package com.gentoo;

import java.sql.Connection;
import java.sql.DriverManager;

public class App {
	 @SuppressWarnings("unused")
	public static void main(String args[]) {
	      Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/gentoo",
	            "gentoo", "Glare+day!Dog");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	   }
}