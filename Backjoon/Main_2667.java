import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class Main_2667 {
	static int N;
	static int map[][] ;
	static int count[];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int danzi = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new int[N*N*N];
		for (int i = 0; i < N; i++) {
			char buffer[] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = buffer[j]-'0';
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 1) { 
					cnt ++;
					count[cnt+1] = 1;
					dfs(i,j,cnt+1);
				}
			}
		}
		
		print();
		Integer[] ii = new Integer[cnt];
		System.arraycopy(count,2,ii,0,cnt);
		//
		Arrays.sort(ii);
		//
		for (int i : ii) {
			System.out.println(i);
		}
		
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" " );
			}
			System.out.println();
		}
		
	}
	private static void dfs(int r, int c, int group) {
		map[r][c] = group;
		for (int i = 0; i < dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(!(nr>=0 && nr<N && nc>=0 && nc<N)) {
				if(map[nr][nc] == 1) {
					count[group] +=1;
					dfs(nr,nc,group);
				}
			}
			
		}
	}
	
}
