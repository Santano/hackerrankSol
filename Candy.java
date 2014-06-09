package hackkerrank;

import java.io.*;

public class Candy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// String[] temp = br.readLine().split(" ");
		int[] maxima = new int[n];
		int[] rank = new int[n];
		int[] candy = new int[n];
		Boolean isIncreasing = true;
		for (int i = 0; i < n; i++) {
			rank[i] = Integer.parseInt(br.readLine());
			// rank[i] = Integer.parseInt(temp[i]);
			if (i == 0)
				continue;
			Boolean isCurrIncreasing = rank[i] > rank[i - 1];
			if (isIncreasing == false && isCurrIncreasing == false) {
				maxima[i - 1] = -1;
			}
			if (isIncreasing == true && isCurrIncreasing == true) {
				maxima[i - 1] = 1;
			}
			if (isIncreasing == true && isCurrIncreasing == false) {
				maxima[i - 1] = 0;
			}
			if (isIncreasing == false && isCurrIncreasing == true) {
				maxima[i - 1] = -1;
			}
			if (i == n - 1) {
				if (isCurrIncreasing) {
					maxima[i] = 1;
				}
				if (!isCurrIncreasing) {
					maxima[i] = -1;
				}
			}
			isIncreasing = isCurrIncreasing;
		}
		int i = 0;
		int sum = 0;
		int currC = 1;
		while (i < n) {
			if (maxima[i] == 1) {
				candy[i] = currC;
				sum = sum + currC;
				try {
					if (rank[i] != rank[i + 1])
						currC++;
				} catch (Exception e) {
				}
				i++;
			} else {
				int start = i;
				i++;
				while (i < n && maxima[i] == -1) {
					i++;
				}
				int end = i - 1;
				// int tempI = i - 1;
				currC = 1;
				while (end > start) {
					candy[end] = currC;
					sum = sum + currC;
					if (rank[end] != rank[end - 1])
						currC++;
					end--;
				}
				int v1 = currC;
				int v2 = 0;
				try {
					v2 = candy[start - 1] + 1;
				} catch (Exception e) {
				}
				candy[start] = v1 > v2 ? v1 : v2;
				sum = sum + candy[start];
				currC = 2;
				// i = tempI + 1;
			}
		}
		System.out.println(sum);
	}
}
