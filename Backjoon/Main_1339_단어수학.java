import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Main_1339_단어수학 {
	static int N;
	static int len;
	static List<HashMap<Character, Integer>> list = new ArrayList<HashMap<Character,Integer>>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < 8; i++) {
			list.add(new HashMap<Character, Integer>());
		}
		for (int i = 0; i < N; i++) {
			char[] buf = br.readLine().toCharArray();
			len = Math.max(len, buf.length);
			for (int j = 0; j < buf.length; j++) {
				if(list.get(buf.length-j-1).containsKey(buf[j])) {
					list.get(buf.length-j-1).put(buf[j], list.get(buf.length-j).get(buf[j])+1);
				}else {
					list.get(buf.length-j-1).put(buf[j], 1);
				}
			}
		}

		for (int i = 0; i < len; i++) {
			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>();

			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
				{
					return obj2.getValue().compareTo(obj1.getValue());
				}
			});
			
		}
		
		
		
	}
}
