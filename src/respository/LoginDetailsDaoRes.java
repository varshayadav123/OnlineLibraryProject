
package respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import model.UserDetails;

public class LoginDetailsDaoRes {
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	public LoginDetailsDaoRes() throws SQLException
	{
	
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}
	
	public boolean signUp(UserDetails user) throws SQLException {
		// TODO Auto-generated method stub
	
	int r=statement.executeUpdate("insert into userdetails values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getLocation()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getMobileno()+"','"+user.getRole()+"')");
	if(r==1)
	{
	return true;
	}else
		return false;

	}
	public String signIn(UserDetails user) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String tuser=user.getUsername();
		String pass=user.getPassword();
		resultSet=statement.executeQuery("select *from userdetails where username='"+tuser+"' and password='"+pass+"'");
		if(resultSet.next())
		{
		return resultSet.getString("role");
		}else
			return "Login Failed";
	}
	public void getBooks() throws SQLException{
		resultSet=statement.executeQuery("select * from Userdetails.book");
		int i=1;
		while(resultSet.next()){
			System.out.println("Book "+i+":");
			System.out.println(resultSet.getString("bookName"));
			System.out.println(resultSet.getString("author"));
			System.out.println(resultSet.getString("price"));
			i++;
		}
	}
	public void selectBooks() throws SQLException{
		resultSet=statement.executeQuery("select bookID from book");
		int i=1;
		while(resultSet.next()){
			System.out.println("Book "+i+":");
			System.out.println(resultSet.getString("bookName"));
			System.out.println(resultSet.getString("author"));
			System.out.println(resultSet.getString("price"));
			i++;
		}
	}
	
 }
	
	
