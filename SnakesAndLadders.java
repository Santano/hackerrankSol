package hackkerrank;

import java.io.*;
import java.util.*;

public class SnakesAndLadders {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int x = 0; x < n; x++) {
			String[] fin = br.readLine().split(",");
			Node[] board = new Node[101];
			Node prev = null;
			for (int i = 1; i < 101; i++) {
				Node curr = new Node(i);
				if (prev != null)
					prev.child = curr;
				prev = curr;
				board[i] = curr;
			}
			int numL = Integer.parseInt(fin[0]);
			int numS = Integer.parseInt(fin[1]);
			String[] lad = br.readLine().split(" ");
			String[] snakes = br.readLine().split(" ");
			for (int i = 0; i < numL; i++) {
				String[] s = lad[i].split(",");
				board[Integer.parseInt(s[0])].child = board[Integer
						.parseInt(s[1])];
			}
			for (int i = 0; i < numS; i++) {
				String[] s = snakes[i].split(",");
				board[Integer.parseInt(s[0])].child = board[Integer
						.parseInt(s[1])];
			}
			int dist = 1;
			Queue<Node> parentList = new LinkedList<Node>();
			Queue<Node> childList = new LinkedList<Node>();
			parentList.add(board[1]);
			Boolean complete = false;
			while (!complete) {
				while (!parentList.isEmpty()) {
					Node curr = parentList.poll();
					if (curr.child.pos == 100) {
						complete = true;
						break;
					}
					childList.add(curr.child);
				}
				parentList = childList;
				childList = new LinkedList<Node>();
				dist++;
			}
			System.out.println((int) Math.ceil((double) dist / 6));
		}
	}
}

class Node {
	public int pos;
	public Node child;

	Node(int pos) {
		this.pos = pos;
	}
}
