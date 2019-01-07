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
		
		// A �迭
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// B �迭
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// A, B ����
		// �������� B�� ��迭�ϸ� �ȵȴٰ�������, 
		// A�� ������� ��ġ�ϴ� �Ͱ� B�� ������� ��ġ�ϴ� ���� ������
		Arrays.sort(A);
		Arrays.sort(B);
		
		// S
		int S = 0;
		
		// A�� �� B�� �ݴ� ������ ������
		// ��, A�� 0����, B�� N���� (Ȥ�� �ݴ��)
		for(int i = 0; i < N; i++) {
			S += A[i] * B[N - i - 1];
		}
		
		bw.write(String.valueOf(S));
		bw.flush();
		bw.close();
	}
}