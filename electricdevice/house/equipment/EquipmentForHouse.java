package by.pvt.electricdevice.house.equipment;

import by.pvt.electricdevice.Equipment;

/**
 * It abstract class extends abstract class Equipment.
 * 
 * @author Ilya
 *
 */
public abstract class EquipmentForHouse extends Equipment {

	private String manufacturer = null;

	public EquipmentForHouse(String name, int power, String manufacturer) {
		super(name, power);
		setManufacturer(manufacturer);
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
