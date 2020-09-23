import java.io.*;
import java.util.*;
public class Main {
	static int t;
	static int n,m;
	static long dp[][];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		dp = new long[31][31];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i = 2; i < 31; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		for(int i = 2; i < 31; i++) {
			for(int j = 1; j < i; j++) {
				dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
			}
		}
		
		for(int test = 0; test < t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			System.out.println(dp[m][n]);
		}
	}
}
