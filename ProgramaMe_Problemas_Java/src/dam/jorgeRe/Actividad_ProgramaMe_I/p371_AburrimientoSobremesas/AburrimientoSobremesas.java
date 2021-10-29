package dam.jorgeRe.Actividad_ProgramaMe_I.p371_AburrimientoSobremesas;

import java.util.Scanner;

/**
 * Problema 371
 * 
 * @author jkutkut
 */
public class AburrimientoSobremesas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int result;
		while (true) {
			n = Integer.parseInt(sc.nextLine());
			
			if (n == 0) break;
			
			result = 0;
			while (n > 0) {
				result += 3 * n--;
			}
			System.out.println(result);
		}
		sc.close();
	}
}
