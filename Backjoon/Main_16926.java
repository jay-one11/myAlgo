import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_16926 {
	
	static int N,M,R;
	static int[][] map;
	static int d = 0;
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,1,0,-1};
	static int max ;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		max = (Math.min(N, M)+1)/2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int t = 0; t < R; t++) {
			d = 0;
			SwirlArray(0, 0, 0, map[0][0]);
		} 
		print();
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void SwirlArray(int r_, int c_, int cnt,int tmp) {
		if(cnt == max) return;
		
		int Shell_r = cnt;
		int Shell_c = cnt;
		if(r_ == N-Shell_r-1 && c_ == Shell_c) d = (d+1)%4; // 왼쪽 아래 끝? 
		if(r_ == N-Shell_r-1 && c_ == M-Shell_c-1) d = (d+1)%4; // 오른쪽 아래 끝? 
		if(r_ == Shell_r && c_ == M-Shell_c-1) d = (d+1)%4; // 오른쪽 위 끝? 
		if(r_ == Shell_r && c_ == Shell_c+1)  { // 왼쪽 첫번째 점 끝, 한바퀴 순회 완료
				d = (d+1)%4; 
				map[Shell_r][Shell_c] = tmp;
				SwirlArray(cnt+1, cnt+1, cnt+1,map[cnt+1][cnt+1]);
				return;
		}
		int nr = r_+dr[d];
		int nc = c_+dc[d];
		if(!(nr>=0 && nr<N && nc>= 0 && nc<M)) return;
		
		int tmp2 = map[nr][nc];
		map[nr][nc] = tmp;
		
		SwirlArray(nr,nc,cnt,tmp2);	
	}
}
