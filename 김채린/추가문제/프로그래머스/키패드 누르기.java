import java.util.*;
class Solution {
    static int[] left =new int[]{3,0};
    static int[] right =new int[]{3,2};
    static StringBuilder sb = new StringBuilder();
    static int handNum = 0;
    public String solution(int[] numbers, String hand) {
        if(hand.equals("left")){
            handNum =1;
        }
        for(int a: numbers){
            switch(a){
                case 1:
                case 4:
                case 7:
                    left=sol(a);
                    sb.append("L");
                    break;
                case 3:
                case 6:
                case 9:
                    right=sol(a);
                    sb.append("R");
                    break;
                default :
                    move(sol(a));
                    break;
            }
        }
        return sb.toString();
    }

    public int[] sol(int num){
        int a=0;
        int b=0;
        if(num<2){
            if(num==0){
                a=3;
                b=1;
            }
        }else{
        int now = num-1;
        if(now>0){
            a= now/3;
            b=now%3;
        }
        }
        return new int[]{a,b};
    }

    public void move(int[] point){
        int leftCount = Math.abs(left[0]-point[0])+Math.abs(left[1]-point[1]);
        int rightCount = Math.abs(right[0]-point[0])+Math.abs(right[1]-point[1]);
        if(leftCount==rightCount){
            if(handNum==1){
                left = point;
                sb.append("L");
            }else{
                right= point;
                sb.append("R");
            }
        }else if(rightCount>leftCount){
            left = point;
            sb.append("L");
        }else{
            right= point;
            sb.append("R");
        }
    }
}
