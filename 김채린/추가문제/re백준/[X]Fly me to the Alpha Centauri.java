import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = now[0];
            int y = now[1];
            int len = y-x;
            int index = 0;
            int cnt = 0;

            while(true) {
                index++;
                int standardSec = len - index*2;
                if(standardSec == 0) {
                    cnt+=2;
                    break;
                }else if(standardSec > 0) {
                    len = standardSec;
                    cnt+=2;
                }else {
                    int standardOne = len - index;
                    if(standardOne <= 0) {
                        cnt+=1;
                        break;
                    }else {
                        cnt+=2;
                        break;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
