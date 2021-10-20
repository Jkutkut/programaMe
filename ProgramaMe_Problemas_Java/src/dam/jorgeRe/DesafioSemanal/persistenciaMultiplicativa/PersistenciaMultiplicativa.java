package programaMe.jkutkut.persistenciaMultiplicativa;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Problemas Por volúmenes Volumen 1 Problema 182
 * 
 * @author jkutkut
 */
public class PersistenciaMultiplicativa {
	
	private static int multDigits(int n) {
		int result = 1;
		while (n > 0) {
			result *= n % 10;
			n /= 10;
		}
		return result;
	}
	
	private static int perMul(int n) {
		int steps = 0;
		while (n >= 10) {
			n = multDigits(n);
			steps++;
		}
		return steps;
	}

	public static void main(String[] args) {
		
//		File f = new File("src/programaMe/jkutkut/persistenciaMultiplicativa/data.txt");
//		
//		Scanner sc = new Scanner(f);
		Scanner sc = new Scanner(System.in);
		
		int nIn = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < nIn; i++) {
			int persistencia = perMul(Integer.parseInt(sc.nextLine()));
			System.out.println(persistencia);
		}
		
		sc.close();
	}

}
