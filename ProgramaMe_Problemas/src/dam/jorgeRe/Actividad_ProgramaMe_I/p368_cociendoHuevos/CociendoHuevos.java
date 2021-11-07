package dam.jorgeRe.Actividad_ProgramaMe_I.p368_cociendoHuevos;

import java.util.Scanner;

public class CociendoHuevos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] vals;
		int[] values = new int[2];
		while(true) {
			vals = sc.nextLine().split(" ");
			
			for (int i = 0; i < 2; i++) {
				values[i] = Integer.parseInt(vals[i]);
			}
			
			if (values[0] == 0 && values[1] == 0) break;
			
			System.out.println((int) Math.ceil((float) values[0] / values[1]) * 10);
		}
		
		sc.close();
	}
}
