import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 물이 새는 곳
		int N = Integer.parseInt(st.nextToken());
		
		// 테이프 길이
		int L = Integer.parseInt(st.nextToken());
		
		// 물 새는 곳의 위치
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// 총 필요한 테이프 개수
		int sum = 1;
		
		// 테이프를 붙인 곳 ~ 테이프 길이(L) - 1 (양 쪽의 0.5) 사이에 물이 새는 곳이 없다면
		// sum을 1 증가시키고, temp -> 새로 테이프를 붙인곳으로 초기화 
		int temp = arr[0];
		for(int i = 1; i < N; i++) {
			if(arr[i] > temp + L - 1) {
				sum++;
				temp = arr[i];
			}
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}