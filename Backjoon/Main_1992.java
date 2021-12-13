import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_1992_쿼드트리 {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char [] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j]-'0';
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		QuadTree(0,0,N);
		
	}
	private static void QuadTree(int r, int c, int width) {
		if(width ==1 || SameColor(r,c,width)) {
			if(map[r][c] == 0) {
				System.out.print(0);
			}
			else if(map[r][c] == 1) {
				System.out.print(1);
			}
			return;
		}

		width = width/2;
		System.out.print("(");
		QuadTree(r, c, width);
		QuadTree(r, c+width, width);
		QuadTree(r+width, c, width);
		QuadTree(r+width, c+width, width);
		System.out.print(")");
		
		
		
	}
	private static boolean SameColor(int r, int c, int width) {
		for (int i = r; i < r+width; i++) {
			for (int j = c; j < c+width; j++) {
				if(map[i][j] != map[r][c]) return false;
			}
		}
		return true;
	}
}
