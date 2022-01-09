import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_9935_¹®ÀÚ¿­ÆøÆÈ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();
		while(true) {
			if(input.contains(bomb)) {
				input = input.replace(bomb, "");
				} 
			else {
				break;
			}
		}
		System.out.println(input.toString().equals("")?"FRULA":input.toString());
	}
}
