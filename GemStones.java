package hackkerrank;

import java.io.*;

public class GemStones {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[26];
		int count = 0;
		for (int i = 0; i < n; i++) {
			char[] s = br.readLine().toCharArray();
			int[] arrCurr = new int[26];
			for (int j = 0; j < s.length; j++) {
				arrCurr[(int) s[j] - 97]++;
			}
			if (i == 0) {
				arr = arrCurr;
				count = s.length;
			} else {
				for (int j = 0; j < 26; j++) {
					if (arr[j] != 0 && arrCurr[j] == 0) {
						arr[j] = 0;
						count--;
					}
				}
			}
		}
		System.out.print(count);
	}
}