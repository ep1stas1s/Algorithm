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

		int N = Integer.parseInt(br.readLine());
		
		// A 배열
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// B 배열
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// A, B 정렬
		// 문제에서 B는 재배열하면 안된다고하지만, 
		// A를 마음대로 배치하는 것과 B를 마음대로 배치하는 것은 동일함
		Arrays.sort(A);
		Arrays.sort(B);
		
		// S
		int S = 0;
		
		// A는 와 B를 반대 순서로 곱해줌
		// 즉, A는 0부터, B는 N부터 (혹은 반대로)
		for(int i = 0; i < N; i++) {
			S += A[i] * B[N - i - 1];
		}
		
		bw.write(String.valueOf(S));
		bw.flush();
		bw.close();
	}
}