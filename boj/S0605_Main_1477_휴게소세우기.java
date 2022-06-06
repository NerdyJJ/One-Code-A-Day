import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S0605_Main_1477_휴게소세우기 {

	static int N; // 현재 휴게소 개수 0 ~ 50
	static int M; // 지어야 할 휴게소 개수 1 ~ 100
	static int L; // 고속도로 길이 100 ~ 1000
	static int result;

	static int[] rp; // 휴게소 위치 배열

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		rp = new int[N + 2]; // 시작 좌표, 끝 좌표 추가

		rp[0] = 0;
		rp[N + 1] = L;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			rp[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(rp);

		int left = 1, right = L; // 이분탐색용 left, right
		int mid = 0, count = 0;
//		int check = 0;
		while (left <= right) {
			mid = (left + right) / 2; // 탐색 기준이 될 휴게소 간 최대 거리
			count = 0; // 추가로 지을 수 있는 휴게소 총 개수
			
//			System.out.println(++check + "번째 >> left : " + left + " right : " + right + " mid : " + mid);

			for (int i = 1; i < N + 2; i++) {
				int dist = rp[i] - rp[i - 1] - 1; // 휴게소 사이 거리를 계산해서

				count += dist / mid; // 그 사이에 추가로 지을 수 있는 휴게소 개수를 count에 추가
			}
			
//			System.out.println("count : " + count);

			if (count > M) { // 계획한 개수보다 많이 지어진다면, 탐색 기준인 mid를 늘린 후 다시 탐색
				left = mid + 1;
			} else { // 계획한 개수보다 적게 지어진다면, 탐색 기준인 mid를 줄인 후 다시 탐색
				right = mid - 1;
			}

			// left 가 right 보다 커지게 되면 반복 탈출
		}
		
		result = left;

		System.out.println(result);
	}

	// 무조건 절반으로 나누는것 --> 오류
	// 중간에 여러개를 넣어야 하는 경우도 존재

	// 반례 : {0, 300, 500} 에 3개 짓기 --> 100, 200, 400 일때 최적

	// https://namhandong.tistory.com/199

}
