
package daoimpl;

import java.sql.SQLException;

import dao.LoginDetailsDao;
import model.UserDetails;
import respository.LoginDetailsDaoRes;

public class LoginDetailsDaoImpl implements LoginDetailsDao{

	
	LoginDetailsDaoRes loginDetailsDaoRes=null;
	
	public LoginDetailsDaoImpl()
	{
		try {
			loginDetailsDaoRes=new LoginDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository"+e.getMessage());
		}
	}
	
	@Override
	public boolean signUp(UserDetails user) {
		// TODO Auto-generated method stub
		
		try {
			return loginDetailsDaoRes.signUp(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in sign up"+e.getMessage());
			return false;
		}
	}

	@Override
	public String signIn(UserDetails user) {
		// TODO Auto-generated method stub
		try {
			return loginDetailsDaoRes.signIn(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
	}

	@Override
	public boolean updateUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getBooks() {
		// TODO Auto-generated method stub
		try{
			loginDetailsDaoRes.getBooks();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
