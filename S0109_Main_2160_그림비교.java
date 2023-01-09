import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S0109_Main_2160_그림비교 {
	
	static int N; // 그림의 개수 (2 ~ 50)
	static char[][][] map;
	static int[] answer = new int[2];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][5][7];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = br.readLine().toCharArray();
			}
		}
		
		
		
		int diff = 35; // 다른칸의 개수 최대값 (5*7)
		int numA = 0;
		int numB = 1;
		
		while(true) {
			if(diff == 0 || numA+1 >= N) break;
			
			int count = 0;
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 7; j++) {
					if(map[numA][i][j] != map[numB][i][j]) count++;
				}
			}
			
			if(diff >= count) {
				diff = count;
				answer[0] = numA+1;
				answer[1] = numB+1;
			}
			
			if(numB+1 < N) {
				numB++;
			} else {
				numA++;
				numB = numA + 1;
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);

	}

}
