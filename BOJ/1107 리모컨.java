import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> brokenButton; // ���峭 ��ư�� ������ ArrayList

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // �̵��Ϸ��� ä��
		int M = Integer.parseInt(br.readLine()); // ���峭 ��ư�� ����

		// ���峭 ��ư�� list�� ����
		brokenButton = new ArrayList<>();
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				brokenButton.add(Integer.parseInt(st.nextToken()));
			}
		}

		// way1 : (���峭 ��ư�� ������)0~9 ��ư���� ����Ͽ� �ֺ����� �̵� ��, +, -��ư�� ����Ͽ� ������ �̵�
		int way1 = Integer.MAX_VALUE;
		// 0~1,000,000 ������ ��� ����� ���� ã��
		for (int i = 0; i < 1_000_000; i++) {
			// �ش� ���� �� ���峭 ��ư�� ���� ��츸 ����
			if (!isIncludedBrokenButton(i)) {
				int len = String.valueOf(i).length(); 	// �ش� ä�η� �̵��ϱ� ���Ͽ� �������ϴ� ��ư �� 
														// ex) ch675�� �̵��ϱ� ���� ���� 6, 7, 5 ��ư�� ������ �ϱ� ������ �� 3��
				int tempDiff = Math.abs(N - i); // �̵��� ä�κ��� ��ǥ ä�α��� +, -��ư Ŭ�� ȸ��
				way1 = Math.min(way1, tempDiff + len);
			}
		}

		// way2 : ������ġ(ch100)���� +, -��ư�� ����Ͽ� �̵�
		int start = 100;
		int way2 = Math.abs(N - start);
		bw.write(String.valueOf(Math.min(way1, way2)));
		bw.flush();
		bw.close();
	}

	/**
	 * �ش� ä�ο� �̵��� ��, ���峭 ��ư�� ���ԵǾ� �ִ� �� Ȯ��
	 * @param num �̵��ϱ� ���� ä��
	 * @return result ���峭 ��ư�� ���ԵǾ� �ִٸ� true�� ��ȯ
	 */
	public static boolean isIncludedBrokenButton(int num) {
		if (num == 0 && brokenButton.contains(num)) {
			return true;
		}

		while (num > 0) {
			if (brokenButton.contains(num % 10)) {
				return true;
			}
			num /= 10;
		}
		return false;
	}
}