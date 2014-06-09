package hackkerrank;

import java.io.*;

public class MaxStocks {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int a = 0 ; a < n ; a++) {
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] in = new int[len];
			int[] maxA = new int[len];
			int max = Integer.MIN_VALUE;
			long sum = 0;
//			int sum = 0;
			for (int i = len - 1; i >= 0 ; i--) {
				int curr = Integer.parseInt(s[i]);
				in[i] = curr;
				if (curr > max) {
					maxA[i] = -1;
					max = curr;
				}
				else {
					maxA[i] = max;
					sum = sum + max - curr;
				}
			}
			System.out.println(sum);
		}
	}
}
