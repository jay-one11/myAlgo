import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_9935_¹®ÀÚ¿­ÆøÆÈ2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();
		char[] input_arr= input.toCharArray();
		
		int bomb_len = bomb.length();
		while(true) {
			if(input.contains(bomb)) {
				char[] temp = new char[input_arr.length-bomb_len];
				int idx = input.indexOf(bomb);
				System.arraycopy(input_arr, 0, temp, 0, idx);
				System.arraycopy(input_arr, idx+bomb_len, temp, idx, temp.length-idx);
				input_arr = temp;
				input = String.valueOf(input_arr);
			}else {
				break;
			}
		}
		System.out.println(input.toString().equals("")?"FRULA":input.toString());
		
	}
	
}
