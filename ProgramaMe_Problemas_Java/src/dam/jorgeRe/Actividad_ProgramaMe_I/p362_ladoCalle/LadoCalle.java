package dam.jorgeRe.Actividad_ProgramaMe_I.p362_ladoCalle;

import java.util.Scanner;

/**
 * Ejercicio 217
 * 
 * @author Jkutkut
 */
public class LadoCalle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number;
		while (true) {
			number = Integer.parseInt(sc.nextLine());
			if (number == 0) {
				break;
			}
			else if (number % 2 == 0) {
				System.out.println("DERECHA");
			}
			else {
				System.out.println("IZQUIERDA");
			}
		}
		sc.close();
	}
}
