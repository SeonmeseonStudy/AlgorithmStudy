import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int a = 0; a < num; a++) {
			int input = Integer.parseInt(br.readLine());
			Queue<String> queue = new LinkedList<>();
			queue.add("1");
			for (int number = 2; number <= input; number++) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					String now = queue.poll();
					queue.add(now + " " + number);
					queue.add(now + "+" + number);
					queue.add(now + "-" + number);
				}
			}
			while (!queue.isEmpty()) {
				sol(queue.poll());
			}
			System.out.println();
		}
	}

	public static void sol(String num){
		String s = num.replace(" ", "");
		String[] arr = s.split("\\+");
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			String[] a = arr[i].split("-");
			if(a.length>1){
				int result = Integer.parseInt(a[0]);
				for (int j = 1; j < a.length; j++) {
					result -= Integer.parseInt(a[j]);
				}
				total += result;
			} else {
				total += Integer.parseInt(arr[i]);
			}
		}
		if (total == 0) {
			System.out.println(num);
		}
	}
}
