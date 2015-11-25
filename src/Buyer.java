package Work13;

public class Buyer  implements Runnable{
String[] itm;
String name;
Thread t;

	public  Buyer(String n,String...args ){
	
		name = n;
		itm = args;
		new Thread(this).start();
	}
	
	public String[] getItm() {
		return itm;
	}

	public void setItm(String[] itm) {
		this.itm = itm;
	}

	public  String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		
		MainWork13.print(getItm(),getName());
		
	}

}
