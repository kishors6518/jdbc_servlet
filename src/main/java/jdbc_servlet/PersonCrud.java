package jdbc_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCrud {
	
	public Connection getConnection()throws Exception
	{
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/servletdb";
		String user="root";
		String pass="root";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url, user, pass);
		return connection;
	}
	public int singUp(Person person)throws Exception
	{
		Connection connection=getConnection();
		String sql="INSERT INTO PERSON(ID,NAME,PHONE,ADDRESS,EMAIL,PASSWORD) VALUES(?,?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getAddress());
		preparedStatement.setString(5,person.getEmail());
		preparedStatement.setString(6, person.getPassword());
		
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	} 
	public String getPassword(String email)throws Exception
	{
		Connection  connection=getConnection();
		String pass="SELECT PASSWORD FROM PERSON WHERE EMAIL=?";
		PreparedStatement preparedStatement=connection.prepareStatement(pass);
		preparedStatement.setString(1, email);
		ResultSet set=preparedStatement.executeQuery();
		String password=null;
		while (set.next()) {
			password=set.getString("password");
		}
		connection.close();
		return password;		
	}
}
