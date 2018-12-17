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
		
		int M = Integer.parseInt(br.readLine());		// ������ ��
		int[] arr = new int[20];						// ����
		StringTokenizer st;
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			String str;
			int num = 0;
			if(st.countTokens() == 1) {
				str = st.nextToken();
			}else {
				str = st.nextToken();
				num = Integer.parseInt(st.nextToken()) - 1;
			}
			
			// 1~20 ������ �迭�� �� ���� ������ 1, ������ 0���� ǥ��
			switch (str) {
			case "add":
				arr[num] = 1;
				break;
			case "remove":
				arr[num] = 0;
				break;
			case "check":
				bw.write(String.valueOf(arr[num]) + "\n");
				break;
			case "toggle":
				if(arr[num] == 0)
					arr[num] = 1;
				else 
					arr[num] = 0;
				break;
			case "all":
				Arrays.fill(arr, 1);
				break;
			case "empty":
				Arrays.fill(arr, 0);
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}