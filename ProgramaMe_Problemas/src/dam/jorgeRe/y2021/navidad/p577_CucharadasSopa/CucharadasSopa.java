package dam.jorgeRe.y2021.navidad.p577_CucharadasSopa;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class CucharadasSopa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		File f = new File("src/dam/jorgeRe/y2021/navidad/p577_CucharadasSopa/data.txt");
//		Scanner sc;
//		try {
//			sc = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return;
//		}
		
		int cases = Integer.parseInt(sc.nextLine());
		
		String[] cS;
		int minM, maxP, total;
		for (int i = 0; i < cases; i++) {
			cS = sc.nextLine().split(" ");
			minM = Integer.parseInt(cS[0]);
			maxP = Integer.parseInt(cS[1]);
			total = Integer.parseInt(cS[2]);
//			int sol = 0;
//			for (int m = minM, p = maxP; p >= 0 && m <= total; m++, p--) {
//				sol++;
//			}
//			System.out.println(sol);
			System.out.println(Math.min(total - minM + 1, maxP + 1));
		}
		sc.close();
	}
}
