package crackingTheCodeInterviewExs_OOD;

import java.awt.print.Book;
import java.util.HashMap;

public class IQ_7_5_OnlineBookReader {

	public class OnlineReaderSystem {
		private Library library;
		private UserManager userManager;
		private Display display;
		
		private Book activeBook;
		private User activeUser;
		
		public OnlineReaderSystem() {
			userManager = new UserManager();
			library = new Library();
			display = new Display();
		}
		
		
		
		
	}
	
	publHashMap<K, V>s Library {
		private HashMap<Integer, Book> books;
		
		public Book addBook(int id, String details) {
			if (books.containsKey(id)) {
				return null;
			}
			Book book  = new Book(id, details);
			books.put(id,  book);
			return book;
		}
		
		public boolean remove(Book b) { return remove(b.getID()); }
		public boolean remove(int id) {
			if (!books.containsKey(id)) {
				return false;
			}
			books.remove(id);
			return true;
		}
		
		public Book find(int id) {
			return books.get(id);
		}
	}
	
	public class UserManager {
		private HashMap<Integer, User> users;
		
		public User addUser(int id, String details, int accountType) {
			if (users.containsKey(id)) {
				return null;
			}
			User user = new User(id, details, accountType);
			users.put(id, user);
			return user;
		}
		
		public User find(int id) { return users.get(id); }
		public boolean remove(User u) { return remove(u.getID()); }
		public boolean remove(int id) {
			if (!users.containsKey(id)) {
				return false;
			}
			users.remove(id);
			return true;
		}
	}
	
	public class Display {
		private Book activeBook;
		private User activeUser;
		private int pageNumber = 0;
		
		public void displayUser(User user) {
			activeUser = user;
			refreshUsername();
		}
		
		public void displayBook(Book book) {
			pageNumber = 0;
			activeBook = book;
			
			refreshTitle();
			refreshDetails();
			refreshPage();
		}
		
		public void turnPageForward() {
			pageNumber++;
			refreshPage();
		}
		
		public void turnPageBackward() {
			pageNumber--;
			refreshPage();
		}
		
		public void refreshUsername() { /* updates username display */}
		public void refreshTitle() { /* updates title display */ }
		public void refreshDetails() { /* updates details display */}
		public void refreshPage() { /* updated page display */}
	}
	
	public class Book {
		private int bookId;
		private String details;
		
		public Book(int id, String det) {
			bookId = id;
			details = det;
		}

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}
	}
	
	public class Uset {
		private int userId;
		private String details;
		private int accountType;
		
		public void renewMembership() { }

		public Uset(int userId, String details, int accountType) {
			super();
			this.userId = userId;
			this.details = details;
			this.accountType = accountType;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

		public int getAccountType() {
			return accountType;
		}

		public void setAccountType(int accountType) {
			this.accountType = accountType;
		}
		
	}
}
