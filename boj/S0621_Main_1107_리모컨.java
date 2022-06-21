import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0621_Main_1107_리모컨 {

	static int N; // 이동하려는 채널 0 ~ 50만
	static int M; // 고장난 버튼의 개수 0 ~ 10

	static int[] num;
	static boolean[] broken; // 고장난 버튼

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		num = new int[6];
		broken = new boolean[10];

		String strN = Integer.toString(N);
		int len = strN.length();

		int temp = N;
		for (int i = len - 1; i >= 0; i--) {
			num[i] = temp % 10;
			temp /= 10;
		}

		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int k = Integer.parseInt(st.nextToken());

				broken[k] = true;
			}
		}

		if (N == 100) {
			System.out.println(0);
			return;
		}

		if (M == 0) {
			result = Math.min(Math.abs(N - 100), strN.length());
		} else if (M == 10) {
			result = Math.abs(N - 100);
		} else {
			// maxS
			String strMaxS = "";
			int numMaxS = N;
			while (true) {
				if (numMaxS < 0) break;
				strMaxS = Integer.toString(numMaxS);
//				System.out.println("strMaxS : " + strMaxS);
				boolean isCorr = true;
				for (int j = 0; j < strMaxS.length(); j++) {
					if (broken[strMaxS.charAt(j) - '0']) {
						isCorr = false;
						break;
					}
				}

				if (isCorr)
					break;
				
				numMaxS--;
			}

			// minL
			String strMinL = "";
			int numMinL = N;
			while (true) {
				if (numMinL > 1000000) break;
				strMinL = Integer.toString(numMinL);
//				System.out.println("strMinL : " + strMinL);
				boolean isCorr = true;
				for (int j = 0; j < strMinL.length(); j++) {
					if (broken[strMinL.charAt(j) - '0']) {
						isCorr = false;
						break;
					}
				}

				if (isCorr)
					break;
				
				numMinL++;
			}

			if (numMaxS < 0) {
				result = Math.min(Math.abs(N - 100), Math.abs(numMinL - N) + strMinL.length());
			} else if (numMinL > 1000000) {
				result = Math.min(Math.abs(N - 100), Math.abs(numMaxS - N) + strMaxS.length());
			} else {
				result = Math.min(Math.abs(N - 100),
						Math.min(Math.abs(numMaxS - N) + strMaxS.length(), Math.abs(numMinL - N) + strMinL.length()));
			}

		}

		System.out.println(result);

		// 1. M == 0
		// min(abs(N-100), 숫자N 길이)

		// 2. M == 10
		// abs(N-100)

		// 3. else
		// maxS : N보다 작으면서 가장 가까운 수
		// minL : N보다 크면서 가장 가까운 수

		// min(abs(N-100), (abs(maxS-100)+숫자 maxS 길이), (abs(minL-100)+숫자 minL 길이))
		
		// ------------------------------
		
		// 증감연산자 사용시 값이 변하는것을 주의
		
		// 문자열로 처리하지 않고, 6사이즈 배열로 각 자리 숫자를 처리하면 메모리를 아낄수 있다. --> 문자열 : 비효율
		
		// 반복문 탈출 조건이나 탐색 방법을 다듬으면 코드를 더 간단하게 작성할수 있을지도.. 
		
	}
}
