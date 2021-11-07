package dam.jorgeRe.ProgramaMe_StarWars.p429_OrganizandoHangares;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class OrganizandoHangares {
	private static final int END = 0;
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		File f = new File("src/dam/jorgeRe/ProgramaMe_StarWars/p429_OrganizandoHangares/data.txt");
		Scanner sc;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int nHangares, nVehiculos;
		boolean running = true;
		
		int[] hangares;
		
		
		boolean inside = false;
		int i, j, v, maxIndex;
		while (running) {
			nHangares = sc.nextInt();
			
			if (nHangares == END) {
				running = false;
				break;
			}
			
			hangares = new int[nHangares];
			
			for (i = 0; i < nHangares; i++) {
				hangares[i] = sc.nextInt();
			}
			
			nVehiculos = sc.nextInt();
			
			for (i = 0; i < nVehiculos; i++) {
				inside = false;
				v = sc.nextInt();
				
				maxIndex = 0;
				for (j = 1; j < nHangares; j++) {
					if (hangares[j] > hangares[maxIndex]) {
						maxIndex = j;
					}
				}
				
				if (hangares[maxIndex] - v >= 0) {
					inside = true;
					hangares[maxIndex] -= v;
				}
				else {
					sc.nextLine();
					break;
				}
			}
			
			if (inside) { // If last v inside => all in
				System.out.println("SI");
			}
			else {
				System.out.println("NO");
			}

		}
		
		sc.close();
	}
}
