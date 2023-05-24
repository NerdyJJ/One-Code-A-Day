import java.io.*;
import java.util.*;

public class Main {

	static double C; // 0.0 ~ 5.0
	static int N; // 10만
	static int[] p; // 0 ~ 24
	static int max_solved;
	static int max_streak;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Double.parseDouble(br.readLine());

		int cnt_freeze = C >= 1.98 ? 2 : (int) Math.floor(C / 0.99);

		N = Integer.parseInt(br.readLine());

		p = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int streak = 0;
		int cnt_zero = 0;
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());
			p[i] = k;
			max_solved = Math.max(max_solved, k);
		}

		int next_i = 0;
		for (int i = 0; i < N; i++) {
			if (cnt_zero == cnt_freeze + 1) {
				max_streak = Math.max(max_streak, streak - 1);
				i = next_i - 1;
				next_i = 0;
				cnt_zero = 0;
				streak = 0;
				continue;
			}

			if (p[i] == 0 && i < N - 1) {
				cnt_zero++;
				if (next_i == 0) {
					next_i = i + 1;
				}
			}
			streak++;
		}

		max_streak = Math.max(max_streak, streak);

		StringBuilder sb = new StringBuilder();
		sb.append(max_streak).append("\n").append(max_solved);
		System.out.println(sb.toString());
	}

}
