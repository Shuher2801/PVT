package electricdevice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public class Loger {
	private static Loger instance;
	static File logFile = new File("D:/logFile");
	String logMessage;

	private Loger() {
	}

	public static Loger getInstance() {
		if (instance == null) {
			instance = new Loger();
		}
		return instance;
	}

	public static void writeLog(String logMessage) {
		FileWriter fw;
		PrintWriter pr = null;
		Date currentTime = new Date();
		DateFormat dt = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Main.loc); 
		try {
			pr = new PrintWriter(new BufferedWriter(new FileWriter(logFile,
					true)));
			pr.println(dt.format(currentTime) + " - " + logMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pr.flush();
		pr.close();

	}
}