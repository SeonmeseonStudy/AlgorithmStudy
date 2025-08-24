import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int total = 0;
		for(int i=0; i<a; i=i+N+1){
			for (int j=0; j<b; j+=M+1){
				total++;
			}
		}
		System.out.println(total);
	}
}
