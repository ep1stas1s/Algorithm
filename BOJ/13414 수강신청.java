import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());	// ���� ���� �ο�
		int L = Integer.parseInt(st.nextToken());	// ����� ����

		// key : �й� / value : ����
		// �й�(key)���� ���� ������ ����(value)�� ����
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < L; i++) {
			String studentId = br.readLine();
			map.put(studentId, i);
		}

		// value�� ���� ����
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list, (o1, o2) -> {
			int v1 = map.get(o1);
			int v2 = map.get(o2);
			return ((Comparable<Integer>)v1).compareTo(v2);
		});

		// �ִ� ���� �ο����� ��û �ο��� ���� ��� ó��
		int mapSize = map.size();
		if (mapSize < K) {
			K = mapSize;
		}

		// ���
		for (int i = 0; i < K; i++) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}
}