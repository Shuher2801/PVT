package by.pvt.electricdevice.kitchen.equipment;

import by.pvt.electricdevice.Equipment;
import by.pvt.electricdevice.ElectricDevices;

/**
 * it abstract class extends abstract class Equipment.
 * 
 * @author Ilya
 *
 */
public abstract class EquipmentForKitchen extends Equipment implements
		ElectricDevices {

	private String color = null;

	public EquipmentForKitchen(String name, int power, String color) {
		super(name, power);
		setColor(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
