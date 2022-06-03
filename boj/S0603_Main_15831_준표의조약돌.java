import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S0603_Main_15831_준표의조약돌 {

	static int N; // 30만
	static int B, W;
	static int result;

	static Queue<Character> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		q = new LinkedList<Character>();


		int b = 0, w = 0; // 현재 q에 저장된 b, w 개수
		
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);

			if (c == 'B')
				b++;
			else
				w++;

			q.add(c);

			if (b > B) { // B 제한을 초과했을때, q에서 처음 B가 탐색될때까지 제거
				while (true) {
					char remove = q.poll();

					if (remove == 'B') {
						b--;
						break;
					} else {
						w--;
					}
				}
			}
			
			if (w < W) { // B 제한을 초과하지 않는데, w 제한에 도달하지 못했을때는 반복
				continue;
			}
			
			if(b <= B && w >= W) { // 모든 조건을 만족한 경우 max 갱신
				result = Math.max(result, q.size());
			}
		}
		
		System.out.println(result);
	}

}
