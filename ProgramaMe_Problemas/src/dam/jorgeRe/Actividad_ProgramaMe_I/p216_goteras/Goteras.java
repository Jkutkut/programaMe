package dam.jorgeRe.Actividad_ProgramaMe_I.p216_goteras;

import java.util.Scanner;

public class Goteras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.nextLine());
		int hh, mm, ss;
		for (int i = 0; i < cases; i++) {
			ss = Integer.parseInt(sc.nextLine());
			
			mm = ss / 60;
			ss = ss % 60;
			
			hh = mm / 60;
			mm = mm % 60;
			
			System.out.printf("%02d:%02d:%02d\n", hh, mm, ss);
		}
		sc.close();

	}

}
