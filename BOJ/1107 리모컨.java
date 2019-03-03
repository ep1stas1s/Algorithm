import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> brokenButton; // 고장난 버튼을 저장할 ArrayList

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

		// 고장난 버튼을 list에 넣음
		brokenButton = new ArrayList<>();
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				brokenButton.add(Integer.parseInt(st.nextToken()));
			}
		}

		// way1 : (고장난 버튼을 제외한)0~9 버튼으로 사용하여 주변으로 이동 후, +, -버튼을 사용하여 나머지 이동
		int way1 = Integer.MAX_VALUE;
		// 0~1,000,000 까지의 모든 경우의 수를 찾음
		for (int i = 0; i < 1_000_000; i++) {
			// 해당 숫자 중 고장난 버튼이 없을 경우만 실행
			if (!isIncludedBrokenButton(i)) {
				int len = String.valueOf(i).length(); 	// 해당 채널로 이동하기 위하여 눌러야하는 버튼 수 
														// ex) ch675로 이동하기 위해 각각 6, 7, 5 버튼을 눌러야 하기 때문에 총 3번
				int tempDiff = Math.abs(N - i); // 이동한 채널부터 목표 채널까지 +, -버튼 클릭 회수
				way1 = Math.min(way1, tempDiff + len);
			}
		}

		// way2 : 시작위치(ch100)부터 +, -버튼만 사용하여 이동
		int start = 100;
		int way2 = Math.abs(N - start);
		bw.write(String.valueOf(Math.min(way1, way2)));
		bw.flush();
		bw.close();
	}

	/**
	 * 해당 채널에 이동할 때, 고장난 버튼이 포함되어 있는 지 확인
	 * @param num 이동하기 위한 채널
	 * @return result 고장난 버튼이 포함되어 있다면 true를 반환
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