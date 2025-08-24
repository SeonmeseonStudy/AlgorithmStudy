import java.io.*;
import java.util.*;

public class Main {
	/*
	3
	10 12 3 9
	10 12 7 2
	13 11 5 6*/
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i=0;i<num; i++){
			int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			System.out.println(sol(n[0], n[1], n[2], n[3]));
		}
	}

	public static int sol(int M, int N, int x, int y){
		int result =x;
		int ny = y%N;
		while (result<=M*N){
			if (result%N == ny){
				return result;
			}
			result+=M;
		}
		return -1;
	}
}
