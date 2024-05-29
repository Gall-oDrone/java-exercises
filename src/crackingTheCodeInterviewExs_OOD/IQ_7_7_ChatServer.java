package crackingTheCodeInterviewExs_OOD;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class IQ_7_7_ChatServer {

	public class UserManager {
		private static UserManager instance;
		/* maps from a user id to a user */
		private HashMap<Integer, User> userById;
		
		/* maps from an account name to a user */
		private HashMap<Integer, User> onlineUsers;
		
		public static UserManager getInstace() {
			if (instance == null) instance = new UserManager();
			return instance;
		}
		
		public void addUser(User fromUser, String toAccountName) {}
		public void approveAddRequest(AddRequest req) {}
		public void rejectAddRequest(AddRequest req) {}
		public void userSignedOn(String accountName) {}
		public void userSignedOff(String accountName) {}
	}
	
	public class User {
		private int id;
		private UserStatus status = null;
		
		/* maps from the other participant's user id to the chat */
		private HashMap<Integer, PrivateChat> privateChats;
		
		/* list of group chats */
		private ArrayList<GroupChat> groupChats;
		
		private HashMap<Integer, AddRequest> receivedAddRequests;
		
		private HashMap<Integer, AddRequest> sentAddRequests;
		
		private HashMap<Integer, User> contacts;
		
		private String accountName;
		private String fullName;
		
		/*
		 * 23 public User(int id, String accountName, String fullName) { ... }
24 public boolean sendMessageToUser(User to, String content){ ... }
25 public boolean sendMessageToGroupChat(int id, String cnt){...}
26 public void setStatus(UserStatus status) { }
27 public UserStatus getStatus() { ... }
28 public boolean addContact(User user) { ... }
29 public void receivedAddRequest(AddRequest req) { ...}
30 public void sentAddRequest(AddRequest req) { ... }
31 public void removeAddRequest(AddRequest req) { ... }
32 public void requestAddUser(String accountName) { ... }
33 public void addConversation(PrivateChat conversation) { }
34 public void addConversation(GroupChat conversation) { ... }
35 public int getid() { ... }
36 public String getAccountName() { ... }
37 public String getFullName() { ... }
		 * */
	}
	
	public abstract class Conversation {
		protected ArrayList<User> participants;
		protected int id;
		protected ArrayList<Message> messages;
		
		public ArrayList<Message> getMessages() {}
		public boolean addMessage(Message m) {}
		public int getId() {}
	}
	
	public class GroupChat extends Conversation {
		public void removeParticipant(User user) {}
		public void addPArticipant(User user) {}
	}
	
	public class PrivateChat extends Conversation {
		public PrivateChat(User user1, User user2) {}
		
	}
	
	public class Message {
		private String content;
		private Date date;
		public Message(String content, Date date) {}
		public String getContent() {}
		public Date getDate() {}
	}
	
	public class AddRequest() {}
	
	public enum UserStatusType {
		Offline, Away, Idle, Available, Busy
	}
	
	public enum RequestStatus {
		Unread, Read, Accepted, Rejected
	}
}
