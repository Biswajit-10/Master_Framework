package com.crm.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Biswajit
 *
 */
public class DataBaseUtilities {
	public Connection connection;
	public Statement statement;
	public ResultSet resultSet;
	
	public void connectToDB() throws SQLException {
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public void printTable(String query,int columnNumber1,int columnNumber2) throws SQLException {
		try{
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println(resultSet.getObject(columnNumber1)+"\t"+resultSet.getObject(columnNumber2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
	}
	
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
