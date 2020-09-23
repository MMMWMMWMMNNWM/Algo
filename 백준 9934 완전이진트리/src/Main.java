import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int tree[];
	static int seq[];
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		tree = new int [(int)Math.pow(2,k)-1];
		seq = new int [(int)Math.pow(2,k)-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < (int)Math.pow(2,k)-1; i++){
			seq[i] = Integer.parseInt(st.nextToken());
		}
		search(0,1);

		for(int i = 1; i <= k; i++) {
			for(int j = (int) Math.pow(2, i - 1) - 1; j < (int) Math.pow(2, i)- 1; j++) {
				System.out.print(tree[j]+" ");
			}
			System.out.println();
		}
	}
	
	static int idx = 0;
	static void search(int cur,int level) {
		if(level == k) {
			tree[cur] = seq[idx];
			idx++;
		}
		else {
			int left = cur*2 + 1;
			int right = cur*2 + 2;
			search(left, level+1);
			tree[cur] = seq[idx];
			idx++;
			search(right, level+1);
		}
	}
}
