package by.pvt.electricdevice;

/**
 * it abstract class which has two fields name and power, a parameterized
 * constructor and get and set methods that provide access to the fields.
 * 
 * @author Ilya
 *
 */
public abstract class Equipment implements ElectricDevices, Comparable<Object>,Serializable {

	 String name = null;
	 int power = 0;

	public Equipment(String name, int power) {
		setName(name);
		setPower(power);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * this method overrides the interface Comparable and sorts on the field
	 * power
	 */
	@Override
	public int compareTo(Object arg0) {
		Equipment tmp = (Equipment) arg0;
		if (this.power < tmp.power) {
			return -1;
		}
		if (this.power > tmp.power) {
			return 1;
		} else
			return 0;
	}
}
