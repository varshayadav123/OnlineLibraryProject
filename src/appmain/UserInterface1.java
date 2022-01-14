package appmain;
import java.util.Scanner;

import dao.LoginDetailsDao;
import daoimpl.LoginDetailsDaoImpl;
import model.UserDetails;
import respository.BookDetailsDaoRes;
import dao.BookDetailsDao;
import daoimpl.BookDetailsDaoImpl;
import model.Bookdetails;



public class UserInterface1 {
public static void main(String[] args) {
// TODO Auto-generated method stub

                                    System.out.println("*Welcome to Library Management**");


                                     System.out.println("1: Sign up");
                                     System.out.println("2: Sign In");
                                     System.out.println("3: Exit");
                                     System.out.println("*******");
char ch=' ';
LoginDetailsDao LoginDao=new LoginDetailsDaoImpl();
String username,firstname,lastname,password, location, mobileno,role;
//char ch1=' ';
BookDetailsDao bookDao=new BookDetailsDaoImpl();
String Book_Id;
String Book_name,Author_name,Price;
do {
System.out.println("What you do wish to check from the above list");


                                   Scanner sn = new Scanner(System.in);
                                   int option=sn.nextInt();

                                   switch(option)
                                   {

case 1:
	                 System.out.println("enter the details to signup");

                     System.out.println("Enter username");
                     username=sn.next();

                    System.out.println("Enter firstname");
                    firstname=sn.next();

                     System.out.println("Enter lastname");
                     lastname=sn.next();

                     System.out.println("Enter password");
                     password=sn.next();

                      System.out.println("Enter location");
                      location=sn.next();

                      System.out.println("Enter mobileno");
                      mobileno=sn.next();

                      System.out.println("Enter role");
                      role=sn.next();

                      UserDetails user=new UserDetails();
                      user.setUsername(username);
                      user.setFirstName(firstname);
                      user.setLastName(lastname);
                      user.setPassword(password);
                      user.setLocation(location);
                      user.setMobileno(mobileno);
                      user.setRole(role);
                      LoginDao.signUp(user);

/*create table userdetails(
firstname varchar(20) not null,
lastname varchar(20),
location varchar(20),
username varchar(20) primary key,
password varchar(20) not null,
mobileno varchar(10) not null,
role varchar(20) not null
)
*/

                    System.out.println("***Successfully signIn***");
                    break;
case 2:
                System.out.println("enter the username and password to login");
                String usern=sn.next();
                String pass=sn.next();
                UserDetails details=new UserDetails();
                details.setUsername(usern);
                details.setPassword(pass);
                String res = LoginDao.signIn(details);
              if((("Login failed").equals(res)))
             System.out.println("***login failed****");
                 else{
             System.out.println("login Successful");
            if ("customer".equals(res)) {
            System.out.println("****Welcome CUSTOMER " + usern + "*****");
            System.out.println("1:List of Books");
            System.out.println("2:Purchase");
            System.out.println("*********************");
           int Customeropt=sn.nextInt();
           switch (Customeropt){
case 1:
          System.out.println("List of Books");
          LoginDao.getBooks();
          break;
case 2:
          System.out.println("Purchase");
          System.out.println("Enter your book_ID");
          Book_Id = sn.next();

          System.out.println(bookDao.PurchaseBook(Book_Id));
          break;
         }
         } else if ("admin".equals(res)) {
         System.out.println("****Welcome ADMIN " + usern + "*****");

         System.out.println("1: Get books");
         System.out.println("2: Add-Book");
         System.out.println("3: Update book");
         System.out.println("4: Delete book");
         System.out.println("5: Exit");
         System.out.println("*********************");
/* char ch1=' ';
BookDetailsDao bookDao=new BookDetailsDaoImpl();
String Book_Id,Book_name,Author_name,Price;*/
                do {
                System.out.println("What you do wish to check from the above list");
                Scanner sc= new Scanner(System.in);
                int Adminopt=sn.nextInt();

                switch(Adminopt){
            case 1:
                         System.out.println("List of Books");
                          LoginDao.getBooks();
                          break;
            case 2:
                          System.out.println("enter the details to Add_Book");

                          System.out.println("Enter Book_Id");
                          Book_Id=sn.next();

                          System.out.println("Enter Book_name");
                          Book_name=sn.next();

                          System.out.println("Enter Author_name");
                          Author_name=sn.next();

                          System.out.println("Enter Price");
                           Price=sn.next();
                          Bookdetails user1=new Bookdetails();
                           user1.setBook_Id(Book_Id);
                           user1.setBook_name(Book_name);
                           user1.setAuthor_name(Author_name);
                           user1.setPrice(Price);
                           bookDao.Add_Book(user1);

/*create table Bookdetails(
Book_Id varchar(20) primary key,
Book-name varchar(20) not null,
Author_name varchar(20),
Price varchar(20)
);
*/
                             System.out.println("Successfully Add_Book");

                             System.out.println("Do you wish to check other options");
                             ch=sn.next().charAt(0);
                             break;

                              case 3:
                             System.out.println("enter the Bookdetails to Update");

                             System.out.println("Enter your bookID");
                             Book_Id = sn.next();
                             System.out.println("Enter your bookName");
                             Book_name = sn.next();
                             System.out.println("Enter your Author");
                             Author_name = sn.next();
                             System.out.println("Enter your Price");
                             Price = sn.next();

                           Bookdetails book1 = new Bookdetails();
                           
                             book1.setBook_Id(Book_Id);
                             book1.setBook_name(Book_name);
                             book1.setAuthor_name(Author_name);
                             book1.setPrice(Price);
                        System.out.println(bookDao.updateBook(book1));
                        break;

                   case 4:
                 System.out.println("enter the Bookdetails to Delete");

                 System.out.println("Enter your bookID");
                  Book_Id = sn.next();

                System.out.println(bookDao.deleteBook(Book_Id));
                break;
               case 5:
                   System.exit(0);

                 default:
                    }  
                   System.out.println("enter a valid option");
                   System.out.println("Do you wish to check other options");
                   ch=sn.next().charAt(0);

                 } while(ch=='y'||ch=='Y');


                   }
                   }
                /* else{
                   System.out.println("login failed");
                    }*/
                  case 3:
                System.exit(0);
                 default:



}
System.out.println("enter the valid option");

System.out.println("Do you wish to check other options");
ch=sn.next().charAt(0);
}while(ch=='y'||ch=='Y');
}
}
