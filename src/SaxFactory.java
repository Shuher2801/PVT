import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

 /**
  *  SAX parser
  * @author Ilya
  *
  */
public class SaxFactory extends DefaultHandler implements AllParse{
	@Override
	public void parse(File file)  {
		String s = file + "";
		  try { XMLReader reader = XMLReaderFactory.createXMLReader();
		  SaxFactory pars = new SaxFactory();
		  reader.setContentHandler(pars);
		  reader.parse(s);
		  
		  } catch (SAXException | IOException e) {  e.printStackTrace();}} 
		  
		  @Override public void startDocument() {
		  System.out.println("Parsing started"); }
		  
		  @Override public void startElement(String uri, String localName,
		  String qName, Attributes attrs) { String s = localName;
		  
		  for (int i = 0; i < attrs.getLength(); i++) { s += " " +
		  attrs.getLocalName(i) + "=" + attrs.getValue(i); }
		  System.out.print(s.trim()); }
		  
		  @Override public void characters(char[ ] ch, int start, int length) {
		  System.out.print(new String(ch, start, length)); }
		  
		  @Override public void endElement(String uri, String localName, String
		  qName) { System.out.print(localName); }
		  
		  @Override public void endDocument() {
		  System.out.println("\nParsing ended"); }

		
			
			
		
}
