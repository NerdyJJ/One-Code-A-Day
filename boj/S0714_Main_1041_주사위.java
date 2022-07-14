import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0714_Main_1041_주사위 {

	static long N; // 1 ~ 100만
	static int[] dice;
	static int maxD, minD;
	static int totalD;
	static long d3, d2, d1;
	static long s3, s2, s1;
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());

		dice = new int[6];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		maxD = 0;
		minD = 51;
		for (int i = 0; i < 6; i++) {
			int k = Integer.parseInt(st.nextToken());
			dice[i] = k;
			totalD += k;
			maxD = Math.max(maxD, k);
			minD = Math.min(minD, k);
		}

		// AF = 5, BE = 5, CD = 5;

		// 3면 조합
		s3 = 4;
		d3 = Math.min(dice[0], dice[5]) + Math.min(dice[1], dice[4]) + Math.min(dice[2], dice[3]);

		// 2면 조합
		s2 = (8 * N) - 12;
		d2 = 101;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j <= 5; j++) {
				if (i + j != 5) {
					d2 = Math.min(d2, dice[i] + dice[j]);
				}
			}
		}
		
		// 1면 조합
		s1 = (5 * N * N) - (16 * N) + 12;
		d1 = minD;

		result = s3 * d3 + s2 * d2 + s1 * d1;

//		System.out.println(s3 + " " + s2 + " " + s1);
//		System.out.println(d3 + " " + d2 + " " + d1);
		if(N == 1) System.out.println(totalD - maxD);
		else System.out.println(result);
	}
}
