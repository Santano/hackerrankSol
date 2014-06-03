package hackkerrank;

import java.io.*;

public class Utopian {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i++){
            int c = Integer.parseInt(br.readLine());
            int s = 1;
            Boolean b = false;
            for (int j = 0; j < c; j++){
                if (b)
                    s = s * 2;
                else
                    s = s + 1;
                b = !b;
            }
            System.out.println(s);
        }
	}
}