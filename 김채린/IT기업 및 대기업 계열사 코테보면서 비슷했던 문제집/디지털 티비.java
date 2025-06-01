import java.util.*;

import javax.lang.model.type.ArrayType;

public class Main {
	static ArrayList<String> arr = new ArrayList<>();
	static int now =0;
	static int index1 = -1;
	static int index2 = -1;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++){
			String nowS = sc.next();
			if (index1==-1&&nowS.equals("KBS1")){
				index1 = i;
			}else if (index2==-1&&nowS.equals("KBS2")){
				index2=i;
			}
			arr.add(nowS);
		}
		if (index2<index1){
			sol(index2,0);
			sol(index1,0);
		}else {
			sol(index1,0);
			sol(index2,1);
		}
	}

	public static void sol(int target, int index){
		while (target!=now){
			if (target<now){
				System.out.print("2");
				now--;
			}else {
				System.out.print("1");
				now++;
			}
		}
		while (target!=index){
			if (target<index){
				System.out.print("3");
				target++;
				now++;
			}else {
				System.out.print("4");
				target--;
				now--;
			}
		}
	}
}
