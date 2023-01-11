import java.io.*;
import java.util.*;

public class S0111_Main_13699_점화식 {

	static int N;
	static long[] T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if (N < 2) {
			System.out.println(1);
			return;
		}

		T = new long[N + 1];

		T[0] = 1;
		T[1] = 1;
//		System.out.println(T[0]);
//		System.out.println(T[1]);

		for (int i = 2; i <= N; i++) {
			long temp = 0;
			for (int j = 0; j < i; j++) {
				temp += T[j] * T[i - j - 1];
			}

			T[i] = temp;
//			System.out.println(T[i]);
		}

		System.out.println(T[N]);
	}

}
