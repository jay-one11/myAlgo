import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406 {
	static int N,M,K;
	static int[][] A;
	static int[][] copy;
	static int[][] ka;
	static int d;
	static int[] dr = {1,0,-1,0};
	static int[] dc= {0,1,0,-1};
	
	static int KK;
	static int count;
	
	static int[] num;
	static boolean[] v;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		copy = new int[N][M];
		ka = new int[K][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				ka[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// logic
		count =0;
		min = Integer.MAX_VALUE;
		num = new int[K];
		v = new boolean[K];
		nPr(0);
		System.out.println(min);	
	}

	private static void nPr(int cnt) {
		if(K==cnt) {
			// logic
			for (int i = 0; i < N; i++) {
				System.arraycopy(A[i], 0, copy[i], 0, M);
			}
			clock(num);
			print();
			return;
		}
		for (int i = 0; i < K; i++) {
			if(v[i])continue;
			v[i] = true;
			num[cnt] = i;
			nPr(cnt+1);
			v[i] = false;
		}
	}
	static int max;
	private static void clock(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int r = ka[arr[i]][0];
			int c = ka[arr[i]][1];
			int s = ka[arr[i]][2];
			System.out.println();
			max = (Math.min(r, c)+1)/2;

			SwirlArray(r-s-1,c-s-1,r-s-1,c-s-1,copy[r-s][c-s],s);

			for (int a = 0; a < N; a++) {
				int sum = 0;
				for (int b = 0; b < M; b++) {
					sum += copy[a][b];
				}
				min = Math.min(sum, min);
			}
		}
		System.out.println("-------------------------------");
	}
	
	private static void SwirlArray(int r_, int c_, int sr,int sc,int tmp,int s) {
		if(Math.max(sr, sc) == max) return;

		if(r_ == sr && c_ == sc+2*s-1) d = (d+1)%4; // 오른쪽 위 끝? 
		if(r_ == sr+2*s-1 && c_ == sc+2*s-1) d = (d+1)%4; // 오른쪽 아래 끝? 
		if(r_ == sr+2*s-1 && c_ == sc) d = (d+1)%4; // 왼쪽 아래 끝? 
		if(r_ == sr-1 && c_ == sc)  { // 왼쪽 위 , 원점 r 좌표 -1 점까지 도착, 한바퀴 순회 완료
			d = (d+1)%4; 
			copy[sr][sc] = tmp;
			SwirlArray(sr+1, sc+1, sr+1, sc+1,copy[sr+1][sc+1],s);
			return;
	}

		int nr = r_+dr[d];
		int nc = c_+dc[d];
		if(!(nr>=0 && nr<r_+2*s && nc>= 0 && nc<c_+2*s)) return;
		
		int tmp2 = copy[nr][nc];
		copy[nr][nc] = tmp;
		
		SwirlArray(nr,nc,sr,sc,tmp2,s);	
	}
	
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	
	
}
