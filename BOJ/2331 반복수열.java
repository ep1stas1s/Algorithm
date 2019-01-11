import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �Է� ����
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// (�� �ڸ� ���ڸ� P������)���ڸ� ���� ����Ʈ
		List<Integer> list = new ArrayList<>();
		
		// ó�� A�� �ְ� ����
		list.add(A);
		
		// ������� ������ ����
		int result = 0;
		
		
		for(int i = 0; i < list.size(); i++) {
			// recursion method�� ���� temp ���
			int temp = recursion(list.get(i), P);
			
			// temp�� �������� ������ list�� �߰�
			if(!list.contains(temp)) {
				list.add(temp);
				
			// list�� temp�� �������� ������
			// �� ��°���� ����Ͽ� result�� ���� �ְ� break
			}else {
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j) == temp) {
						result = j;
						break;
					}
				}
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
	}
	
	// 10�� �����ָ鼭 ���������� �����Ͽ� �� �ڸ����� P������ ���
	public static int recursion(int num, int P) {
		int result = 0;
		while(num != 0) {
			int temp = num % 10;
			result += Math.pow(temp, P);
			num /= 10;
		}
		
		return result;
	}
}