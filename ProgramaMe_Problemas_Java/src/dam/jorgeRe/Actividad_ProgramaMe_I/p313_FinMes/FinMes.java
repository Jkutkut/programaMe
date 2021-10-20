package dam.jorge.p313_FinMes;

import java.util.Scanner;

/**
 * Problema 313
 * 
 * @author Jkutkut
 */
public class FinMes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.nextLine());
		String[] valores;
		for (int i = 0; i < cases; i++) {
			valores = sc.nextLine().split(" ");
			if (Integer.parseInt(valores[0]) + Integer.parseInt(valores[1]) >= 0) {
				System.out.println("SI");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}
}
