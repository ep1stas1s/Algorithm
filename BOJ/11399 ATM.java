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

		// ��� ��
		int N = Integer.parseInt(br.readLine());
		
		// ���� �� �ɸ��� �ð� (+ ����)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		// �� ������� �����ϴ� �� �ɸ��� �ð�
		for(int i = 1; i < N; i++) {
			arr[i] += arr[i - 1];
		}
		
		// ��� ����� �����ϴ� �� �ɸ��� �ð�
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}