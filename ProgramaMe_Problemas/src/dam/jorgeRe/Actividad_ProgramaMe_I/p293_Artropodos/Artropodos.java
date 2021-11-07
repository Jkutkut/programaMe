package dam.jorgeRe.Actividad_ProgramaMe_I.p293_Artropodos;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class Artropodos {
	private static final int[] PATAS = {6, 8, 10};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		File f = new File("src/dam/jorge/p293_Artropodos/data.txt");
//		Scanner sc;
//		try {
//			sc = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return;
//		}
		
		int cases = Integer.parseInt(sc.nextLine());
		String[] valores;
		int totalPatas;
		for (int i = 0; i < cases; i++) {
			valores = sc.nextLine().split(" ");
			
			totalPatas = 0;
			for (int j = 0; j < 3; j++) {
				totalPatas += Integer.parseInt(valores[j]) * Artropodos.PATAS[j];
			}
			
			totalPatas += Integer.parseInt(valores[3]) * Integer.parseInt(valores[4]) * 2;
			System.out.println(totalPatas);
		}
		sc.close();
	}
}
