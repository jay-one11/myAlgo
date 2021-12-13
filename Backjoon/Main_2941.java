import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;
		char[] cc = s.toCharArray();
		for (int i = cc.length-1; i >= 0; i--) {
			switch (cc[i]) {
			case '=' :{
				
				if(i>=2) {
					if(cc[i-1]=='z') {
						if(cc[i-2]=='d') { 
							cnt-=1;
							break;
						}
						else {
							break;
						}
					}
				}

				if(cc[i-1] == 'c' || cc[i-1] == 's') { 
					break;
				}
				
			}
			case '-' :{
				break;	
			}
			case 'j' :{
				if(i>0) {
					if(cc[i-1] =='l' || cc[i-1] == 'n') {
						break;
					}
					else cnt+=1;
				}
				else cnt+=1; break;
			}
			
			default:
				cnt +=1;
			}				
		}
		
		System.out.println(cnt);
	}
}
