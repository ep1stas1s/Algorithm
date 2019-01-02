import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N;					// input
	static ArrayList<Integer> list;	// 1 ~ N 값을 저장할 list
	static int[] result;			// 임시로 순열을 저장할 배열
	
	public static void main(String[] args) {
		// Initialization
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		list = new ArrayList<>();
		result = new int[N];
		
		// 1 ~ N 저장
		for(int i = 0; i < N; i++) {
			list.add(i + 1);
		}
		
		// depth = 0 부터 시작
		dfs(0);
		
		scanner.close();
	}

	static void dfs(int depth) {
		// depth == N 일 경우 출력
		if(depth == N) {
			// Print Result(Array)
			for(int i = 0; i < N; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// result 배열에 값을 저장하면서 list의 값을 remove/add (Recursion)
		for(int i = 0; i < N - depth; i++) {
			result[depth] = list.remove(i);
			dfs(depth + 1);
			list.add(i, result[depth]);
		}
	}
}