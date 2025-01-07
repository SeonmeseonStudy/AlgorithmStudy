import java.util.*;
/*최장 공통 부분 수열
- 최장 공통 부분 수열(Longest Common Subsequence)은 두 수열이 주어졌을 때 두 수열의 공통 부분 수열 중 가장 긴 것을 찾는 문제이다.
    - 풀이법은 다이나믹 프로그래밍을 사용한다.
    - 표를 만들어서 같으면 대각선 +1, 다르면 왼쪽과 위쪽 중 큰 값을 넣어준다.
[참고](https://st-lab.tistory.com/139)*/

class Main{
    static TreeMap<String,Integer> map = new TreeMap<>((a,b)-> b.length()-a.length());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] A = sc.nextLine().toCharArray();
        char[] B = sc.nextLine().toCharArray();
        int[][] arr = new int[B.length+1][A.length+1];
        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                int n;
                if (A[i-1]==B[j-1]){
                    n=arr[j-1][i-1]+1;
                }else {
                    n = Math.max(arr[j - 1][i], arr[j][i - 1]);
                }
                arr[j][i] =n;
            }
        }
        System.out.println(arr[B.length][A.length]);
    }
}
