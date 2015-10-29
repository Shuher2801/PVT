package by.pvt.electricdevice.house.equipment;

/**
 * it class extends abstract class EquipmentForHouse and implements method of
 * interface ElectricDevices.
 * 
 * @author Ilya
 *
 */
public class ForEntertainment extends EquipmentForHouse {

	private int sound = 0;

	public ForEntertainment(String name, int power, String manufacturer,
			int sound) {
		super(name, power, manufacturer);
		setSound(sound);
	}

	public int getSound() {
		return sound;
	}

	public void setSound(int sound) {
		this.sound = sound;
	}

	/**
	 * this method overrides method of interface ElectricDevices
	 */

	@Override
	public void ternOn() {
		System.out.println("sensory display  or remote control ");

	}

}
