
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        /*
XXXOO.XXX
    XOXOXOXOX
OXOXOXOXO
    XXOOOXXOX
XO.OX...X
    .XXX.XOOO
X.OO..X..
OOXXXOOXO
    end*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine().trim();
            if (s.equals("end")){
                break;
            }
            if (sol(s)){
                System.out.println("valid");
            }else {
                System.out.println("invalid");
            }
        }
    }

    public static boolean sol(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char bingo = '.';
        for (int i = 0; i < 8; i = i + 3) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (a == b && a == c && a != '.') {
                if (bingo == '.') {
                    bingo = a;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 3);
            char c = s.charAt(i + 6);
            if (a == b && a == c && a != '.') {
                if (bingo == '.' || bingo == a) {
                    bingo = a;
                } else {
                    return false;
                }
            }
        }
        char a = s.charAt(0);
        char b = s.charAt(4);
        char c = s.charAt(8);
        if (a == b && a == c && a != '.') {
            if (bingo == '.' || bingo == a) {
                bingo = a;
            } else {
                return false;
            }
        }

        a = s.charAt(2);
        b = s.charAt(4);
        c = s.charAt(6);
        if (a == b && a == c && a != '.') {
            if (bingo == '.' || bingo == a) {
                bingo = a;
            } else {
                return false;
            }
        }
        if (bingo == 'O') {
            if (map.get('O') == map.getOrDefault('X', 0)) {
                return true;
            }
        } else if (bingo == '.') {
            if (!s.contains(".")&&map.getOrDefault('X',0) - map.getOrDefault('O',0) == 1) {
                return true;
            }
        }else {
            if (map.getOrDefault('X',0) - map.getOrDefault('O',0) == 1) {
                return true;
            }
        }
        return false;
    }
}
