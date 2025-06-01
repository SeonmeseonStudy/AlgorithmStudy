import java.io.*;
import java.util.*;

import javax.lang.model.type.ArrayType;

public class Main {
	static ArrayList<String> arr = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] nowS = br.readLine().split(" ");
			switch (nowS[0]) {
				case "add":
					if (!arr.contains(nowS[1])) {
						arr.add(nowS[1]);
					}
					break;
				case "remove":
					while (arr.contains(nowS[1])) {
						arr.remove(arr.indexOf(nowS[1]));
					}
					break;
				case "check":
					if (arr.contains(nowS[1])) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "toggle":
					if (arr.contains(nowS[1])) {
						while (arr.contains(nowS[1])) {
							arr.remove(arr.indexOf(nowS[1]));
						}
					} else {
						arr.add(nowS[1]);
					}
					break;
				case "all":
					arr = new ArrayList<>();
					for (int j = 1; j <= 20; j++) {
						arr.add(String.valueOf(j));
					}
					break;
				case "empty":
					arr = new ArrayList<>();
					break;
			}
		}
		System.out.println(sb);
	}
}
