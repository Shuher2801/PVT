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

	public List<Equipment> builder() {

		List<OtherKitchenEquipment> arrayOtherKitchenEquipment = new ArrayList<OtherKitchenEquipment>();

		arrayOtherKitchenEquipment.add(new OtherKitchenEquipment(
				"refrigerator", 150, "silver", "not build-in"));
		arrayOtherKitchenEquipment.add(new OtherKitchenEquipment("dishwasher",
				900, "silver", "build-in"));

		List<ForCooking> arrayForCooking = new ArrayList<ForCooking>();

		arrayForCooking.add(new ForCooking("microwave", 1700, "white", 250));
		arrayForCooking.add(new ForCooking("double boiler", 400, "black", 180));
		arrayForCooking
				.add(new ForCooking("electric kettle", 1200, "silver", 100));
		arrayForCooking.add(new ForCooking("toaster", 800, "silver", 120));

		List<ForProcessing> arrayForProcessing = new ArrayList<ForProcessing>();

		arrayForProcessing.add(new ForProcessing("mixer", 350, "white", 2));
		arrayForProcessing.add(new ForProcessing("food processor", 1200,
				"silver", 3));

		List<Cleaning> arrayCleaning = new ArrayList<Cleaning>();

		arrayCleaning.add(new Cleaning("vacuum cleaner", 1200, "Samsung",
				"dry cleaning"));
		arrayCleaning.add(new Cleaning("washer", 1000, "Samsung", "washing"));
		arrayCleaning.add(new Cleaning("iron", 250, "Tefal", "with steam"));

		List<ForEntertainment> arrayForEntertainment = new ArrayList<ForEntertainment>();

		arrayForEntertainment
				.add(new ForEntertainment("TV", 150, "Panasonic", 12));
		arrayForEntertainment.add(new ForEntertainment("laptop", 80, "Apple",
				10));
		arrayForEntertainment.add(new ForEntertainment("recorder ", 50,
				"Panasonic", 18));

		List<OtherHouseEquipment> arrayOtherHouseEquipment = new ArrayList<OtherHouseEquipment>();

		arrayOtherHouseEquipment.add(new OtherHouseEquipment("heater", 2000,
				"Scarlett"));
		arrayOtherHouseEquipment.add(new OtherHouseEquipment("boiler", 1200,
				"Ariston"));
		arrayOtherHouseEquipment.add(new OtherHouseEquipment("hairdtyer", 1000,
				"Scarlett"));

		List<Equipment> array = new ArrayList<Equipment>();
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
		File file = new File(dirFile.getAbsolutePath() + "/" + fileName);

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

		Iterator<Equipment> iterator = array.iterator();
		while (iterator.hasNext()) {
			iterator.next().show();
		}
	}
	public void title(){
		System.out.printf("%-18s", "Name");
		System.out.printf("%15s%n%n", "Power");
	}

	/**
	 * this method displays a list of equipment whose power is more than 150
	 * 
	 * @param array
	 */
	public void sortPower(List<Equipment> array) {
		Iterator<Equipment> iterator = array.iterator();
		while (iterator.hasNext()) {
			Equipment srt = iterator.next();
			if (srt.getPower() > 1200 )
				srt.show();
		}
	}

	/**
	 * This method suggests to choose what equipment to plug in and outputs
	 * their list. Serially elements of the ArrayList are brought to the console
	 * and the user is offered to choose to plug in the equipment or not.To plug
	 * in it is necessary to press a letter "y", to pass a key Enter.
	 * 
	 * @param array
	 * @return chooseArray
	 * @throws IOException
	 */
	public List<Equipment> chooseTernOn(List<Equipment> array)
			throws IOException {

		System.out.println("choose to plug in the equipment or not.");
		System.out
				.println("If you want to plug in it  to press a letter \"y\", to pass a key Enter.");
		System.out.println();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		List<Equipment> chooseArray = new ArrayList<Equipment>();

		for (int i = 0; i < array.size(); i++) {
			Equipment srt = array.get(i);
			srt.show();
			String s = reader.readLine();
			if (s.equals("y")) {
				chooseArray.add(srt);
			}
		}
		System.out.println("plugged in equipment");
		for (int i = 0; i < chooseArray.size(); i++) {
			chooseArray.get(i).show();
		}
		return chooseArray;
	}

	/**
	 * this method calculates the power consumption of the powered equipment for
	 * a selected period of time
	 * 
	 * @param chooseArray
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void calculatesPower(List<Equipment> chooseArray) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println();
		System.out.println("Enter time of working");
		try {
			int time = Integer.parseInt(reader.readLine());

			int count = 0;
			for (int i = 0; i < chooseArray.size(); i++) {
				int kWh = chooseArray.get(i).getPower() * time;
				count += kWh;
			}
			System.out.println(count + " kWh");
		}catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}
}