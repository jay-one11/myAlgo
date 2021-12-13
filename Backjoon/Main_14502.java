import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int map[][];
	static int N,M;
	static int max;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<int[]> virus = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}

		Comb(0,0,0);
		System.out.println(max);
	}
	private static void Comb(int cnt, int r, int c) {
		if (cnt == 3) {
			max = Math.max(check(), max);
			return;
		}
		for (int i = r; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					Comb(cnt+1,i,j);
					map[i][j] = 0;
				} else continue;
			}
		}
		
		
	}
	private static int check() {
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < virus.size(); i++) {
			que.offer(virus.get(i));
		}
		int[][] c_map = new int[N][M];

		for (int j = 0; j < N; j++) {
			System.arraycopy(map[j], 0, c_map[j], 0, M);
		}
		
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			for (int i = 0; i < dc.length; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(inner(nr,nc) && c_map[nr][nc] == 0) {
					que.offer(new int[] {nr,nc});
					c_map[nr][nc] = 2;
				}
			}
		}
		int return_ = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(c_map[i][j] == 0) {
					return_ +=1;
				}
			}
		}
		
		return return_;
	}
	private static boolean inner(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr>=0 && nr < N && nc >= 0 && nc <M;
	}
}
