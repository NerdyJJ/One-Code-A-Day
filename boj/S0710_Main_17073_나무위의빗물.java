import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0710_Main_17073_나무위의빗물 {
	
	static int N; // 노드 수 2 ~ 50만
	static int W; // 물의 양 1 ~ 10억
	
	static double result;
	
	static int[] edgeCnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		edgeCnt = new int[N+1];
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			edgeCnt[u]++;
			edgeCnt[v]++;
		}
		
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if(edgeCnt[i] == 1) cnt++;
		}
		
		result = W / (double) cnt;
		
		System.out.println(result);
	}

}
