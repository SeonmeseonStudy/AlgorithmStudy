import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int w = 0;
    static int b = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xArr = new int[n];
        int[] yArr = new int[n];
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < n; i++) {
            xArr[i] = sc.nextInt();
            maxX = Math.max(maxX, xArr[i]);
            yArr[i] = sc.nextInt();
            maxY = Math.max(maxY, yArr[i]);
        }
        boolean[][] arr = new boolean[maxY + 11][maxX + 11];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int y = yArr[i]; y < yArr[i] + 10; y++) {
                for (int x = xArr[i]; x < xArr[i] + 10; x++) {
                    if (!arr[y][x]) {
                        arr[y][x] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
