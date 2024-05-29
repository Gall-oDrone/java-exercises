package crackingTheCodeInterviewExs_Moderate;

public class IQ_16_1_NumberSwapper {
	
	public void calculate() {
		int a = 9;
		int b = 4;
		a = a - b;
		b = a + b;
		a = b - a;
	}
	
	public void bitcalculate() {
		int a = 101;
		int b = 110;
		a = a ^ b;
		b = a ^ b;
		a = b ^ a;
	}
}
