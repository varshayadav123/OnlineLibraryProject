

package respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import model.Bookdetails;
import model.UserDetails;

public class BookDetailsDaoRes {
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	public BookDetailsDaoRes() throws SQLException
	{
	
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}
	
	public boolean Add_Book(Bookdetails user1) throws SQLException {
		// TODO Auto-generated method stub
	
	int r=statement.executeUpdate("insert into Bookdetails values('"+user1.getBook_Id()+"','"+user1.getBook_name()+"','"+user1.getAuthor_name()+"','"+user1.getPrice()+"')");
	if(r==1)
	{
	return true;
	}else
		return false;

	}
	public String updateBook(Bookdetails b) {
		// TODO Auto-generated method stub
		String sql = "UPDATE edubridge.Bookdetails SET bookname='"+b.getBook_name()+"',author='"+b.getAuthor_name()+"',price='"+b.getPrice()+"' WHERE bookid ='"+b.getBook_Id()+"';";
		try {
			int i = statement.executeUpdate(sql);
			if(i==1)
			{
				return "Successfully Updated !!!";
			}else
				return "Update Failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Update Failed";
		}
	}
	public String deleteBook(String book_Id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM edubridge.Bookdetails WHERE bookid='"+book_Id+"';";
		try {
			int i = statement.executeUpdate(sql);
			if(i==1)
			{
				return "Successfully Deleted !!!";
			}else
				return "Delete Failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Delete Failed";
		}
		}
	public String PurchaseBook(String book_Id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM edubridge.bookdetails WHERE Book_Id='"+book_Id+"';";
		try {
			ResultSet i = statement.executeQuery(sql);
			if(i.next())
			{
				return "Successfully Purchased !!!";
			}else
				return "Purchase Failed !!!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Purchase Failed";
		}
	
}}
