import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0829_Main_2436_공약수 {
	static int G, L; // 최대공약수, 최소공배수 ( 2 ~ 1억 )
	
	// 유클리드 알고리즘 (GCD)
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		G = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		// L = G * a * b;
		
		int ldg = L / G;
		
		// 중앙(ldg 제곱근) 부터 시작해서 최대공약수 판단
		for (int i = (int) Math.round(Math.sqrt(ldg)); i >= 1; i--) {
			
			if(ldg % i == 0 && gcd(i, ldg / i) == 1) {
				System.out.println((G*i) + " " + G*(ldg/i));
				return;
			}
		}
	}
}
