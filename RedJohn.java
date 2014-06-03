package hackkerrank;

import java.io.*;

public class RedJohn {
	static int[] prime = new int[217290];
	static {
		prime[0] = 1;
		prime[1] = 1;
		int half = 217290;
		for (int i = 0 ; i < half ; i++) {
			if (prime[i] == 1)
				continue;
			for (int j = i * 2; j < half; ) {
				prime[j] = 1;
				j = j + i;
			}
		}
//		int num = 100;
//		int ans = 0;
//		for (int j = 1; j <= num; j++) {
//			if (prime[j] == 0)
//				ans++;
//		}
//		System.out.println(ans);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			int[] arr = new int[x + 1];
			for (int j = 0; j <= x; j++) {
				int s1 = 1;
				int s2 = 1;
				try {
					s1 = arr[j - 1];
				} catch (Exception e) {
					s1 = 0;
				}
				try {
					s2 = arr[j - 4];
				} catch (Exception e) {
					s2 = 0;
				}
				if (s1 == 0 && s2 == 0)
					arr[j] = 1;
				else
					arr[j] = s1 + s2;
			}
			int num = arr[x];
			int ans = 0;
			for (int j = 1; j <= num; j++) {
				if (prime[j] == 0)
					ans++;
			}
			System.out.println(ans);
		}
	}
}
