import java.util.*;
import java.io.*;
class cube{
	cube(){
		setCube();
	}
	char front[][] = new char[3][3];
	char back[][] = new char[3][3];
	char up[][] = new char[3][3];
	char down[][] = new char[3][3];
	char left[][] = new char[3][3];
	char right[][] = new char[3][3];
	private void setCube() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.front[i][j] = 'r';
				this.back[i][j] = 'o';
				this.up[i][j] = 'w';
				this.down[i][j] = 'y';
				this.left[i][j] = 'g';
				this.right[i][j] = 'b';
			}
		}
	}
	public void printCube() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(up[i][j]);
			}
			System.out.println();
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(up[i][j]);
			}
			System.out.println();
		}
	}
	
	public void rotateRight(boolean clockWise) {
		if(clockWise) {
			char temp = right[0][0];
			right[0][0] = right[2][0]; right[2][0] = right[2][2];
			right[2][2] = right[0][2]; right[0][2] = temp;
			temp = right[0][1];
			right[0][1] = right[1][0]; right[1][0] = right[2][1];
			right[2][1] = right[1][2]; right[1][2] = temp;
			char t1,t2,t3;
			t1 = up[0][2]; t2 = up[1][2]; t3 = up[2][2];
			up[0][2] = front[0][2]; up[1][2] = front[1][2]; up[2][2] = front[2][2];
			front[0][2] = down[2][2]; front[1][2] = down[1][2]; front[2][2] = down[0][2];
			down[2][2] = back[0][2]; down[1][2] = back[0][1]; down[0][2] = back[0][0];
			back[0][2] = t3; back[0][1] = t2; back[0][0] = t1;
		}
		else {
			char temp = right[0][0];
			right[0][0] = right[0][2]; right[0][2] = right[2][2];
			right[2][2] = right[2][0]; right[2][0] = temp;
			temp = right[0][1];
			right[0][1] = right[1][2]; right[1][2] = right[2][1];
			right[2][1] = right[1][0]; right[1][0] = temp;
			char t1,t2,t3;
			t1 = up[0][2]; t2 = up[1][2]; t3 = up[2][2];
			up[2][2] = back[0][2]; up[1][2] = back[0][1]; up[0][2] = back[0][0];
			back[0][2] = down[2][2]; back[0][1] = down[1][2]; back[0][0] = down[0][2];
			down[2][2] = front[0][2]; down[1][2] = front[1][2]; down[0][2] = front[2][2];
			front[0][2] = t1; front[1][2] = t2; front[2][2] = t3;
		}
	}
	
	public void rotateLeft(boolean clockWise) {
		if(clockWise) {
			char temp = left[0][0];
			left[0][0] = left[2][0]; left[2][0] = left[2][2];
			left[2][2] = left[0][2]; left[0][2] = temp;
			temp = left[0][1];
			left[0][1] = left[1][0]; left[1][0] = left[2][1];
			left[2][1] = left[1][2]; left[1][2] = temp;
			char t1,t2,t3;
			t1 = front[0][0]; t2 = front[1][0]; t3 = front[2][0];
			front[0][0] = up[0][0]; front[1][0] = up[1][0]; front[2][0] = up[2][0];
			up[0][0] = back[2][2]; up[1][0] = back[1][2]; up[2][0] = back[0][2];
			back[2][2] = down[2][0]; back[1][2] = down[1][0]; back[0][2] = down[0][0];
			down[2][0] = t1; down[1][0] = t2; down[0][0] = t3;
		}
		else {
			char temp = left[0][0];
			left[0][0] = left[0][2]; left[0][2] = left[2][2];
			left[2][2] = left[2][0]; left[2][0] = temp;
			temp = left[0][1];
			left[0][1] = left[1][2]; left[1][2] = left[2][1];
			left[2][1] = left[1][0]; left[1][0] = temp;
		
			char t1,t2,t3;
			t1 = front[0][0]; t2 = front[1][0]; t3 = front[2][0];
			front[0][0] = down[2][0]; front[1][0] = down[1][0]; front[2][0] = down[0][0];
			down[2][0] = back[2][2];  down[1][0] = back[1][2]; down[0][0] = back[0][2];
			back[2][2] = up[0][0]; back[1][2] = up[1][0]; back[0][2] = up[2][0];
			up[0][0] = t1; up[1][0] = t2; up[2][0] = t3;
		}
	}
	
	public void rotateUp(boolean clockWise) {
		if(clockWise) {
			char temp = up[0][0];
			up[0][0] = up[2][0]; up[2][0] = up[2][2];
			up[2][2] = up[0][2]; up[0][2] = temp;
			temp = up[0][1];
			up[0][1] = up[1][0]; up[1][0] = up[2][1];
			up[2][1] = up[1][2]; up[1][2] = temp;
			char t1,t2,t3;
			t1 = front[0][0]; t2 = front[0][1]; t3 = front[0][2];
			front[0][0] = right[0][0]; front[0][1] = right[0][1]; front[0][2] = right[0][2];
			right[0][0] = back[0][0]; right[0][1] = back[0][1]; right[0][2] = back[0][2];
			back[0][0] = left[0][0]; back[0][1] = left[0][1]; back[0][2] = left[0][2];
			left[0][0] = t1; left[0][1] = t2; left[0][2] = t3;
		}
		else {
			char temp = up[0][0];
			up[0][0] = up[0][2]; up[0][2] = up[2][2];
			up[2][2] = up[2][0]; up[2][0] = temp;
			temp = up[0][1];
			up[0][1] = up[1][2]; up[1][2] = up[2][1];
			up[2][1] = up[1][0]; up[1][0] = temp;
			char t1,t2,t3;
			t1 = front[0][0]; t2 = front[0][1]; t3 = front[0][2];
			front[0][0] = left[0][0]; front[0][1] = left[0][1]; front[0][2] = left[0][2];
			left[0][0] = back[0][0]; left[0][1] = back[0][1]; left[0][2] = back[0][2];
			back[0][0] = right[0][0]; back[0][1] = right[0][1]; back[0][2] = right[0][2];
			right[0][0] = t1; right[0][1] = t2; right[0][2] = t3;
		}
	}
	
	public void rotateDown(boolean clockWise) {
		if(clockWise) {
			char temp = down[0][0];
			down[0][0] = down[2][0]; down[2][0] = down[2][2]; 
			down[2][2] = down[0][2]; down[0][2] = temp;
			temp = down[0][1];
			down[0][1] = down[1][0]; down[1][0] = down[2][1];
			down[2][1] = down[1][2]; down[1][2] = temp;
			char t1,t2,t3;
			t1 = front[2][0]; t2 = front[2][1]; t3 = front[2][2];
			front[2][0] = left[2][0]; front[2][1] = left[2][1]; front[2][2] = left[2][2];
			left[2][0] = back[2][0]; left[2][1] = back[2][1]; left[2][2] = back[2][2];
			back[2][0] = right[2][0]; back[2][1] = right[2][1]; back[2][2] = right[2][2];
			right[2][0] = t1; right[2][1] = t2; right[2][2] = t3;
		}
		else {
			char temp = down[0][0];
			down[0][0] = down[0][2]; down[0][2] = down[2][2];
			down[2][2] = down[2][0]; down[2][0] = temp;
			temp = down[0][1];
			down[0][1] = down[1][2]; down[1][2] = down[2][1];
			down[2][1] = down[1][0]; down[1][0] = temp;
			
			char t1,t2,t3;
			t1 = front[2][0]; t2 = front[2][1]; t3 = front[2][2];
			front[2][0] = right[2][0]; front[2][1] = right[2][1]; front[2][2] = right[2][2];
			right[2][0] = back[2][0]; right[2][1] = back[2][1]; right[2][2] = back[2][2];
			back[2][0] = left[2][0]; back[2][1] = left[2][1]; back[2][2] = left[2][2];
			left[2][0] = t1; left[2][1] = t2; left[2][2] = t3;
		}
	}
	
	public void rotateFront(boolean clockWise) {
		if(clockWise) {
			char temp = front[0][0];
			front[0][0] = front[2][0]; front[2][0] = front[2][2];
			front[2][2] = front[0][2]; front[0][2] = temp;
			temp = front[0][1];
			front[0][1] = front[1][0]; front[1][0] = front[2][1];
			front[2][1] = front[1][2]; front[1][2] = temp;
			char t1,t2,t3; 
			t1 = up[2][0]; t2 = up[2][1]; t3 = up[2][2];
			up[2][0] = left[2][2]; up[2][1] = left[1][2]; up[2][2] = left[0][2];
			left[2][2] = down[2][2]; left[1][2] = down[2][1]; left[0][2] = down[2][0];
			down[2][0] = right[2][0]; down[2][1] = right[1][0]; down[2][2] = right[0][0];
			right[0][0] = t1; right[1][0] = t2; right[2][0] = t3;
			}
		else {
			char temp = front[0][0];
			front[0][0] = front[0][2]; front[0][2] = front[2][2];
			front[2][2] = front[2][0]; front[2][0] = temp;
			temp = front[0][1];
			front[0][1] = front[1][2]; front[1][2] = front[2][1];
			front[2][1] = front[1][0]; front[1][0] = temp;

			char t1,t2,t3; 
			t1 = up[2][0]; t2 = up[2][1]; t3 = up[2][2];
			up[2][0] = right[0][0]; up[2][1] = right[1][0]; up[2][2] = right[2][0];
			right[2][0] = down[2][0]; right[1][0]= down[2][1]; right[0][0] = down[2][2];
			down[2][2] = left[2][2]; down[2][1] = left[1][2]; down[2][0] = left[0][2];
			left[2][2] = t1 ; left[1][2] = t2; left[0][2] = t3;
		}
	}
	
	public void rotateBack(boolean clockWise) {
		if(clockWise) {
			char temp = back[0][0];
			back[0][0] = back[2][0]; back[2][0] = back[2][2];
			back[2][2] = back[0][2]; back[0][2] = temp;
			temp = back[0][1];
			back[0][1] = back[1][0]; back[1][0] = back[2][1];
			back[2][1] = back[1][2]; back[1][2] = temp;
			
			char t1, t2, t3;
			t1 = up[0][0]; t2 = up[0][1]; t3 = up[0][2];
			up[0][0] = right[0][2]; up[0][1] = right[1][2]; up[0][2] = right[2][2];
			right[0][2] = down[0][2]; right[1][2] = down[0][1]; right[2][2] = down[0][0];
			down[0][2] = left[2][0]; down[0][1] = left[1][0]; down[0][0] = left[0][0];
			left[2][0] = t1; left[1][0] = t2; left[0][0] = t3;
			
		}
		else {
			char temp = back[0][0];
			back[0][0] = back[0][2]; back[0][2] = back[2][2];
			back[2][2] = back[2][0]; back[2][0] = temp;
			temp = back[0][1];
			back[0][1] = back[1][2]; back[1][2] = back[2][1];
			back[2][1] = back[1][0]; back[1][0] = temp;

			
			char t1, t2, t3;
			t1 = up[0][0]; t2 = up[0][1]; t3 = up[0][2];
			
			up[0][0] = left[2][0]; up[0][1] = left[1][0]; up[0][2] = left[0][0];
			left[2][0] = down[0][2]; left[1][0] = down[0][1]; left[0][0] = down[0][0];
			down[0][2] = right[0][2]; down[0][1] = right[1][2]; down[0][0] = right[2][2];
			right[0][2] = t1; right[1][2] = t2; right[2][2] = t3;
		}
		
	}
	
}
public class Main {
	static int T;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt((br.readLine()));

		for(int test = 0; test <T; test++) {
			int n = Integer.parseInt(br.readLine());
			String command[] = br.readLine().split(" ");
			cube c = new cube();
			for(int i = 0; i < command.length;i++) {
				char dir = command[i].charAt(0);
				boolean clockWise =  true;
				if(command[i].charAt(1)=='+') clockWise = true;
				else clockWise = false;
				
				if(dir == 'L') 
					c.rotateLeft(clockWise);
				if(dir == 'R') 
					c.rotateRight(clockWise);
				if(dir == 'U') 
					c.rotateUp(clockWise);
				if(dir == 'D')
					c.rotateDown(clockWise);
				if(dir == 'F')
					c.rotateFront(clockWise);
				if(dir == 'B')
					c.rotateBack(clockWise);
				System.out.println(command[i]);
				c.printCube();
				System.out.println();
			}
//			c.printCube();
			
		}
	}
}
