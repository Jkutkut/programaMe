package dam.jorgeRe.Actividad_ProgramaMe_I.p158_saltosMario;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Problema 158
 * 
 * @author jkutkut
 *
 */
public class SaltosMario {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		File f = new File("src/dam/jorge/saltosMario/data.txt");
		
//		Scanner sc;
//		try {
//			sc = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return;
//		}
		
		int cases = sc.nextInt();
		
		int nJumps, jumpsUp, jumpsDown;
		int prev, current;
		
		for (int i = 0, j; i < cases; i++) {
			nJumps = sc.nextInt();
			
			jumpsUp = 0;
			jumpsDown = 0;
			
			prev = sc.nextInt();
			for (j = 1; j < nJumps; j++) {
				current = sc.nextInt();
				
				if (prev < current) {
					jumpsUp++;
				}
				else if (prev > current) {
					jumpsDown++;
				}
				prev = current;
			}
			
			System.out.printf("%d %d\n", jumpsUp, jumpsDown);
		}
		sc.close();
	}
}