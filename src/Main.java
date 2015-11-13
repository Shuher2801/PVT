import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		MyThread a1 = new MyThread();
		MyThread a2 = new MyThread();
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String s = reader.readLine();
			if (s.equals("start")) {
				a1.start();
				a2.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void show10() {
	
		for (int i = 1; i <= 100; i++) {
			if (i == 1) {
				System.out.print(Thread.currentThread().getName() + " - ");
			}
			System.out.print(i + " ");
			if (i % 10 == 0 && i != 100) {
				System.out.println();
				System.out.print(Thread.currentThread().getName() + " - ");
			}
		}
		System.out.println();
	}

}
