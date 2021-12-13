import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040 {
	static int dwarf[] = new int[9];
	static int N;
	static int R = 7;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = dwarf.length;
		for (int i = 0; i <N; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0,0,new int[R]);
	}
	
	public static void comb(int cnt, int start,int flag,int[] nums) {
		if(cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += nums[i];
			}
			if(sum == 100) {
				for (int i = 0; i < R; i++) {
					System.out.println(nums[i]);
				}
			}
			return;
		}

		for (int i = start; i < N; i++) {
			if((flag & 1 << i)!= 0) continue;
			nums[cnt] = dwarf[i];
			comb(cnt+1, i+1, flag|1<<i,nums);
		}
		
	}
	
}
