import java.util.*;
class Solution {
    static HashMap<String,ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        for(int i=0; i<info.length; i++){
            String[] arr = info[i].split(" ");
            make(arr,0,"");
        }
        for (String s: map.keySet()){
            ArrayList<Integer> arrayList = map.get(s);
            arrayList.sort((a,b)->a-b);
        }

        int[] result = new int[query.length];
        for(int i=0; i<query.length; i++){
            String[] queryArr = query[i].replace(" and","").split(" ");
            ArrayList<Integer> arrayList= map.get(queryArr[0]+queryArr[1]+queryArr[2]+queryArr[3]);
            if (arrayList==null){
                result[i]=0;
            }else {
                result[i] = search(arrayList,Integer.parseInt(queryArr[4]));
            }
        }

        return result;
    }

    public int search(ArrayList<Integer> arr, int num){
        int start =0;
        int end=arr.size()-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (arr.get(mid)<num){
                start=mid+1;
            }else {
                end = mid-1;
            }
        }
        return arr.size()-start;
    }
    public void make(String[] s, int count, String result){
        if (count==4){
            ArrayList<Integer> arr = map.getOrDefault(result,new ArrayList<>());
            arr.add(Integer.parseInt(s[4]));
            map.put(result,arr);
            return;
        }
        make(s,count+1, result+s[count]);
        make(s, count+1, result+"-");
    }
}
