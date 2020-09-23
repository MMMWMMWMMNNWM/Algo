import java.io.*;
import java.util.*;
//개같이 틀린 문제
public class Main {
	static int t;
	static int n;
	static String number[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			n = Integer.parseInt(br.readLine());
			number = new String[n];
			for(int i = 0; i < n; i++) {
				number[i] = br.readLine();
			}
			
			boolean answer = true;
			Arrays.sort(number);
			
			for(int i = 1; i < n; i++) {
				if(number[i-1].length()<number[i].length()) {
					if(number[i-1].equals(number[i].substring(0, number[i-1].length()))){
						answer = false;
						break;
					}
				}
			}
			
			if(answer) sb.append("Yes\n");
			else sb.append("No\n");
		}
		
		System.out.println(sb);
	}
}
