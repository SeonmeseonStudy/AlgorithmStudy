import java.util.*;

class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            if (a==0){
                if(q.isEmpty()){
                    stringBuilder.append(0);
                }else {
                    stringBuilder.append(q.poll());
                }
                stringBuilder.append("\n");
            }else {
                q.add(a);
            }
        }
        sc.close();
        System.out.println(stringBuilder.toString());
    }
}
