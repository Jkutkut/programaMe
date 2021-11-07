package dam.jorgeRe.ProgramaMe_StarWars.p427_YoSoyTu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class YoSoyTu {
	private static final String NAME = "Luke";
	private static final String RELATION = "padre";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		File f = new File("src/dam/jorgeRe/ProgramaMe_StarWars/p427_YoSoyTu/data.txt");
//		Scanner sc;
//		try {
//			sc = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return;
//		}
		
		int cases = Integer.parseInt(sc.nextLine());
		
		String s1, s2;
		for (int i = 0; i < cases; i++) {
			s1 = sc.nextLine();
			s2 = sc.nextLine();
			
			if (s1.equals(NAME) && s2.equals(RELATION)) {
				System.out.println("TOP SECRET");
			}
			else {
				System.out.printf("%s, yo soy tu %s\n", s1, s2);
			}
		}
		
		
		sc.close();
	}
}
