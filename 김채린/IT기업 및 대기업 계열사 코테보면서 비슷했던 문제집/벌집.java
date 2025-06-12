import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		if (n==1){
			System.out.println(1);
		}
		long result = 1;
		long count =1;
		while (n>count) {
			if (n<=result+(6*count)){
				count++;
				System.out.println(count);
				break;
			}
			result+=(6*count);
			count++;
		}
	}
}
