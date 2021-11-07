package dam.jorgeRe.ProgramaMe_StarWars.p428_TendenciaLadoOscuro;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class TendenciaLadoOscuro {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		File f = new File("src/dam/jorgeRe/ProgramaMe_StarWars/p428_TendenciaLadoOscuro/data.txt");
//		Scanner sc;
//		try {
//			sc = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return;
//		}
		
		int cases = Integer.parseInt(sc.nextLine());
		
		String n;
		int amount;
		
		for (int i = 0, j; i < cases; i++) {
			n = Integer.toString(Integer.parseInt(sc.nextLine()), 5);
			amount = 0;
			for (j = 0; j < n.length(); j++) {
				if (n.charAt(j) == '4') {
					amount++;
				}
			}
			
			if (amount > 1) {
				System.out.println("SI");
			}
			else {
				System.out.println("NO");
			}
		}
		
		sc.close();
	}
}
