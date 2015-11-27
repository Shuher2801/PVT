package electricdevice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * this class is the entry point. Includes a console menu for user.
 * 
 * @author Ilya
 *
 */
public class Main {
	static String language = "";
	static String country = "";
	public static Locale loc = new Locale(language, country);
	public static ResourceBundle rb = ResourceBundle.getBundle(
			"electricdevice/fileIntern", loc);
	public static Loger lg =  Loger.getInstance();

	public static void main(String[] args) throws IOException {
		
		
		Manipulation man = new Manipulation();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Выберите язык / select the language");
		System.out.println("English -  press 1/Русский - нажмите 2");
		// String language = "";
		// String country = "";
		String st = reader.readLine();

		int number1 = Integer.parseInt(st);

		switch (number1) {
		case 1:
			Loger.writeLog( " user pressed 1");
			language = new String("en");
			country = new String("GB");
			break;
		case 2:
			Loger.writeLog( " user pressed 2");
			language = new String("ru");
			country = new String("RU");
			break;
		default:
		}
		loc = new Locale(language, country);
		rb = ResourceBundle.getBundle("electricdevice/fileIntern", loc);

		while (true) {
			System.out.printf(rb.getString("point1"), 1);
			System.out.printf(rb.getString("point2"), 2);
			System.out.printf(rb.getString("point3"), 3);
			System.out.printf(rb.getString("point4"), 4);

			String s = reader.readLine();
			if (s.isEmpty()) {
				Loger.writeLog( " user does not enter a number");
				System.out.println("еnter");
				System.out.println();
			} else {

				int number = Integer.parseInt(s);

				switch (number) {
				case 1:
					Loger.writeLog( " user pressed 1");
					man.title();
					man.writeAr(man.builder(), man.fileName);
					man.showAll(man.openAr(man.fileName));
					break;
				case 2:
					Loger.writeLog( " user pressed 2");
					man.title();
					man.sortPower(man.builder());
					break;
				case 3:
					Loger.writeLog( " user pressed 3");
					man.chooseTernOn(man.builder());
					break;
				case 4:
					Loger.writeLog( " user pressed 4");
					man.calculatesPower(man.chooseTernOn(man.builder()));
					break;
				default:
				}
			}
		}
	}
}
