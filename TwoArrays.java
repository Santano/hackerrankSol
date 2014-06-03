package hackkerrank;

import java.io.*;
import java.util.*;

public class TwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            String[] in = br.readLine().split(" ");
            int size = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            int[] arr1 = new int[size];
            int[] arr2 = new int[size];
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            for (int j = 0 ; j < size; j++) {
                arr1[j] = Integer.parseInt(s1[j]);
                arr2[j] = Integer.parseInt(s2[j]);
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            Boolean d = true;
            int j = 0;
            int l = size - 1;
            for (; j < size - 1 && l >= 0 ; ) {
            	if (arr1[j] + arr2[l] < k)
            	{
            		d = false;
            		break;
            	}
            	j++;
            	l--;
            }
            if (d)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}