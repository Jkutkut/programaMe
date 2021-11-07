package dam.jorgeRe.y2021.nacional.p605_OrdenandoArmario;

import java.util.Scanner;

public class OrdenandoArmario {
	public static final String CHARARCTER = ".";
	
	public static final short V = 0;
	public static final short I = 1;
	public static final short A = 2;
	public static final short DOT = -1;
	
	private static short parserSeasons(String c) {
		switch(c) {
			case "V":
				return V;
			case "I":
				return I;
			case "A":
				return A;
			default:
				return DOT;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		short[] tipos = new short[2];
		
		short current;
		short prev = -1;
		
		while (true) {
			current = parserSeasons(sc.next());
//			System.out.println(current);
			if (current == DOT) {
				if (prev == DOT) {
					break;
				}
				else {
					if (tipos[V] > tipos[I]) {
						System.out.println("VERANO");
					}
					else if (tipos[V] < tipos[I]) {
						System.out.println("INVIERNO");
					}
					else {
						System.out.println("EMPATE");
					}
					
					tipos[V] = 0;
					tipos[I] = 0;
				}
			}
			
			else if(current == A) {
				tipos[V]++;
				tipos[I]++;
			}
			else {
				tipos[current]++;
			}
			prev = current;
		}
		
	}
}
