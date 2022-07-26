import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0726_Main_1527_금민수의개수 {
	
	static int A; // 1 ~ 10억
	static int B; // A ~ 10억
	static int result;
	
	static void search(long n) {
		if(n > B) return;
		
		if(n <= B && n >= A) {
//			System.out.println(n);
			result++;
		}
		
		search(n*10 + 4);
		search(n*10 + 7);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		search(0);
		
		System.out.println(result);
	}
	
	// 처음에는 문자열 4, 7 이외의 숫자 여부로 판단			..> 시초
	
	// 각자리별 처리 : n < 4, 4 <= n < 7, 7 < n		..> 3^9 * 2 = 3만정도..
	
	// dfs 활용! >> int 사용한뒤 오버플로 고려해서 음수값 패스하려 했는데, 양수값도 나와서 올바른 방법이 아님..
	// >> long 사용

}
