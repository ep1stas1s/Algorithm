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
		
		// 입력 받음
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// (각 자리 숫자를 P제곱한)숫자를 담을 리스트
		List<Integer> list = new ArrayList<>();
		
		// 처음 A를 넣고 시작
		list.add(A);
		
		// 결과값을 저장할 변수
		int result = 0;
		
		
		for(int i = 0; i < list.size(); i++) {
			// recursion method를 통해 temp 계산
			int temp = recursion(list.get(i), P);
			
			// temp를 포함하지 않으면 list에 추가
			if(!list.contains(temp)) {
				list.add(temp);
				
			// list에 temp가 존재하지 않으면
			// 몇 번째인지 계산하여 result에 값을 넣고 break
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
	
	// 10씩 나눠주면서 나머지값을 제곱하여 각 자리수의 P제곱을 계산
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