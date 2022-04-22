import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*

BBBRWWRRRWBR
WWWWWWWWWWWW
BBBRBRBRBRBR

*/

public class Main {

	//https://codeforces.com/contest/1669/problem/D
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			char[] s = fs.next().toCharArray();
			boolean checker = true;
			for(int i = 0; i < n; i++) {
				if(s[i] != 'W') {
					int id = i;
					boolean valid = false;
					while(s[id] != 'W' && id < n) {
						if(s[id] != s[i]) {
							valid = true;
						}
						id++;
						if(id == n) {
							break;
						}
					}
					if(!valid) {
						checker = false;
						break;
					}
					i = id - 1;
				}
			}
			out.println(checker ? "YES" : "NO");
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
