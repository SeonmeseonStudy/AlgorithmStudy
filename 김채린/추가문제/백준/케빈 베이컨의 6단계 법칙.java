import java.util.*;
class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user = sc.nextInt();
        int relation = sc.nextInt();
        int result =Integer.MAX_VALUE;
        int resultNum =0;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>((a,b)-> {return a-b;});
        for(int i=0; i<relation; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ArrayList<Integer> list = map.getOrDefault(a,new ArrayList<>());
            list.add(b);
            map.put(a,list);
            ArrayList<Integer> list2 = map.getOrDefault(b,new ArrayList<>());
            list2.add(a);
            map.put(b,list2);
        }
        boolean[][] visited = new boolean[user+1][user+1];
        Queue<int[]> q = new LinkedList<>();
        for(int i=1; i<=user; i++){
            q.add(new int[]{i,0});
            int total =0;
            while (!q.isEmpty()){
                int[] now = q.poll();
                ArrayList<Integer> list3 = map.getOrDefault(now[0], new ArrayList<>());
                for (int friend:  list3){
                    if (!visited[i][friend]&&i!=friend){
                        total+=now[1]+1;
                        visited[i][friend]=true;
                        q.add(new int[]{friend,now[1]+1});
                    }
                }
            }
            if (result>total){
                result=total;
                resultNum=i;
            }
        }
        System.out.println(resultNum);
    }
}
