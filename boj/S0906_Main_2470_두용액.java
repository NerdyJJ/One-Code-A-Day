import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S0906_Main_2470_두용액 {
	static int N; // ( 2 ~ 10만 )
	static int[] arr;
	static int result1;
	static int result2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		int minSum = 2000000000;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			int absSum = Math.abs(sum);
			
			if(absSum < minSum) {
				result1 = arr[left];
				result2 = arr[right];
				minSum = absSum;
			}
			
			if(sum < 0) left++;
			else right--;
		}
		
		if(result1 > result2) System.out.println(result2 + " " + result1);
		else System.out.println(result1 + " " + result2);
	}
}
