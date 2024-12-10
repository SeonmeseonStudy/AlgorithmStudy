import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<HashMap<Integer,TreeMap<String, Integer>>> wait = new ArrayList<>();
        int now;
        for (int i = 0; i < nums[0]; i++) {
            String[] arr = br.readLine().split(" ");
            if (wait.isEmpty()) {
                HashMap<Integer, TreeMap<String, Integer>> map = new HashMap<>();
                TreeMap<String, Integer> start = new TreeMap<>();
                now = Integer.parseInt(arr[0]);
                start.put(arr[1], now);
                map.put(now, start);
                wait.add(map);
            } else {
                boolean in = false;
                for (HashMap<Integer, TreeMap<String, Integer>> list : wait) {
                    for (int key : list.keySet()) {
                        if (list.get(key).size() == nums[1]) {
                            break;
                        }
                        if (Math.abs(Integer.parseInt(arr[0]) - key) <= 10) {
                            list.get(key).put(arr[1], Integer.parseInt(arr[0]));
                            in = true;
                            break;
                        }
                    }
                    if (in){
                        break;
                    }
                }
                if (!in) {
                    HashMap<Integer, TreeMap<String, Integer>> map = new HashMap<>();
                    TreeMap<String, Integer> start = new TreeMap<>();
                    now = Integer.parseInt(arr[0]);
                    start.put(arr[1], now);
                    map.put(now, start);
                    wait.add(map);
                }
            }
        }
            for (HashMap<Integer, TreeMap<String, Integer>> list : wait) {
                for (int key : list.keySet()) {
                    if (list.get(key).size() == nums[1]) {
                        System.out.println("Started!");
                    } else {
                        System.out.println("Waiting!");
                    }
                    for (String strings : list.get(key).keySet()) {
                        System.out.println(list.get(key).get(strings) + " " + strings);
                    }
                }
            }
    }
}
