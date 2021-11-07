package plantilla;

import java.util.Scanner;

public class HastaCasoVacio {
	public static final String CHARARCTER = ".";
	public static final int END = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases;
		boolean running = true;
		
		while (running) {
			cases = Integer.parseInt(sc.next());
			
			if (cases == END) {
				running = false;
			}
		}
		
		sc.close();
	}
}
