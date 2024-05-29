package crackingTheCodeInterviewExs_OOD;

public class IQ_7_2_CallCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class CallHandler {
		/* 3 levels of employees: respodents, managers, directors. */
		private final int LEVELS = 3;
	}
	
	/* Initialize 10 respodents, 4 managers, and 2 directors. */
	private final int NUM_RESPODENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	/* List of employees, by level.
	 * employeeLevel[0] = respodents
	 * employeeLevel[0] = manager
	 * employeeLevel[0] = directors
	 */
	List<List<Employee>> employeeLevels;
	
	/* queues for each call's rank */
	List<List<Call>> callQueues;
	
	public CallHandler() {}
	
	public Employee getHandlerForCall(Call call) {}
	
	public void disptachCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}
	
	/* Routes the call to an available employee, or saves in a queue if no employee
	 * os available
	 */
	public void dispatchCall(Call call) {
		/* Try to route the call to an employee with minimal rank. */
		Employee emp = getHandlerForCall(call);
		if (emp != null) {
			emp.receiveCall(call);
			if (emp != null) {
				emp.receiveCall(call);
				call.setHandler(emp);
			} else {
				call.reply("Please wait for free employee to reply");
				callQueues.get(call.getRank().getValue()).add(call);
			}
		}
	}
	
	public boolean assignCall(Employee emp) {}
	
	public class Call {
		/* Minimal rank of employee who can handle this call. */
		private Rank rank;
		
		/* Person who is calling. */
		private Caller caller;
		
		/* Employee who is handling call. */
		private Employee handler;
		
		public Call(Caller c) {
			rank = Rank.Responder;
			caller = c;
		}
	}
	
	abstract class Employee {
		private Call currentCall = null;
		protected Rank rank;
		
		public Employee(CallHandler handler) {}
		
		/* Start the conversation */
		public void receiveCall(Call call) {}
		
		public void callCompleted() {}
		
		/* The issue has not been resolved. Escalate the call, and assign
		 * a new call to the employee. */
		public void escalateAndReassign() {}
		
		/* Assign a new call to an employee, if the employee is free. */
		public boolean assignCall() {}
		
		/* Returns whether or not the employee is free. */
		public boolean isFree() { return currentCall == null;}
		
		public Rank getRank() { return rank; }
	}
	
	class Director extendss Employee {
		public Director() {
			rank = Rank.Director;
		}
	}
	
	class Manager extends Empployee {
		public Manager() {
			rank = Rank.Manager;
		}
	}
	
	class Respondent extends Employee {
		public Respondent() {
			rank = Rank.Responder;
		}
	}
}
