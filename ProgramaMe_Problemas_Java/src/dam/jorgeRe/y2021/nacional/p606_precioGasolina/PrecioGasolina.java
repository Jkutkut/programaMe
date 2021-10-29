package dam.jorgeRe.y2021.nacional.p606_precioGasolina;

import java.util.Scanner;

public class PrecioGasolina {
	public static final int END = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases;
		int current, prev, score, record = 0;
		
		while (true) {
			cases = sc.nextInt();
			System.out.println("Cases: " + cases);
			if (cases == END) {
				break;
			}
			score = 0;
			
			
			prev = sc.nextInt();
			while (cases-- > 0) {
				current = sc.nextInt();
				
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
