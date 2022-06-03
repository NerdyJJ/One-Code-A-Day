import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S0603_Main_15918_랭퍼든수열쟁이야 {

	static int N; // 2 ~ 12
	static int X, Y; // 1 <= x < y <= 2n, 1 <= y-x-1 <= n
	static int[] langford;
	static int result;

	static int goLF(int k) {
		int cnt = 0;

		if (k == Y - X - 1)
			return goLF(k + 1); // 이미 채워진 condition 스킵
		if (k > N)
			return 1; // LF 배열이 다 채워진 경우 1

		// LF[i] = LF[i+k+1] = n
		// 백트래킹으로 구현
		for (int i = 1; (i + k + 1) < 2 * N + 1; i++) {
			if(langford[i] == 0 && langford[i+k+1] == 0) { // 둘다 빈자리면 k를 넣고 다음
				langford[i] = langford[i+k+1] = k;
				cnt += goLF(k+1);
				langford[i] = langford[i+k+1] = 0; // 되돌리기
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		if (N % 4 == 1 || N % 4 == 2) {
			System.out.println(0);
			return;
		}

		langford = new int[N * 2 + 1];

		int condition = Y - X - 1;
		langford[X] = condition;
		langford[Y] = condition;

		result = goLF(1);
		
		System.out.println(result);
	}

}
