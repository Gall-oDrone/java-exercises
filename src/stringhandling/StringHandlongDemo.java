package stringhandling;

public class StringHandlongDemo {

	public static void main(String[] args) {

		String str1 = "John is stuyding";
		String str2 = "in college";
		
		System.out.println(str1.length());
		
		String result = str1.concat(str2);
		System.out.println(result);
		
		String r = String.format("The name of student is " + "%s, and the age is %d,", "John", 21);
		System.out.println(r);
		
		System.out.println(str1.charAt(5));
		
		if(str1.equals(str2)) {
			System.out.println("both strings are same");
		} else {
			System.out.println("both strings are different");
		}

	}

}
