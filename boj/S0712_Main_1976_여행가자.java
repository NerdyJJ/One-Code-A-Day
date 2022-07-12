import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S0712_Main_1976_여행가자 {
	
	static int N; // 도시의 수 1 ~ 200
	static int M; // 여행 계획에 속한 도시의 수 1 ~ 1000
	static String result = "YES";
	
	static boolean[][] map;
	static boolean[] visited;
	
	static List<Integer> cityList;
	static List<Integer> tripList;
	
	static void dfs(int k) {
		visited[k] = true;
		
		for (int i = 0; i < N; i++) {
			if(map[k][i] && !visited[i]) {
				visited[i] = true;
				cityList.add(i);
				dfs(i);
			} else continue;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		visited = new boolean[N];
		
		cityList = new ArrayList<>();
		tripList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int c = Integer.parseInt(st.nextToken());
				
				if(c > 0) map[i][j] = true;
			}
		}
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken()) - 1;
		cityList.add(start);
		
		for (int i = 1; i < M; i++) {
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			if(!tripList.contains(c)) tripList.add(c);
			else continue;
		}
		
		dfs(start);
		
		for (Integer t : tripList) {
			if(cityList.contains(t)) continue;
			else {
				result = "NO";
				break;
			}
		}
		
		System.out.println(result);
	}

}
