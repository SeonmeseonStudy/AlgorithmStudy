import java.util.*;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : scoville) {
            heap.add(num);
        }
        while (heap.size()>1) {
            if (heap.peek()>=K){
                return answer;
            }
            answer++;
            int n = heap.poll() + heap.poll() * 2;
            heap.add(n);
        }
        return heap.peek()>=K? answer: -1;
    }
}
