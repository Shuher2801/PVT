package by.pvt.electricdevice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import electricdevice.Manipulation;

/**
 * this class is the entry point. Includes a console menu for user.
 * 
 * @author Ilya
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Manipulation man = new Manipulation();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		while (true) {
			System.out
					.printf("if you want to see all of the equipment sorted by power press %28d%n",
							1);
			System.out
					.printf("if you want to see a list of equipment whose power is more than 1200 press %15d%n",
							2);
			System.out.printf(
					"if you want to plug in the equipment press %47d%n", 3);
			System.out
					.printf("if you want to calculates the power consumption of the powered equipment  press %10d%n",
							4);

			int number = Integer.parseInt(reader.readLine());

			switch (number) {
			case 1:
				man.title();
				man.writeAr(man.builder(), man.fileName);
				man.showAll(man.openAr(man.fileName));
				break;
			case 2:
				man.title();
				man.sortPower(man.builder());
				break;
			case 3:
				man.chooseTernOn(man.builder());
				break;
			case 4:
				man.calculatesPower(man.chooseTernOn(man.builder()));
				break;
			default:
			}

		}
	}
}
