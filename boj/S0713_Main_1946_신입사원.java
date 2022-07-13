import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S0713_Main_1946_신입사원 {

	static int T; // 테케 개수 1 ~ 20
	static int N; // 지원자 숫자 1 ~ 10만
	
	static int result;
	
	static List<newbie> noobList;

	static class newbie implements Comparable<newbie> {
		int a; // 서류심사 성적 순위
		int b; // 면접 성적 순위

		public newbie(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(newbie o) {
			// TODO Auto-generated method stub
			return a - o.a;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			
			noobList = new ArrayList<>();
			result = 0;
			
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				noobList.add(new newbie(a, b));
			}
			
			Collections.sort(noobList);
			
			int lastB = 0;
			for (newbie n : noobList) {
				int a = n.a;
				int b = n.b;
				
				if(a == 1) {
					result++;
					lastB = b;
				} else if(b > lastB) {
					continue;
				} else {
					result++;
					lastB = b;
				}
			}
			
			System.out.println(result);
		}
	}

}
