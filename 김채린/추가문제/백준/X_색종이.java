import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int w = 0;
    static int b = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sol(0, 0, n);

        System.out.println(w);
        System.out.println(b);
    }

    static void sol(int x, int y, int size) {
        if (sol2(x, y, size)) {
            if (arr[x][y] == 0) {
                w++;
            } else {
                b++;
            }
            return;
        }

        int newSize = size / 2;
        sol(x, y, newSize);
        sol(x, y + newSize, newSize);
        sol(x + newSize, y, newSize);
        sol(x + newSize, y + newSize, newSize);
    }

    static boolean sol2(int x, int y, int size) {
        int c = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
