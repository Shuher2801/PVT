package by.pvt.electricdevice.house.equipment;

/**
 * it class extends abstract class EquipmentForHouse and implements method of
 * interface ElectricDevices.
 * 
 * @author Ilya
 *
 */
public class OtherHouseEquipment extends EquipmentForHouse {

	public OtherHouseEquipment(String name, int power, String manufacturer) {
		super(name, power, manufacturer);

	}

	/**
	 * this method overrides method of interface ElectricDevices
	 */

	@Override
	public void ternOn() {
		System.out.println("sensory display or button ");

	}

}
