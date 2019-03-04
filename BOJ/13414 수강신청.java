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
		int K = Integer.parseInt(st.nextToken());	// 수강 가능 인원
		int L = Integer.parseInt(st.nextToken());	// 대기목록 길이

		// key : 학번 / value : 순번
		// 학번(key)으로 누른 마지막 순번(value)을 저장
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < L; i++) {
			String studentId = br.readLine();
			map.put(studentId, i);
		}

		// value에 따라 정렬
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list, (o1, o2) -> {
			int v1 = map.get(o1);
			int v2 = map.get(o2);
			return ((Comparable<Integer>)v1).compareTo(v2);
		});

		// 최대 수강 인원보다 신청 인원이 적을 경우 처리
		int mapSize = map.size();
		if (mapSize < K) {
			K = mapSize;
		}

		// 출력
		for (int i = 0; i < K; i++) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}
}