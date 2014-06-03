package hackkerrank;

import java.io.*;

public class Rotation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		String[] in = br.readLine().split(" ");
		long sum_arr = 0;
		long sum_start = 0;
		for (int i = 0 ; i < n ; i++) {
			long temp = Long.parseLong(in[i]);
			sum_start = (i + 1) * temp + sum_start;
			sum_arr = sum_arr + temp;
			arr[i] = temp;
		}
		
		int curr_end = n -1;
		long sum_max = 0;
		
		while (curr_end >= 0) {
			sum_start = sum_start + sum_arr - n * arr[curr_end];
			sum_max = sum_max > sum_start ? sum_max : sum_start;
			curr_end--;
		}
		System.out.println(sum_max);
	}
}
