import java.io.*;
import java.util.*;

public class Main {
	static int Mem[] = new int[20000001];
	static final int set = 10000000;
	static int n,m;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int cur = Integer.parseInt(st.nextToken()) + set;
			Mem[cur]++;
		}
		
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int cur = Integer.parseInt(st.nextToken())+set;
			sb.append(Mem[cur]+" ");
		}
		System.out.println(sb);
	}
}

