package dam.jorgeRe.y2021.nacional.p604_HonorDistribucion;

import java.util.Scanner;

public class HonorDistribucion {
	
	private static final short CARTAS_REPARTIDAS = 13;
	
	private static final short CORAZONES = 0;
	private static final short DIAMANTES = 1;
	private static final short PICAS = 2;
	private static final short TREBOLES = 3;
	
	private static final short AS = 4;
	private static final short JACK = 1;
	private static final short QUEEN = 2;
	private static final short KING = 3;
	
	private static int getNumberPoint(String cardNumber) {
		switch (cardNumber) {
			case "Q": 
				return QUEEN;
			case "K":
				return KING;
			case "J":
				return JACK;
			case "A":
				return AS;
			default:
				return 0;
//				return Integer.parseInt(cardNumber);
		}
	}
	
	
	private static int getType(String cardType) {
		switch (cardType) {
			case "C":
				return CORAZONES;
			case "D":
				return DIAMANTES;
			case "P":
				return PICAS;
			case "T":
				return TREBOLES;
			default:
				throw new IllegalArgumentException("Unexpected value: " + cardType);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.nextLine());
		int[] tipos;
		int puntos;
		
		for (int i = 0, j; i < cases; i++) {
			puntos = 0;
			tipos = new int[4];
			
			for (j = 0; j < CARTAS_REPARTIDAS; j++) {
				puntos += getNumberPoint(sc.next());
				tipos[getType(sc.next())]++;
			}
			
			for (j = 0; j < 4; j++) {
				switch (tipos[j]) {
					case 0:
						puntos += 3; // void
						break;
					case 1:
						puntos += 2; // singleton
						break;
					case 2:
						puntos += 1; // doubleton
						break;
				}
			}
			
			System.out.println(puntos);
		}
		sc.close();
	}
}
