package dam.jorgeRe.y2021.navidad.p576_LeyendoDiccionario;

import java.util.Scanner;

public class LeyendoDiccionario {
	public static void printDate(int ss) {
		int mm = ss / 60;
		ss = ss % 60;
		
		int hh = mm / 60;
		mm = mm % 60;
		
		System.out.printf("%02d:%02d:%02d\n", hh, mm, ss);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int seg, entries;
		String[] pages;
		while(true) {
			seg = Integer.parseInt(sc.nextLine());
			if (seg == 0) break;
			
			pages = sc.nextLine().split(" ");
			entries = 0;
			for (int i = 0; i < pages.length - 1; i++) {
				entries += Integer.parseInt(pages[i]);
			}
			printDate(entries * seg);
		}
		sc.close();
	}
}
