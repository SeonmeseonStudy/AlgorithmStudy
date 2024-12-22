/*5 5
    1 2 3 4 5
    5 4 3 2 1
    2 3 4 5 6
    6 5 4 3 2
    1 2 1 2 1*/
import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][][] tetro = {
                {{0,0}, {0,1}, {0,2}, {0,3}}, {{0,0}, {1,0}, {2,0}, {3,0}},
                {{0,0}, {0,1}, {1,0}, {1,1}},
                {{0,0}, {1,0}, {2,0}, {2,1}}, {{0,0}, {0,1}, {0,2}, {1,0}},
                {{0,0}, {0,1}, {1,1}, {2,1}}, {{1,0}, {1,1}, {1,2}, {0,2}},
                {{0,0}, {1,0}, {1,1}, {1,2}}, {{0,0}, {0,1}, {1,0}, {2,0}},
                {{0,0}, {1,0}, {1,1}, {2,1}}, {{1,0}, {1,1}, {0,1}, {0,2}},
                {{0,1}, {1,0}, {1,1}, {2,0}}, {{0,0}, {0,1}, {1,1}, {1,2}},
                {{0,0}, {0,1}, {0,2}, {1,1}}, {{0,1}, {1,0}, {1,1}, {2,1}},
                {{1,0}, {1,1}, {1,2}, {0,1}}, {{0,0}, {1,0}, {2,0}, {1,1}}
            };

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int[][] a : tetro) {
                        int sum = 0;
                        boolean isValid = true;

                        for (int[] b : a) {
                            int x = i + b[0];
                            int y = j + b[1];

                            if (x < 0 || x >= n || y < 0 || y >= m) {
                                isValid = false;
                                break;
                            }
                            sum += arr[x][y];
                        }

                        if (isValid) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }

            System.out.println(max);
        }
    }
