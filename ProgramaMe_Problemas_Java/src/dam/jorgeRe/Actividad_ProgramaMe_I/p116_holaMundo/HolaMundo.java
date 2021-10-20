package dam.jorge.p116_holaMundo;

import java.util.Scanner;

/**
 * Programa 116
 * 
 * @author jkutkut
 */
public class HolaMundo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		byte n = sc.nextByte();
		for (byte i = 0b0; i < n; i++) {
			System.out.println("Hola mundo.");
		}
		sc.close();
	}
}
