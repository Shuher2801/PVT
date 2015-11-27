import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * DOM parser
 * @author Ilya
 *
 */
public class DomFactory implements AllParse{
	@Override
	public void parse(File file) {
		
		  DocumentBuilderFactory factory =
		  DocumentBuilderFactory.newInstance(); DocumentBuilder builder = null;
		  Document doc = null;
		  
		  try { builder = factory.newDocumentBuilder(); } catch
		  (ParserConfigurationException e) {
		  
		  e.printStackTrace(); }
		  
		   try { doc = builder.parse(file); }
		  catch (SAXException e) { e.printStackTrace(); } catch (IOException e)
		  { e.printStackTrace(); } Element root = doc.getDocumentElement();
		  System.out.println(root.getTagName());
	}

	 
}
