package Work13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWork13 {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(3);
	
		 new Buyer("b1", "bread"," milk", "mineral water");
		 new Buyer("b2", "sausage", "oranges", "oatmeal");
		 new Buyer("b3","bread"," milk", "eggs","mineral water");
		 new Buyer("b4", "bananas"," coffee", "bread");
		 new Buyer("b5","bounty");
		
		ex.shutdown();
	}
	 public static void print(String[] strings, String name){
		 System.out.print ("Buyer" + name + " went to the cash shop ");
		 for(int i=0; i< strings.length; i++){
		 System.out.print( strings[i]+ ", ");}
		 System.out.println("Buyer" + name + " paid and left ");
		 
	 }

}
