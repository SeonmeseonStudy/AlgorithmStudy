import java.util.*;
class Main {
    static int n;
    static int count=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sol(1, 2, 3, n);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void sol(int start, int mid, int end, int num){
        if (num==0){
            return;
        }
        sol(start,end,mid,num-1);
        count++;
        sb.append(start).append(" ").append(end).append("\n");
        sol(mid,start,end,num-1);
    }
}
