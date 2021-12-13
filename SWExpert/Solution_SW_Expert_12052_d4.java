import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_Expert_12052_d4 {
	static int T;
	static int N, M;
	static int[][] map;
	static int[] dr = {0,0,-1,-1};
	static int[] dc = {0,-1,0,-1};
	// 자신, 좌, 상, 좌상 검색
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		T  = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int n = 0; n < N; n++) {
				char[] cc = br.readLine().toCharArray();
				for (int m = 0; m < M; m++) {
					if(cc[m]=='#') {
						map[n][m] = 1;
						FindBrokenTile(n,m);
					} // 타일이 구멍이면 1, 구멍 없으면 0
					
				}
				
			}
			int sum = 0;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					sum += map[n][m];
				}
			}
			if(sum == 0) {
				System.out.println("#"+t+" YES");
			}
			else {
				System.out.println("#"+t+" NO");
			}
			
			
		}
	}
	public static void FindBrokenTile(int r, int c) {
		int tot = 0;
		for (int i = 0; i < dc.length; i++) {
			if(check(r+dr[i],c+dc[i])==1) tot +=1;
			else return;
		}
		if(tot == 4) {
			for (int i = 0; i < dc.length; i++) {
				map[r+dr[i]][c+dc[i]] = 0;
			}
		}
	}
	
	public static int check(int r, int c) {
		if(!(r>=0 && r<N && c>=0 &&c<M)) {
			return 0;
		}
		if(map[r][c] == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
