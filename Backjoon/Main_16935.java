import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//	1. 맵구성, 적의 개수 카운트 (N , M , Ecnt )
//	2. combi를 통해 궁수 배치 (MC3)
//	3. 시뮬레이션 
//		3-1 현재 위치에서 가장 가까운 거리 D 이내의 적에게만( 왼쪽 순)에게  화살 발사 ( D )
//		3-2 잡은 적의 수 카운트 ( score )
//		3-3 한줄 내림 (지나간 적, 화살 맞은 적은 없앰)
//		3-4 적이 없어지면 종료
public class Main_17135 {
	static int map[][];
	static int N,M,D;
	static int archer = 3;
	static int Ecnt;
	static int MaxScore = Integer.MIN_VALUE;
	static int Cmap[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		Cmap = new int[N+1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) Ecnt +=1;
			}
		}
		
		Arrow(0,0,new int[3]);
		System.out.println(MaxScore);
	}
	public static void Arrow(int cnt, int start, int[] nums) {
		if(cnt == archer) {
			// 궁수 위치 3개가 정해진 상황 ( 각각 map[N+1][nums[0]], map[N+1][nums[1]], map[N+1][nums[2]] ) 
			// 가까운 적 3명에게 화살을 계속 발사하도록 
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, Cmap[i], 0, map[i].length);
			}
			GameStart(N,0,Ecnt,nums);

			return;
		}
		for (int i = start; i < M; i++) {
			nums[cnt] = i;
			Arrow(cnt+1,i+1,nums);
		}
	}


	
	public static void GameStart(int times, int score, int Enemy,int[] nums) {
		while(Enemy != 0) {
			target[] a = new target[archer];
			for (int i = 0; i < archer; i++) {
				a[i] = FindNearestTarget(nums[i],times); // 가장 가까운 타겟 찾기
			}
			for (int i = 0; i < archer; i++) {
				if(a[i] == null) continue;
				if(Cmap[a[i].r][a[i].c] == 1) {
					Cmap[a[i].r][a[i].c] = 0;
					score +=1; // 적을 잡으면 score 1++ 하고 적 삭제 ( 중복 방지)
					Enemy -=1;
				}
				
			}
			// 1라운드 종료
			// 맵 갱신 ( 적 내려오게 ) => 궁수가 올라가는것으로 생각 
			// 맨아랫줄 남은 적 제거 (Ecnt -= 남은적)
			for (int i = 0; i < M; i++) {
				Enemy -= Cmap[times-1][i];
			}
			Cmap[times-1] = new int[M];
			times -=1;
//			printmap();
//			System.out.println(score);
		}
		MaxScore = Math.max(MaxScore, score);
		return;
	}
	private static target FindNearestTarget(int S, int times) {
		target arc = new target(999,999,Integer.MAX_VALUE);
		for (int i = 1; i <= D; i++) {
			for (int j = -D+1; j <= D-1; j++) {
				if(Math.abs(i)+Math.abs(j) > D) continue;  // 화살 범위를 벗어난 경우 
				int nr = times-i; int nc = S+j; // 화살 도착 위치
				if(!(nr>=0 && nr<times+1 && nc>=0 &&nc <M)) continue; // 화살이 맵 밖에 나간 경우	
				if(Cmap[nr][nc] == 1) { // 화살 도착위치에 적이 있는경우 
					int dist = Math.abs(times-nr)+Math.abs(S-nc); // 화살이 맵 안에 있는 경우 : 궁수와 적과의 거리를 계산
					if((dist <= arc.dist)) {
						if(arc.c > nc && arc.r>nr || dist <arc.dist) {
							arc.dist = dist;
							arc.r = nr;
							arc.c = nc;
						}

					}
				}
			}
		}
		if(arc.r ==999)	return null;
		else return arc;
	}
	static class target{
		int r;
		int c;
		int dist;
		public target(int n, int s, int d) {
			this.r =n;
			this.c = s;
			this.dist = d;
		}

	}
}
