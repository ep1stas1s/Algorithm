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

		// 점의 개수
		int n = Integer.parseInt(br.readLine());
		
		// 점 배열 선언 및 초기화
		Dot[] dotArr = new Dot[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dotArr[i] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// Dot 정렬
		Arrays.sort(dotArr);
		
		for(int i = 0; i < n; i++){
			bw.write(dotArr[i].toString() + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}

// Dot Class 생성 -> comparable 을 상속받음
class Dot implements Comparable<Dot>{
	int x, y;
	
	public Dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// toString을 override하여 편하게 출력
	@Override
	public String toString() {
		return x + " " + y;
	}

	// Comparable상속 -> compareTo (Override)
	// parameter로 받은 Dot d는 비교할 Dot
	// -> this.x, this.y와 새로운 Dot를 비교
	@Override
	public int compareTo(Dot d) {
		// this.x가 d.x보다 클 경우 
		if(this.x > d.x){
			// this.x를 앞 순서(1)로 
			return 1;
		}else if(this.x == d.x) {
			if(this.y > d.y) {
				return 1;
			}
		}
		// 위의 경우가 아닐 경우 this.x 를 뒷 순서(-1)로
		return -1;
		// (0일 경우 그대로)
	}
}