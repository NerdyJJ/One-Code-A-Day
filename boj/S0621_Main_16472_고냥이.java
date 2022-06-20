import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class S0621_Main_16472_고냥이 {
	
	static int N; // 26
	static Queue<Character> q;
	static Set<Character> s;
	static int maxLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int L = str.length();
		
		q = new LinkedList<>();
		s = new HashSet<>();

		int left = 0, right = 1;
		
		char leftC = str.charAt(left);
		char rightC;
		
		q.add(leftC);
		s.add(leftC);
		
		while (true) {
			maxLen = Math.max(maxLen, q.size());
			
			if(right == L) break;
			
			rightC = str.charAt(right);
			
			if(s.size() < N) { // 사용한 문자 개수가 N보다 작으면
//				System.out.println("1. 사용한 문자 개수가 N보다 작으면");
				q.add(rightC);
				s.add(rightC);
			} else { // N개 이상 사용했을경우
				if(q.contains(rightC)) { // Q에 포함된 문자라면 넣어주고
//					System.out.println("2. Q에 포함된 문자라면 넣어주고");
					q.add(rightC);
				} else { // 아닌경우 Q를 하나씩 제거하면서 S 갱신
//					System.out.println("3. 아닌경우 Q를 하나씩 제거하면서 S 갱신");
					char rc = q.poll();
					// rc가 아직 q에 존재한다면 S 갱신 x
					// rc가 더이상 q에 존재하지 않는다면 갱신 o
					if(!q.contains(rc)) {
//						System.out.println("4. rc가 더이상 q에 존재하지 않는다면 갱신 o");
						s.remove(rc);
					}
					continue;
				}
			}
			
			right++;
		}
		
		System.out.println(maxLen);
		
		// 무식하게 Collection 사용해서 풀었는데 >> ...
		
		// 투포인터를 사용하여 간단하게 풀 수 있다. https://glanceyes.tistory.com/71
		
		// cnt : left ~ i 까지 사용된 알파벳 종류
		// letter[c] : left ~ i 까지 알파벳 c가 사용된 횟수
		
		
		// 기본 개념을 정리하고 투포인터 기본 문제를 여러개 풀어보자.
	}

}
