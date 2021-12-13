import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1541_잃어버린괄호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int sum;
	public static void main(String[] args) throws IOException{
		char[] sentence = br.readLine().toCharArray();
		int dis =0;
		boolean flag = false;
		int buf = 0;
		for (int i =0 ; i < sentence.length; i ++) {
			switch (sentence[i]) {
				case '+': {
					if(flag) {
						dis += buf;
						buf =0;
					}else { 
						sum += buf;
						buf =0;
					}
					break;
				}
				case '-' : {
					if(flag) {
						dis += buf;
						buf = 0;
						sum -= dis;
						dis = 0;
					}else {
						sum += buf;
						buf = 0;
						flag = true;
					}
					break;
				}
				default : {
					buf = buf*10 + sentence[i]-'0';
					if(i == sentence.length-1) {
						if(flag) {
							dis += buf;
						}else {
							sum += buf;
						}
					}
					break;
				}
			}
		}
		System.out.println(sum - dis);
	}
}

