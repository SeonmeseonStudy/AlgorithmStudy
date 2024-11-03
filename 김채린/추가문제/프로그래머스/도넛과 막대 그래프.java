import java.util.*;
import java.io.*;
class Solution {

    public static void main(String[] args) {
        Solution s =new Solution();
        s.solution(new int[][]{{4, 11},{1, 12},{8, 3},{12, 7},{4, 2},{7, 11},{4, 8},{9, 6},{10, 11},{6, 10},{3, 5},{11, 1},{5, 3},{11, 9},{3, 8}});
    }
    static int[] result = new int[]{0,0,0,0};
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int  max=0;
    public int[] solution(int[][] edges) {
        boolean[] isRoot = new boolean[1000000];
        Arrays.fill(isRoot,true);
        HashSet<Integer> nodes = new HashSet<>();
        for(int i=0; i<edges.length; i++){
            ArrayList<Integer> arr = map.getOrDefault(edges[i][0],new ArrayList<>());
            nodes.add(edges[i][1]);
            nodes.add(edges[i][0]);
            arr.add(edges[i][1]);
            isRoot[edges[i][1]] = false;
            map.put(edges[i][0],arr);
            max = Math.max(max,edges[i][0]);
            max = Math.max(max,edges[i][1]);
        }
        int root =0;
        for(int i:nodes){
            if (isRoot[i]&&map.get(i).size()>1){
                root =i;
            }
        }
        result[0]=root;
        sol(root);
        return result;
    }

    public void sol(int root){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> now = map.get(root);
        for(int a: now){
            q.add(a);
        }
        boolean[] visited = new boolean[max+1];
        while (!q.isEmpty()){
            int nowNum = q.poll();
            if(visited[nowNum]){
                result[1]++;
                continue;
            }
            now = map.get(nowNum);
            if(now==null){
                result[2]++;
                continue;
            }
            if (now.size()>1){
                result[3]++;
                continue;
            }
            visited[nowNum]=true;
            q.add(now.get(0));
        }
    }
}
