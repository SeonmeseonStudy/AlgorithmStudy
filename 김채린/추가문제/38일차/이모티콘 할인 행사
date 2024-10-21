import java.util.*;
class Solution {
    static int[] sale = new int[]{40,30,20,10};
    static int[][] userInfo;
    static int[] emo;
    static int plusCount =0;
    static int totalMoney=0;
    public int[] solution(int[][] users, int[] emoticons) {
        userInfo = users;
        emo=emoticons;
        sol(0,new int[emoticons.length]);
        return new int[]{plusCount,totalMoney};
    }

    public void sol(int count, int[] result){
        if (count==emo.length){
            int nowCount =0;
            int nowMoney=0;
            for(int[] user: userInfo){
                int total =0;
                for (int i=0; i< result.length; i++){
                    if (user[0]<=result[i]){
                   total += emo[i]*((double)(100-result[i])/100);
                }
            }
                if (total>=user[1]){
                    nowCount++;
                }else {
                    nowMoney += total;
                }
            }
            if (plusCount<nowCount){
                plusCount=nowCount;
                totalMoney=nowMoney;
            }else if(plusCount==nowCount){
                if (totalMoney<nowMoney){
                    totalMoney=nowMoney;
                }
            }
            return;
        }
        for (int i=0; i<4; i++){
            result[count]=sale[i];
            sol(count+1,result);
        }
    }
}
