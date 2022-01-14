
package daoimpl;

import java.sql.SQLException;

import dao.BookDetailsDao;
import dao.LoginDetailsDao;
import model.Bookdetails;
import model.UserDetails;
import respository.BookDetailsDaoRes;

public  class BookDetailsDaoImpl implements BookDetailsDao{

	BookDetailsDaoRes BookDetailsDaoRes=null;
	
	
	public BookDetailsDaoImpl()
	{
		try {
			BookDetailsDaoRes=new BookDetailsDaoRes();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository"+e1.getMessage());
		}
	}
	
	@Override
	public boolean Add_Book(Bookdetails user1) {
		// TODO Auto-generated method stub
		
		try {
			return BookDetailsDaoRes.Add_Book(user1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("problem in Add_Book"+e1.getMessage());
			return false;
		}
	}

	@Override
	public String updateBook(Bookdetails b) {
		// TODO Auto-generated method stub
		return  BookDetailsDaoRes.updateBook(b);
	}



	@Override
	public String deleteBook(String book_Id) {
		// TODO Auto-generated method stub
		return  BookDetailsDaoRes.deleteBook( book_Id);
	}

	@Override
	public String PurchaseBook(String book_Id) {
		// TODO Auto-generated method stub
		return BookDetailsDaoRes.PurchaseBook(book_Id) ;
	}

	@Override
	public void getBooks() {
		// TODO Auto-generated method stub
		
	}

}
