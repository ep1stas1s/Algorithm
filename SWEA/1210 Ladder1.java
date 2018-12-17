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
		
		// �׷��� Ǯ���� �ʾ�����, ����� ����ϴ� ���� �ξ� �����ϰ� ����
		StringTokenizer st;
		
		int[][] arr;
		List<Integer> startPoint;
		
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			arr = new int[100][100];					// ��ٸ�
			startPoint = new ArrayList<>();				// ������
			int answer = 0;								// ��
			
			for(int i = 0; i < 100; i++) {				// �� ����
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					if(i == 0) {						// ù ° �ٿ���
						if(arr[i][j] == 1) {			// ���� ����(���� 1�� ��)�� list�� �߰�
							startPoint.add(j);
						}
					}
				}
			}
			
			for(int i = 0; i < startPoint.size(); i++) {// list�� �������
				int tempX = 0;
				int tempY = startPoint.get(i);
				
				while(tempX != 99) {
					if(tempY + 1 < 100 && arr[tempX][tempY + 1] == 1) {			// ���� ���� ���� �� (�迭�� �ʰ����� �����鼭)
						while(tempY + 1 < 100 && arr[tempX][tempY + 1] == 1) {	// Y��ǥ +1
							tempY++;
						}
					}else if(tempY - 1 >= 0 && arr[tempX][tempY - 1] == 1) {	// ���� ���� ���� �� (�迭�� �ʰ����� �����鼭)
						while(tempY - 1 >= 0 && arr[tempX][tempY - 1] == 1) {	// Y��ǥ -1
							tempY--;
						}
					}
					tempX++;
				}
				
				if(arr[tempX][tempY] == 2) {
					answer = startPoint.get(i);
					break;
				}
			}
			
			bw.write("#" + String.valueOf(tc) + " " + answer + "\n");
		} // test case END
		
		bw.flush();
		bw.close();
	}
}