import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_6724_견우와직녀 {
	static int T;
	static int N,M,min;
	static int[][] map;	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			BFS(0,0);
			
			
			System.out.printf("#%d %d",t,min);
		} 
	}
	private static void BFS(int src_r, int src_c) {
		int[][] c_map = new int[N][N];
		Queue<int[]> que = new LinkedList<int[]>();
		ArrayList<Node> cliff = new ArrayList<>();
		boolean visited[][] = new boolean[N][N];
		que.offer(new int[] {src_r,src_c});
		visited[src_r][src_c] =true;
		
//		M을 사용하지 않고 직녀를 만나보기..
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			for (int i = 0; i < dc.length; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(check(nr,nc) && !visited[nr][nc]) {
					if(map[nr][nc] == 1) { // 땅인 경우
						que.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
						c_map[nr][nc] = c_map[cur[0]][cur[1]] +1;
						continue;
					}else if(map[nr][nc] > 1){ // 오작교인 경우 
						int time = c_map[cur[0]][cur[1]];
						while(time%map[nr][nc] != 0) {
							time +=1;
						}
						c_map[nr][nc] =time;
						que.offer(new int[] {nr,nc});
						visited[nr][nc] = true;

						continue;
					}else { // 벽인경우 --> que에 추가시켜주자.
						cliff.add(new Node(nr, nc, c_map[cur[0]][cur[1]]+1));
						visited[nr][nc] = true;
						continue;
					}
				}
			}
			if(cur[0]== N-1 && cur[1] == N-1) { // 직녀 만난 경우
				min = Math.min(min, c_map[cur[0]][cur[1]]);
			}
		}
		
//		이젠 챈스를 쓰기
		for (int i = 0; i < cliff.size(); i++) {
			int new_map[][] = new int[N][N];
			boolean new_visited[][] = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				System.arraycopy(c_map[j], 0, new_map[j], 0, N);
				System.arraycopy(visited[j], 0, new_visited[j], 0, N);
			}
			
			Queue<int[]> queue = new LinkedList<>();
			Node now = cliff.get(i);
			queue.offer(new int[] {now.r, now.c});
			while(now.dist%M != 0) {
				now.dist+=1;
			}
			new_map[now.r][now.c] = now.dist;
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				for (int j = 0; j < dc.length; j++) {
					int nr = cur[0] + dr[j];
					int nc = cur[1] + dc[j];
					if(check(nr, nc) && map[nr][nc] >0 && !new_visited[nr][nc]) {
						if(map[nr][nc] == 1) { // 땅인 경우
							queue.offer(new int[] {nr,nc});
							new_visited[nr][nc] = true;
							new_map[nr][nc] = new_map[cur[0]][cur[1]] +1;
							continue;
						}else if(map[nr][nc] > 1){ // 오작교인 경우 
							int time = new_map[cur[0]][cur[1]];
							while(time%map[nr][nc] != 0) {
								time +=1;
							}
							new_map[nr][nc] =time;
							queue.offer(new int[] {nr,nc});
							new_visited[nr][nc] =true;
							continue;
						}
					}
				}
				if(cur[0]== N-1 && cur[1] == N-1) { // 직녀 만난 경우
					min = Math.min(min, new_map[cur[0]][cur[1]]);
					break;
				}
			}
		}
		
		
	}
	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}

class Node{
	int r;
	int c;
	int dist;
	public Node(int r, int c, int dist) {
		super();
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
	
	
}