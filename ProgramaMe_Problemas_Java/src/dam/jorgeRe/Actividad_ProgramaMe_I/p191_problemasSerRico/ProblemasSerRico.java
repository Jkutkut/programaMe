package dam.jorgeRe.Actividad_ProgramaMe_I.p191_problemasSerRico;

import java.util.Scanner;

/**
 * Problema 191
 * 
 * @author jkutkut
 */
public class ProblemasSerRico {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.nextLine());
		String[] valores;
		int start, delta, result, n;
		for (int i = 0; i < cases; i++) {
			valores = sc.nextLine().split(" ");
			
			n = Integer.parseInt(valores[0]);
			start = Integer.parseInt(valores[1]);
			result = 0;
			delta = Integer.parseInt(valores[2]);
			
			for (int j = 0; j < n; j++, start-=delta) {
				result += start;
			}
			System.out.println(result);
		}
		sc.close();
	}
}
