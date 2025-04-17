import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long result;
	static int[] people;
	static int lookA;
	static int lookB;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N];
		for (int i=0; i<N; i++) {
			people[i] = sc.nextInt();
		}
		lookA = sc.nextInt();
		lookB = sc.nextInt();
		result = N;
		for (int i = 0; i < N; i++) {
			people[i] -= lookA;
			if (people[i] > 0) {
				result+=(int) Math.ceil(people[i]/(lookB*1.0));
			}
		}
		System.out.println(result);
	}
}
