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
		
		// ���� ī���� ����
		int n = Integer.parseInt(br.readLine());
		
		// ���� ī�带 ������ �迭 (~1,000,000) ���� �� ����
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		// �迭 ����
		Arrays.sort(arr);
		
		// 0���� �ʱⰪ���� ���� 
		long result = arr[0];
		int maxCnt = 1;
		int cnt = 1;
		
		for(int i = 1; i < n; i++) {
			// ���� ��ȣ�� �ݺ��Ǹ� cnt����  
			if(arr[i - 1] == arr[i]) {
				cnt++;
				
				// cnt�� �����ϴٰ� maxCnt ���� ������ ��ü
				if(cnt > maxCnt) {
					maxCnt = cnt;
					result = arr[i];
				}
				
			// ��ȣ�� �޶����� cnt = 1���� �ʱ�ȭ
			}else {
				cnt = 1;
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}