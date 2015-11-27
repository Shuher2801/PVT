import org.xml.sax.helpers.DefaultHandler;

/**
 * this class uses the Singleton and Factory patterns
 * @author Ilya
 *
 */
public class ParseSingleton  {

	public static ParseSingleton instance;

	private ParseSingleton() {
	}

	public static ParseSingleton getInstance() {
		if (instance == null) {
			instance = new ParseSingleton();
		}
		return instance ;
}
	public static AllParse  factoryParse (String parserName){
		if(parserName.equals("DOM")){
			return new DomFactory();}
		else if(parserName.equals("SAX")){
			return new SaxFactory();}
		else if(parserName.equals("StAX")){
			return new StaxFactory();}
		return null;
	}
}