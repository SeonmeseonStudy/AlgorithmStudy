class Solution {
    int result=0;
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        for (int i=0; i<arr.length-2; i++){
            int[] output = new int[3];
            output[0]=arr[i];
            sol(output,1,i,arr,a,b,c);
        }
        return result;
    }

    public void sol(int[] output, int count, int beforeIndex, int[] arr, int a, int b, int c){
        if (count==3){
            result++;
            return;
        }
        for (int i=beforeIndex+1; i<arr.length; i++){
            output[count]=arr[i];
            if(count==1) {
                if (Math.abs(output[count] - output[count-1]) <= a) {
                    sol(output, count + 1, i, arr, a, b, c);
                }
            }else {
                if (Math.abs(output[count] - output[count-1]) <= b && Math.abs(output[count-2] - output[count]) <= c) {
                    sol(output, count + 1, i,arr, a, b, c);
                }
            }
        }
    }
}
