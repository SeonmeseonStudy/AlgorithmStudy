import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder S = new StringBuilder();
        int Num = sc.nextInt();
        List<Integer> Array = new ArrayList<>();
        for (int i = 0; i < Num; i++) {
            Array.add(sc.nextInt());
        }
        Collections.sort(Array);

        for (int k : Array) {
            S.append(k).append("\n");
        }
        System.out.println(S);

    }
}
