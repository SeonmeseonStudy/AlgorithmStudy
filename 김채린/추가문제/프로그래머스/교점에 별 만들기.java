import java.util.*;

// 검색 풀이 허점이 너무 많았음
class Solution {
    public String[] solution(int[][] line) {
        ArrayList<long[]> arrayList = new ArrayList<>();
        long maxX=Integer.MIN_VALUE;
        long maxY=Integer.MIN_VALUE;
        long minX=Integer.MAX_VALUE;
        long minY=Integer.MAX_VALUE;
        for(int i=0; i<line.length; i++){
            long a= line[i][0];
            long b= line[i][1];
            long e= line[i][2];
            for(int j=i+1; j<line.length; j++){
                long c= line[j][0];
                long d= line[j][1];
                long f= line[j][2];

                long adbc= a*d-b*c;
                if(adbc==0) continue;

                long bfed= b*f-e*d;
                if(bfed%adbc!=0) continue;

                long ecaf= e*c-a*f;
                if(ecaf%adbc!=0) continue;

                long x= bfed/adbc;
                long y= ecaf/adbc;
                arrayList.add(new long[]{x,y});

                maxX = Math.max(x,maxX);
                maxY = Math.max(y,maxY);
                minX = Math.min(x,minX);
                minY = Math.min(y,minY);
            }
        }
        long h = maxY-minY;
        long w = maxX-minX;
        String[] result = new String[(int)h+1];
        String s="";
        for (int i=0; i<=w; i++){
            s+=".";
        }
        Arrays.fill(result,s);
        for (int i=0; i<arrayList.size(); i++){
            long newY = maxY-arrayList.get(i)[1];
            long newX = arrayList.get(i)[0]-minX;
            result[(int) newY]= result[(int) newY].substring(0, (int) newX)+"*"
                +result[(int) newY].substring((int) newX +1);
        }
        return result;
    }
}
