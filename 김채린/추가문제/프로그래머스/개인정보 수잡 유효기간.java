import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[][] termArr = new String[terms.length][2];
        for(int i=0; i<terms.length; i++){
            termArr[i] = terms[i].split(" ");
        }
        ArrayList<Integer> result = new ArrayList<>();
        int[] todayArr = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<privacies.length; i++){
            String[] date = privacies[i].split("\\.");
            String[] dateAndTerm = date[2].split(" ");
            int expirationPeriod =0;
            int[] expirationDateArr = new int[3];
            expirationDateArr[0] = Integer.parseInt(date[0]);
            expirationDateArr[1] = Integer.parseInt(date[1]);
            expirationDateArr[2] = Integer.parseInt(dateAndTerm[0]);
            for(String[] t: termArr){
                if(t[0].equals(dateAndTerm[1])){
                    expirationPeriod = Integer.parseInt(t[1]);
                    break;
                }
            }
            expirationDateArr[2]--;
            if(expirationDateArr[2]==0){
                expirationDateArr[2]=28;
                expirationDateArr[1]--;
            }
            expirationDateArr[1]+=expirationPeriod;
            while (expirationDateArr[1]>12){
                expirationDateArr[1]-=12;
                expirationDateArr[0]++;
            }
            boolean isExpire = false;
            for(int j=0; j<3; j++){
                if(todayArr[j]>expirationDateArr[j]){
                    isExpire = true;
                    break;
                }else if(todayArr[j]<expirationDateArr[j]){
                    break;
                }
            }
            if(isExpire){
                result.add(i+1);
            }
        }
        int[] resultArr = new int[result.size()];
        int count=0;
        for(int i: result){
            resultArr[count] = i;
            count++;
        }
        return resultArr;
    }
}
