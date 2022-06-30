import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S0630_Main_3190_뱀 {
	
	static int N; // 보드 크기 2 ~ 100
	static int K; // 사과 갯수 0 ~ 100
	// K개의 사과 위치 (중복x)
	static int L; // 방향 전환 횟수 1 ~ 100
	// L개의 방향 전환 ( 왼쪽 L, 오른쪽 D )

	static Deque<Pos> dq;
	static int[][] board; // 사과 : -1, 뱀 : 자연수, 빈칸 : 0
	static int[][] rotate;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우하좌상 (시계방향)

	static int snakeStep = 0; //
	static int snakeDir = 0; // 진행 방향

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static void move() {
		snakeStep++;
		
		Pos head = dq.peek();

		int nx = head.x + delta[snakeDir][0];
		int ny = head.y + delta[snakeDir][1];
		
//		System.out.println("----------");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}

		if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] != 1) {
			if (board[nx][ny] == 0) { // empty
				Pos tail = dq.pollLast();
				board[tail.x][tail.y] = 0;
			}
			
			dq.addFirst(new Pos(nx, ny));
			board[nx][ny] = 1;
			
		} else {
			crash();
		}
	}

	static void rotate(char ch) {
		if (ch == 'D') {
			snakeDir++;
		} else {
			snakeDir--;
		}

		if (snakeDir < 0)
			snakeDir += 4;
		else if (snakeDir > 3)
			snakeDir -= 4;
	}

	static void crash() {
		System.out.println(snakeStep);
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];

//		dq = new LinkedList<>();
		dq = new ArrayDeque<>();

		dq.add(new Pos(0, 0));
		board[0][0] = 1;

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// apple
			int ax = Integer.parseInt(st.nextToken()) - 1;
			int ay = Integer.parseInt(st.nextToken()) - 1;

			board[ax][ay] = -1;
		}

		L = Integer.parseInt(br.readLine());

		rotate = new int[L][2];

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// rotate command
			int nowStep = snakeStep;
			int step = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);

//			System.out.println("togo : " + (step - nowStep));
			for (int j = 0; j < step - nowStep; j++) {
				move();
			}

//			System.out.println("rotate to " + dir);
			rotate(dir);
		}

		while (true) {
//			System.out.println("keep going");
			move();
		}

	}

}
