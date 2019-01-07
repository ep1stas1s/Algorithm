import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> neverHeard = new TreeSet<>();
		
		// 듣도 못한 사람을 배열에 저장
		for(int i = 0; i < N; i++) {
			neverHeard.add(br.readLine());
		}
		
		// 듣도 보도 못한 사람을 저장할 TreeSet (자동 정렬) 
		Set<String> ts = new TreeSet<>();
		
		// 보도 못한사람을 듣도 못한 사람과 비교
		String neverSee;
		for(int i = 0; i < M; i++) {
			neverSee = br.readLine();
			// 듣보잡이라면 TreeSet에 추가하고, 듣도 못한 사람 명단에서 제거
			if(neverHeard.contains(neverSee)) {
				ts.add(neverSee);
				neverHeard.remove(neverSee);
			}
		}
		
		// 듣보잡 수, 이름 출력
		bw.write(String.valueOf(ts.size() + "\n"));
		Iterator<String> it = ts.iterator();
		while(it.hasNext()) {
			bw.write(it.next() + "\n");
		}
		bw.flush();
		bw.close();
	}
}