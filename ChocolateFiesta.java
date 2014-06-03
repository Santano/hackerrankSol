package hackkerrank;

import java.io.*;
import java.math.*;

public class ChocolateFiesta {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		int even = 0;
		int odd = 0;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(in[i]) % 2 == 0)
				even++;
			else
				odd++;
		}
		BigInteger two = new BigInteger("2");
		BigInteger evenSets = two.pow(even);
		BigInteger oddSets = new BigInteger("1");
		if (odd != 0)
			oddSets = two.pow(odd - 1);
		evenSets = evenSets.multiply(oddSets);
		evenSets = evenSets.subtract(new BigInteger("1"));
		System.out.println(evenSets.mod(new BigInteger("1000000007")));
	}
}
