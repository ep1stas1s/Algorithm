import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 숫자 카드의 개수
		int n = Integer.parseInt(br.readLine());
		
		// 숫자 카드를 저장할 배열 (~1,000,000) 선언 및 저장
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		// 배열 정렬
		Arrays.sort(arr);
		
		// 0번을 초기값으로 저장 
		long result = arr[0];
		int maxCnt = 1;
		int cnt = 1;
		
		for(int i = 1; i < n; i++) {
			// 같은 번호가 반복되면 cnt증가  
			if(arr[i - 1] == arr[i]) {
				cnt++;
				
				// cnt가 증가하다가 maxCnt 값을 넘으면 교체
				if(cnt > maxCnt) {
					maxCnt = cnt;
					result = arr[i];
				}
				
			// 번호가 달라지면 cnt = 1으로 초기화
			}else {
				cnt = 1;
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}