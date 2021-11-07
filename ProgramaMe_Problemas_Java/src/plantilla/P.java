package plantilla;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		File f = new File("src/dam/jorgeRe//p_/data.txt");
		Scanner sc;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int cases = Integer.parseInt(sc.nextLine());
		
		
		sc.close();
	}
}
