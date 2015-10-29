package by.pvt.electricdevice.kitchen.equipment;

/**
 * it class extends abstract class EquipmentForHouse and implements method of
 * interface ElectricDevices.
 * 
 * @author Ilya
 *
 */
public class OtherKitchenEquipment extends EquipmentForKitchen {

	private String buildIn = null;

	public OtherKitchenEquipment(String name, int power, String color,
			String buildIn) {
		super(name, power, color);
		setBuildIn(buildIn);
	}

	public String getBuildIn() {
		return buildIn;
	}

	public void setBuildIn(String buildIn) {
		this.buildIn = buildIn;
	}

	/**
	 * this method overrides method of interface ElectricDevices
	 */
	@Override
	public void ternOn() {
		System.out.println("sensory display ");

	}

}
