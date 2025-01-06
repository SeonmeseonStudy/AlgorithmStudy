import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> {
            if (Math.abs(a)==Math.abs(b)){
                return a-b;
            }else {
                return Math.abs(a)-Math.abs(b);
            }
        });
        for(int i=0; i<n; i++){
            int now = sc.nextInt();
            if (now==0){
                if (q.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(q.poll());
                }
            }else {
                q.add(now);
            }
        }
    }
}
