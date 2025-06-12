import java.io.*;
import java.util.*;

public class Main {
	static Stack<Long> s = new Stack<>();
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i < n; i++) {
			long now = sc.nextLong();
			if (now==0){
				s.pop();
			}else {
				s.push(now);
			}
		}
		long total = 0;
		while (!s.empty()){
			total+=s.pop();
		}
		System.out.println(total);
	}
}
