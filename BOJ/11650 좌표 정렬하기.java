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

		// ���� ����
		int n = Integer.parseInt(br.readLine());
		
		// �� �迭 ���� �� �ʱ�ȭ
		Dot[] dotArr = new Dot[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dotArr[i] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// Dot ����
		Arrays.sort(dotArr);
		
		for(int i = 0; i < n; i++){
			bw.write(dotArr[i].toString() + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}

// Dot Class ���� -> comparable �� ��ӹ���
class Dot implements Comparable<Dot>{
	int x, y;
	
	public Dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// toString�� override�Ͽ� ���ϰ� ���
	@Override
	public String toString() {
		return x + " " + y;
	}

	// Comparable��� -> compareTo (Override)
	// parameter�� ���� Dot d�� ���� Dot
	// -> this.x, this.y�� ���ο� Dot�� ��
	@Override
	public int compareTo(Dot d) {
		// this.x�� d.x���� Ŭ ��� 
		if(this.x > d.x){
			// this.x�� �� ����(1)�� 
			return 1;
		}else if(this.x == d.x) {
			if(this.y > d.y) {
				return 1;
			}
		}
		// ���� ��찡 �ƴ� ��� this.x �� �� ����(-1)��
		return -1;
		// (0�� ��� �״��)
	}
}