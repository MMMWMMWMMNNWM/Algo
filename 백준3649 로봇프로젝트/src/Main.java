import java.io.*;
import java.util.*;

public class Main {
	static int test;
	static int n;
	static int x;
	static int lego[];
	static boolean v[];
	public static void main(String args[]) throws IOException{

		sc.init();
		String size = "";
		while((size = sc.readLine())!=null) {
			x = Integer.parseInt(size);
			n = sc.nextInt();
			
			lego = new int[n];
			v = new boolean[n];
			
			for(int i = 0; i < n; i++) {
				lego[i] = sc.nextInt();
			}
			
			if(n <= 1) {
				System.out.println("danger");
				continue;
			}
			Arrays.sort(lego);
			Left = 0;
			Right = n-1;
			answer = -1;
			findPair();
		}
	}
	
	static class sc { 
		private static BufferedReader br;
        private static StringTokenizer st;
        
        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }
        
        static String readLine() {
            try{
                return br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }
        
        static String next() {
            while (!st.hasMoreTokens() ){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        static int nextInt() {
            return Integer.parseInt(next());
        }
        
    }


	static int answer;
	static int Left;
	static int Right;
	static int Nano = (int) Math.pow(10,7);
	static void findPair() {
		int right = Right;
		for(int i = 0; i < n; i++) {
			if(findRight(i+1,right, lego[i])) {
				System.out.println("yes "+lego[i]+ " "+lego[answer]);
				return ;
			}
		}
		System.out.println("danger");
	}
	
	static boolean findRight(int left, int right, int len) {
		int hole = x*Nano;
		while(left<=right) {
			int mid = (left+right)/2;
			if(lego[mid]+len==hole) {
				answer = mid;
				return true;
			}
			else if(lego[mid]+len > hole) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return false;
	}
}
