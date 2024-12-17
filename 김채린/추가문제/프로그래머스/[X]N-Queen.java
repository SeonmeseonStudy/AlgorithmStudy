class Solution {
    static int result=0;
    static int num;
    public int solution(int n) {
        num=n;
        int[] arr = new int[n];
        sol(arr,0);
        return result;
    }
    public void sol(int[] arr,int count){
        if(count==num){
            result++;
            return;
        }
        for(int a=0; a<num; a++){
            arr[count]=a;
            if(sol2(arr, count)){
                sol(arr,count+1);
            }
        }
    }
    public boolean sol2(int[] arr,int count){
        for(int i=0; i<count; i++){
            if(arr[i]==arr[count]){
                return false;
            }
            if(Math.abs(i-count)==Math.abs(arr[i]-arr[count])){
                return false;
            }
        }
        return true;
    }
}
