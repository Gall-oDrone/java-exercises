package leetCodeExcercises1;

public class LC_ValidPalindrome_125 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public boolean isPalindrome(String s) {
		
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right) {
			while(left< right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			left++;
			right--;
		}
		return true;
	}
}
