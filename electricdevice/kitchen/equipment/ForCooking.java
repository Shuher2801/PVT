package by.pvt.electricdevice.kitchen.equipment;

/**
 * it class extends abstract class EquipmentForHouse and implements method of
 * interface ElectricDevices.
 * 
 * @author Ilya
 *
 */
public class ForCooking extends EquipmentForKitchen {

	private int max_Temperature = 0;

	public ForCooking(String name, int power, String color, int max_Temperature) {
		super(name, power, color);
		setMax_Temperature(max_Temperature);
	}

	public int getMax_Temperature() {
		return max_Temperature;
	}

	public void setMax_Temperature(int max_Temperature) {
		this.max_Temperature = max_Temperature;
	}

	/**
	 * this method overrides method of interface ElectricDevices
	 */
	@Override
	public void ternOn() {
		System.out.println(" button ");

	}

}
