package hackkerrank;

import java.io.*;

public class SherlockAndCost {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int x = 0; x < n; x++) {
			int l = Integer.parseInt(br.readLine());
			String[] in = br.readLine().split(" ");
			long[][] d = new long[2][l];
			d[0][0] = 0;
			d[1][0] = 0;
			for (int i = 1 ; i < l ; i++) {
				int curr = Integer.parseInt(in[i]);
				int prev = Integer.parseInt(in[i-1]);
				long v1 = 0 + d[0][i-1];
				long v2 = Math.abs(prev - 1) + d[1][i-1];
				d[0][i] = v1 > v2 ? v1 : v2;
				v1 = Math.abs(curr - 1) + d[0][i-1];
				v2 = Math.abs(curr - prev) + d[1][i-1];
				d[1][i] = v1 > v2 ? v1 : v2;
			}
			long max = d[0][l-1] > d[1][l-1] ? d[0][l-1] : d[1][l-1];
			System.out.println(max);
		}
	}
}
