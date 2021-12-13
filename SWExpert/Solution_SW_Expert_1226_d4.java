import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SW_Expert_1226_d4 {
	static int T=10;
	static int N = 16;
	static int sr,sc,er,ec;
	static int map[][] = new int[N][N];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int poss;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {

			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				char[] dd = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = (int)(dd[j]-'0');
					if(map[i][j] == 2) {
						sr = i; sc = j;
					}
					else if (map[i][j] == 3) {
						er = i; ec = j;
					}
				}
			}
		poss = 0;
		dfs(sr,sc);
		System.out.println("#"+t+" "+poss);
			
			
		}
		
		br.close();
	}
	public static void dfs(int SR, int SC) {
		map[SR][SC] = -1;
		for (int x = 0; x < dc.length; x++) {
			
			int nr = SR+dr[x];
			int nc = SC+dc[x];
			if(nr>=0 && nr<N && nc >= 0 && nc <N) {
				if(nr==er && nc == ec) {
					poss = 1;
					return;
				}
				else if (map[nr][nc] == 0) {
					dfs(nr,nc);
				}
			}
			else continue;
		}
	}
	
	static boolean[][] v = new boolean[N][N];
	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr,sc});
		v[sr][sc] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < cur.length; d++) {
				int nr = r+dr[d] ;
				int nc = c+dc[d] ;
				if(!(nr>=0 && nr<N && nc >= 0 && nc <N)) continue;
				if(nr == er && nc == ec) {
					poss = 1;
					return;
				}
				if(!v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					que.offer(new int[] {nr,nc});
				}
			}
		}
	}
}
