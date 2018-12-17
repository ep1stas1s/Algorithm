import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int[][] arr;
		List<Integer> startPoint;
		
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			arr = new int[100][100];					// 사다리
			startPoint = new ArrayList<>();				// 시작점
			int minResult = 10000;						// 최단 거리
			int result = 0;								// 답
			
			for(int i = 0; i < 100; i++) {				// 맵 생성
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					if(i == 0) {						// 첫 째 줄에서
						if(arr[i][j] == 1) {			// 시작 지점(값이 1인 곳)을 list에 추가
							startPoint.add(j);
						}
					}
				}
			}
			
			for(int i = 0; i < startPoint.size(); i++) {// list를 기반으로
				int tempX = 0;
				int tempY = startPoint.get(i);
				int tempAnswer = 0;
				
				while(tempX != 99) {
					if(tempY + 1 < 100 && arr[tempX][tempY + 1] == 1) {			// 우측 길이 있을 때 (배열을 초과하지 않으면서)
						while(tempY + 1 < 100 && arr[tempX][tempY + 1] == 1) {	// 세로 좌표 +1
							tempY++;
							tempAnswer++;
						}
					}else if(tempY - 1 >= 0 && arr[tempX][tempY - 1] == 1) {	// 좌측 길이 있을 때 (배열을 초과하지 않으면서)
						while(tempY - 1 >= 0 && arr[tempX][tempY - 1] == 1) {	// 세로 좌표 -1
							tempY--;
							tempAnswer++;
						}
					}
					tempX++;
					tempAnswer++;
				}
				
				if(minResult >= tempAnswer) {									// 최소값 갱신 및 result값 초기화
					minResult = tempAnswer;
					result = startPoint.get(i);
				}
			}
			
			bw.write("#" + String.valueOf(tc) + " " + result + "\n");
		} // test case END
		
		bw.flush();
		bw.close();
	}
}
