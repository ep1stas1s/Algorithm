import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		int won = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[test];
		int[] dp = new int[won + 1];
		
		for(int i = 0; i < test; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		dp[0] = 1;
		for(int i = 0; i < coin.length; i++){
			for(int j = 1; j < won + 1; j++){
				if(j - coin[i] >= 0)
					dp[j] += dp[j - coin[i]];
			}
		}
		bw.write(String.valueOf(dp[won]));
		bw.flush();
		bw.close();
    }
}