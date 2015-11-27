import java.io.File;

/**
 * entry point
 * @author Ilya
 *
 */
public class StartDomSaxStax {

	public static void main(String[] args) {
		File file = new File("src/student.xml");
		
		ParseSingleton ps = ParseSingleton.getInstance();
		ParseSingleton.factoryParse("DOM").parse(file);
		
		ParseSingleton.factoryParse("SAX").parse(file);
		
		ParseSingleton.factoryParse("StAX").parse(file);
	}

}
