package by.pvt.electricdevice.kitchen.equipment;

/**
 * it class extends abstract class EquipmentForHouse and implements method of
 * interface ElectricDevices.
 * 
 * @author Ilya
 *
 */
public class ForProcessing extends EquipmentForKitchen {

	private int noise = 0;

	public ForProcessing(String name, int power, String color, int noise) {
		super(name, power, color);
		setNoise(noise);
	}

	public int getNoise() {
		return noise;
	}

	public void setNoise(int noise) {
		this.noise = noise;
	}

	/**
	 * this method overrides method of interface ElectricDevices
	 */
	@Override
	public void ternOn() {
		System.out.println("sensory display or button ");

	}

}
