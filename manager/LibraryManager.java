package manager;
import java.util.*;
import model.*;

public class LibraryManager {
   private ArrayList<book> books=new ArrayList<>();
   private ArrayList<user> users=new ArrayList<>();
   public void addBook(book book){
       books.add(book);
   }
   public void adduser(user user){
       users.add(user);
   }
   public book getBookbyId(int id){
       for(book b:books){
           if(b.getId()==id){
               return b;
           }
       }
       return null;
   }
    public user getUserbyId(int id){
        for(user u:users){
            if(u.getUserid()==id){
                return u;
            }
        }
        return null;
    }
    public void viewAllBooks(){
       if(books.isEmpty()){
           System.out.println("No book in library");
       }
       else{
           for(book b:books){
               System.out.println(b.getTitle());
           }
       }
    }
    public ArrayList<user> getAllusers(){
       return users;
    }
    public void searchBookByTitle(String k){
       String Keyword =k.toLowerCase();
       boolean found=false;
       for(book b:books){
           String bTitle=b.getTitle().toLowerCase();
           if(bTitle.contains(Keyword)){
               System.out.println(b);
               found=true;
           }
       }
       if(found==false){
           System.out.println("No matching book found");
       }
    }
    public void borrowBook(int id,int userId ){
       book b=getBookbyId(id);
       user u=getUserbyId(userId);
       if(u!=null && b!=null && b.getCopies()>0){
           b.decreasecopies();
           u.borrowBook(id);
           System.out.println("book borrowed successfully");
       }
       else{
           System.out.println("Book not found or user not found");
       }

    }
    public void returnBook(int id,int userId){
       book b=getBookbyId(id);
       user u=getUserbyId(userId);
       if(b!=null && u!=null){
           b.increasecopies();
           u.returnBook(id);
           System.out.println("book returned successfully");
        }
       else{
            System.out.println("unable to return book");
        }
    }
  
}
