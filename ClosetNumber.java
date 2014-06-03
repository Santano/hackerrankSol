package hackkerrank;

import java.io.*;
import java.util.*;

public class ClosetNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String min_string = "";
		String[] in = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in[i]);
		Arrays.sort(arr);
		int min_diff = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			int curr_diff = Math.abs(arr[i] - arr[i + 1]);
			if (curr_diff == min_diff) {
				min_string = min_string + " " + arr[i] + " " + arr[i + 1];
			} else if (curr_diff < min_diff) {
				min_diff = curr_diff;
				min_string = arr[i] + " " + arr[i + 1];
			}
		}
		System.out.print(min_string);
	}
}