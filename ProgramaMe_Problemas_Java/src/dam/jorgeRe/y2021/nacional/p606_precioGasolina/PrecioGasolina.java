package dam.jorgeRe.y2021.nacional.p606_precioGasolina;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrecioGasolina {
	public static final int END = 0;
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		File f = new File("src/dam/jorgeRe/y2021/nacional/p606_precioGasolina/data.txt");
		Scanner sc;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int cases;
		int current, prev, score, record = 0;
		
		while (true) {
			cases = sc.nextInt();
			System.out.println("Cases: " + cases);
			if (cases == END) {
				break;
			}
			score = 0;
			record = 0;
			
			
			prev = sc.nextInt();
			while (cases-- > 1) {
				current = sc.nextInt();
				
				System.out.println("Checking " + current);
				
				if (prev <= current) {
					score++;
				}
				else {
					if (score > record) {
						record = score;
					}
					score = 0;
				}
				
				prev = current;
			}
			
			if (score > record) {
				record = score;
			}
			
			System.out.println(record);
		}
		
		sc.close();
	}

}
