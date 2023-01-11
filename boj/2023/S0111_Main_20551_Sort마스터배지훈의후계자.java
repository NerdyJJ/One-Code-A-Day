import java.io.*;
import java.util.*;

public class S0111_Main_20551_Sort마스터배지훈의후계자 {

	static int N, M; // (1 ~ 200000)
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());

			int left = 0;
			int right = N - 1;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (arr[mid] < num) {
					left = mid + 1;
				} else if (arr[mid] > num) {
					right = mid - 1;
				} else {
					while(mid > 0) {
						if(arr[mid-1] == num) {
							mid--;
						} else {
							break;
						}
					}
					sb.append(mid).append("\n");
					break;
				}
			}
			
			if(left > right) sb.append(-1).append("\n");
		}
		
		System.out.println(sb.toString());
		
		// 이분탐색
		// lower_bound 참고할것
	}

}
