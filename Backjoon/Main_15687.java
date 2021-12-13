import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15687_arraytest {
	static int N,M;
	static int map[][];
	static List<int[]> Chicken = new ArrayList<>();
	static List<int[]> House = new ArrayList<>();
	static int MinValue = Integer.MAX_VALUE;
//	 1. 맵을 구성한다.
//	 2. M개의 치킨집의 경우의 수를 comb로 구현한다.
//	 3. 각집 - 치킨집 간의 최소 거리를 구한다
//	 4. 최소 거리간의 합 tot을 구한 후 다음 case
//	 5. 모든 case를 구한 후 가장 작은 tot 값을 출력
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int h = 0; int c = 0;
		for (int m = 0; m < N; m++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int n = 0; n < N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
				if(map[m][n] == 1) {
					int[] p = {m,n};
					House.add(p);
					
				}
				else if(map[m][n] == 2) {
					int[] p = {m,n};
					Chicken.add(p);
				}
			}
		}
		comb(0,0,0, new int[M]);
		System.out.println(MinValue);
	}
private static void comb(int cnt, int start,int flag, int nums[]) {
	if(cnt == M) {
		// M개의 치킨집 선택완료 nums 안의 값은 chicken arr의 indx
		// 치킨거리 구하기
		int sum =0;
		for (int i = 0; i < House.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < nums.length; j++) {
				int tot = Math.abs(House.get(i)[0] - Chicken.get(nums[j])[0]) + Math.abs(House.get(i)[1] - Chicken.get(nums[j])[1]);
				min = Math.min(min, tot);
			}
			sum += min;
		}
		MinValue = Math.min(MinValue, sum);

		return;
	}
	for (int i = start; i < Chicken.size(); i++) {
		if((flag & 1<<i) != 0) continue;
		nums[cnt] = i;
		comb(cnt+1,i+1,flag | 1<<i,nums);
	}
}


}
