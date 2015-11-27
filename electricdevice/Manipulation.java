package by.pvt.electricdevice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import electricdevice.Equipment;
import electricdevice.Loger;
import electricdevice.Main;
import by.pvt.electricdevice.house.equipment.Cleaning;
import by.pvt.electricdevice.house.equipment.ForEntertainment;
import by.pvt.electricdevice.house.equipment.OtherHouseEquipment;
import by.pvt.electricdevice.kitchen.equipment.ForCooking;
import by.pvt.electricdevice.kitchen.equipment.ForProcessing;
import by.pvt.electricdevice.kitchen.equipment.OtherKitchenEquipment;

/**
 * this class creates a list of house equipment, sorts it, allows you to
 * selectively plug the device into an outlet and calculates power consumption.
 * 
 * @author Ilya
 *
 */
public class Manipulation {
	/**
	 * this method calls the constructors with parameters, inserts them into an
	 * ArrayList and sorts in terms of power
	 * 
	 * @return array
	 */
	String fileName = "D:/java_3/core";
	String choose = "choose";
	String pressY = "pressY";
	String enterTime = "enterTime";
	String plug = "plugged in equipment";
	String name = "Name";
	String power = "Power";

	public List<Equipment> builder() {

		List<OtherKitchenEquipment> arrayOtherKitchenEquipment = new ArrayList();

		arrayOtherKitchenEquipment.add(new OtherKitchenEquipment(
				"refrigerator", 150, "silver", "not build-in"));
		arrayOtherKitchenEquipment.add(new OtherKitchenEquipment("dishwasher",
				900, "silver", "build-in"));

		List<ForCooking> arrayForCooking = new ArrayList();

		arrayForCooking.add(new ForCooking("microwave", 1700, "white", 250));
		arrayForCooking.add(new ForCooking("double boiler", 400, "black", 180));
		arrayForCooking.add(new ForCooking("electric kettle", 1200, "silver",
				100));
		arrayForCooking.add(new ForCooking("toaster", 800, "silver", 120));

		List<ForProcessing> arrayForProcessing = new ArrayList();

		arrayForProcessing.add(new ForProcessing("mixer", 350, "white", 2));
		arrayForProcessing.add(new ForProcessing("food processor", 1200,
				"silver", 3));

		List<Cleaning> arrayCleaning = new ArrayList();

		arrayCleaning.add(new Cleaning("vacuum cleaner", 1200, "Samsung",
				"dry cleaning"));
		arrayCleaning.add(new Cleaning("washer", 1000, "Samsung", "washing"));
		arrayCleaning.add(new Cleaning("iron", 250, "Tefal", "with steam"));

		List<ForEntertainment> arrayForEntertainment = new ArrayList();

		arrayForEntertainment.add(new ForEntertainment("TV", 150, "Panasonic",
				12));
		arrayForEntertainment.add(new ForEntertainment("laptop", 80, "Apple",
				10));
		arrayForEntertainment.add(new ForEntertainment("recorder ", 50,
				"Panasonic", 18));

		List<OtherHouseEquipment> arrayOtherHouseEquipment = new ArrayList();

		arrayOtherHouseEquipment.add(new OtherHouseEquipment("heater", 2000,
				"Scarlett"));
		arrayOtherHouseEquipment.add(new OtherHouseEquipment("boiler", 1200,
				"Ariston"));
		arrayOtherHouseEquipment.add(new OtherHouseEquipment("hairdtyer", 1000,
				"Scarlett"));

		List<Equipment> array = new ArrayList();
		array.addAll(arrayForProcessing);
		array.addAll(arrayForCooking);
		array.addAll(arrayOtherKitchenEquipment);
		array.addAll(arrayCleaning);
		array.addAll(arrayForEntertainment);
		array.addAll(arrayOtherHouseEquipment);

		Collections.sort(array);
		return array;
	}

	/**
	 * writes List<Equipment> array in file
	 * 
	 * @param List
	 *            <Equipment> array - list of all the equipment in the house
	 * @param String
	 *            fileName
	 */
	public void writeAr(List<Equipment> array, String fileName) {

		File dirFile = new File("D:/java_3");
		dirFile.mkdirs();
		File file = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(array);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * reads file and displays it
	 * 
	 * @param String
	 *            fileName
	 * @return
	 */
	public List<Equipment> openAr(String fileName) {
		List<Equipment> array1 = null;
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			array1 = (List<Equipment>) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return array1;
	}

	/**
	 * this method displays a list of all the equipment in the house
	 * 
	 * @param array
	 */
	public void showAll(List<Equipment> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.printf("%-18s", array.get(i).getName());
			System.out.printf("%15s%n", array.get(i).getPower());
		}
	}

	public void title() {
		System.out.printf("%-18s", Main.rb.getString(name));
		System.out.printf("%15s%n%n", Main.rb.getString(power));
	}

	/**
	 * Displays a list of equipment whose power is more than 1200
	 * 
	 * @param array
	 */
	public void sortPower(List<Equipment> array) {
		int kB = 1200;
		Iterator<Equipment> iterator = array.iterator();
		while (iterator.hasNext()) {
			Equipment srt = iterator.next();
			if (srt.getPower() > kB) {
				System.out.printf("%-18s", srt.getName());
				System.out.printf("%15s%n", srt.getPower());
			}
		}
	}

	/**
	 * Suggests to choose what equipment to plug in and outputs their list.
	 * Serially elements of the ArrayList are brought to the console and the
	 * user is offered to choose to plug in the equipment or not.To plug in it
	 * is necessary to press a letter "y", to pass a key Enter.
	 * 
	 * @param array
	 * @return chooseArray
	 * @throws IOException
	 */
	public List<Equipment> chooseTernOn(List<Equipment> array)
			throws IOException {

		System.out.println(Main.rb.getString(choose));
		System.out.println(Main.rb.getString(pressY));
		System.out.println();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		List<Equipment> chooseArray = new ArrayList();

		for (int i = 0; i < array.size(); i++) {
			Equipment srt = array.get(i);
			// srt.show();
			System.out.printf("%-18s", array.get(i).getName());
			System.out.printf("%15s%n", array.get(i).getPower());
			String s = reader.readLine();
			if (s.equals("y")) {
				chooseArray.add(srt);
			}
		}
		System.out.println(plug);
		for (int i = 0; i < chooseArray.size(); i++) {
			System.out.printf("%-18s", chooseArray.get(i).getName());
			System.out.printf("%15s%n", chooseArray.get(i).getPower());

		}
		return chooseArray;
	}

	/**
	 * calculates the power consumption of the powered equipment for a selected
	 * period of time
	 * 
	 * @param chooseArray
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void calculatesPower(List<Equipment> chooseArray) {

		System.out.println();
		System.out.println(Main.rb.getString(enterTime));
		Main.Loger.writeLog( " user entered a number");
		try {
			while (true) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
				String s = reader.readLine();
				if (s.isEmpty()) {
					System.out.println(Main.rb.getString(enterTime));
					System.out.println();
				} else {
					int time = Integer.parseInt(s);
					int count = 0;
					for (int i = 0; i < chooseArray.size(); i++) {
						int k = chooseArray.get(i).getPower() * time;
						count += k;
					}
					System.out.println(count);
					return;
				}

			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}
}