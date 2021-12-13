import java.util.*;
import java.io.*;


public class Main_BOJ_16918_봄버맨 {
	static int R,C,N;
	static char map[][];
	static int time;
	static Queue<int[]> que = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			char cc[] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j] = cc[j];
				if(map[i][j] == 'O') que.offer(new int[] {i,j});
			}
		}
		if(N == 2) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j] = 'O';
				}
			}
		}else if((N-2)%4 == 1) {
			int dr[] = {-1,1,0,0};
			int dc[] = {0,0,-1,1};
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j] = 'O';
				}
			}
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				map[cur[0]][cur[1]] = '.';
				for(int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if(nr>=0 && nr < R && nc >= 0 && nc <C) {
						map[nr][nc] = '.';
					}
				}
			}
			
		}else if((N-2)%4 == 2 || (N-2)%4 == 0) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j] = 'O';
				}
			}
		}else if((N-2)%4 == 3) {
			que.clear();
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == 'O') que.offer(new int[] {i,j});
				}
			}
			int dr[] = {-1,1,0,0};
			int dc[] = {0,0,-1,1};
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				map[cur[0]][cur[1]] = 'O';
				for(int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if(nr>=0 && nr < R && nc >= 0 && nc <C) {
						map[nr][nc] = 'O';
					}
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}
