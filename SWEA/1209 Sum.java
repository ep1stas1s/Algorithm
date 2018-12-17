import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int[][] arr;
		
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			int sum = 0;
			
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 100; i++) {
				int temp = 0;
				// 가로 합
				for(int j = 0; j < 100; j++) {
					temp += arr[i][j];
				}
				sum = Math.max(sum, temp);

				// 세로 합
				temp = 0;
				for(int j = 0; j < 100; j++) {
					temp += arr[j][i];
				}
				sum = Math.max(sum, temp);
			}
			// 대각선 1
			int temp = 0;
			for(int i = 0; i < 100; i++) {
				temp += arr[i][i];
			}
			sum = Math.max(sum, temp);
			
			// 대각선 2
			temp = 0;
			for(int i = 0; i < 100; i++) {
				temp += arr[i][99 - i];
			}
			sum = Math.max(sum, temp);
			
			bw.write("#" + String.valueOf(tc) + " " + sum + "\n");
		} // test case END
		
		bw.flush();
		bw.close();		
	}
}