package hackkerrank;

import java.io.*;

public class Steps {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0 ; i < t ; i++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			String[] sizeS = br.readLine().split(" ");
			String[] sizeP = br.readLine().split(" ");
			int[] pos = new int[n];
			int[] size = new int[n];
			for (int j = 0 ; j < n ; j++) {
				pos[j] = Integer.parseInt(sizeP[j]);
				size[j] = Integer.parseInt(sizeS[j]);
			}
			int steps = findNumberOfSteps(pos, size, m, n);
			System.out.println(steps);
		}
	}

	private static int findNumberOfSteps(int[] pos, int[] size, int m, int n) {
		if (m <= 0)
			return 0;
		int steps = 0;
		for (int i = 0 ; i < n ; i++) {
			int posC = pos[i];
			if (posC - 1 > 0) {
				int[] temp = pos.clone();
				steps++;
				temp[i] = pos[i] - 1;
				steps = steps + findNumberOfSteps(temp, size, m - 1, n);
			}
			if (posC + 1 <= size[i]) {
				int[] temp = pos.clone();
				temp[i] = pos[i] + 1;
				steps++;
				steps = steps + findNumberOfSteps(temp, size, m - 1, n);
			}
		}
		return steps;
	}
}
