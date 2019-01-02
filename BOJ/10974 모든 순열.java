import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N;					// input
	static ArrayList<Integer> list;	// 1 ~ N ���� ������ list
	static int[] result;			// �ӽ÷� ������ ������ �迭
	
	public static void main(String[] args) {
		// Initialization
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		list = new ArrayList<>();
		result = new int[N];
		
		// 1 ~ N ����
		for(int i = 0; i < N; i++) {
			list.add(i + 1);
		}
		
		// depth = 0 ���� ����
		dfs(0);
		
		scanner.close();
	}

	static void dfs(int depth) {
		// depth == N �� ��� ���
		if(depth == N) {
			// Print Result(Array)
			for(int i = 0; i < N; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// result �迭�� ���� �����ϸ鼭 list�� ���� remove/add (Recursion)
		for(int i = 0; i < N - depth; i++) {
			result[depth] = list.remove(i);
			dfs(depth + 1);
			list.add(i, result[depth]);
		}
	}
}