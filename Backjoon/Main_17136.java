import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {
	static int [][]map;
	static final int N = 10;
	static int[] paper = {0,5,5,5,5,5};
	static int result =26;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,0,0);
		if(result == 26) {
			System.out.println(-1);
			return;
		}
		System.out.println(result);
		
	}
	private static void DFS(int r, int c, int cnt) {
		if(r>=9 && c > 9) {
			result = Math.min(result, cnt);
			return;
		}
		if(result <= cnt) return;
		if(c >9) {
			DFS(r+1,0,cnt);
			return;
		}
		if(map[r][c] == 1) {
			for (int i = 5; i >= 1; i--) {
				if(paper[i] >0 && isAttach(r,c,i)) {
					Attach(r,c,i,0);
					paper[i] -=1;
					DFS(r,c+1,cnt+1);
					Attach(r,c,i,1);
					paper[i] +=1;				}
			}
		}
		else {
			DFS(r,c+1,cnt);
		}
	}
	private static void Attach(int r, int c, int size, int state) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				map[i][j] = state;
			}
		}
		
	}
	private static boolean isAttach(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(!(i>=0 && i<N && j>=0 && j<N)) return false;
				if(map[i][j] != 1) return false;
				
			}
		}
		return true;
	}
	
}
