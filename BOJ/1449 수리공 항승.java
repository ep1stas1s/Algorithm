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
		// ���� ���� ��
		int N = Integer.parseInt(st.nextToken());
		
		// ������ ����
		int L = Integer.parseInt(st.nextToken());
		
		// �� ���� ���� ��ġ
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// �� �ʿ��� ������ ����
		int sum = 1;
		
		// �������� ���� �� ~ ������ ����(L) - 1 (�� ���� 0.5) ���̿� ���� ���� ���� ���ٸ�
		// sum�� 1 ������Ű��, temp -> ���� �������� ���ΰ����� �ʱ�ȭ 
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