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
		
		// �赵 ���� ����� �迭�� ����
		for(int i = 0; i < N; i++) {
			neverHeard.add(br.readLine());
		}
		
		// �赵 ���� ���� ����� ������ TreeSet (�ڵ� ����) 
		Set<String> ts = new TreeSet<>();
		
		// ���� ���ѻ���� �赵 ���� ����� ��
		String neverSee;
		for(int i = 0; i < M; i++) {
			neverSee = br.readLine();
			// �躸���̶�� TreeSet�� �߰��ϰ�, �赵 ���� ��� ��ܿ��� ����
			if(neverHeard.contains(neverSee)) {
				ts.add(neverSee);
				neverHeard.remove(neverSee);
			}
		}
		
		// �躸�� ��, �̸� ���
		bw.write(String.valueOf(ts.size() + "\n"));
		Iterator<String> it = ts.iterator();
		while(it.hasNext()) {
			bw.write(it.next() + "\n");
		}
		bw.flush();
		bw.close();
	}
}