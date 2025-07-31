package crackingTheCodeInterviewExs_Moderate;

public class IQ_16_17_ContiguousSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}

}
