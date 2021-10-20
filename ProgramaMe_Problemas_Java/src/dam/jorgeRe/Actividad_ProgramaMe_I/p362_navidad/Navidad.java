package dam.jorge.p362_navidad;

import java.util.Scanner;

/**
 * Problema 362
 * @author jkutkut
 *
 */
public class Navidad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.nextLine());
		
		String[] valores;
		for (int i = 0; i < cases; i++) {
			valores = sc.nextLine().split(" ");
			if (Integer.parseInt(valores[0]) == 25 && Integer.parseInt(valores[1]) == 12) {
				System.out.println("SI");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}
}
