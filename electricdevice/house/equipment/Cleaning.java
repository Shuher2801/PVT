package by.pvt.electricdevice.house.equipment;

/**
 * it class extends abstract class EquipmentForHouse and implements method of
 * interface ElectricDevices
 * 
 *  * @author Ilya
 *
 */
public class Cleaning extends EquipmentForHouse {
	private String typeOfCleaning = null;

	public Cleaning(String name, int power, String manufacturer,
			String typeOfCleaning) {
		super(name, power, manufacturer);
		setTypeOfCleaning(typeOfCleaning);
	}

	public String getTypeOfCleaning() {
		return typeOfCleaning;
	}

	public void setTypeOfCleaning(String typeOfCleaning) {
		this.typeOfCleaning = typeOfCleaning;
	}

	/**
	 * this method overrides method of interface ElectricDevices
	 */
	@Override
	public void ternOn() {
		System.out
				.println("sensory display or button or remote control or the disc select");
	}

}
