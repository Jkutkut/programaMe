package dam.jorgeRe.y2021.navidad.p578_HaciendoInventario;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class HaciendoInventario {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		File f = new File("src/dam/jorgeRe/y2021/navidad/p578_HaciendoInventario/data.txt");
//		Scanner sc;
//		try {
//			sc = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return;
//		}
		
		int cases, i;
		HashSet<String> h;
		while(true) {
			
			cases = Integer.parseInt(sc.nextLine());
			if (cases == 0) {
				break;
			}
			
			h  = new HashSet<String>();
			
			for (i = 0; i < cases; i++) {
				h.add(sc.nextLine().toLowerCase());
			}
			
			System.out.println(h.size());
		}
		sc.close();
	}
}