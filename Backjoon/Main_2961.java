import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2961 {
	static int T;
	static int[][]Food;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		Food = new int [T][2];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 2; j++) {
				Food[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= T; i++) {
			comb(0,0,i,new int[i]);
		}
		
		System.out.println(min);

	}
	
	public static void comb(int cnt, int start, int R, int[] nums ) {
		if(cnt == R) {
//			System.out.println(Arrays.toString(nums));
			int sum = 0;
			int mul = 1;
			for (int i = 0; i < R; i++) {
				sum += Food[nums[i]][1];
				mul *= Food[nums[i]][0];
			}
			int tot = Math.abs(sum-mul);
			min = Math.min(min, tot);
			
			
			return;
		}
		for (int i = start; i < T; i++) {
			nums[cnt] = i;
			comb(cnt+1,i+1,R,nums);
			
		}

	}
	
}
