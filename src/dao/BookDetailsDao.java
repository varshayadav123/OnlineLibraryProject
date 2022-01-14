package dao;

import model.Bookdetails;


public interface BookDetailsDao {
	
	public boolean Add_Book(Bookdetails user1);
	public String updateBook(Bookdetails b);

	public String deleteBook(String book_Id);
    
	public String PurchaseBook(String book_Id);
	public void getBooks();

	
	
}
