import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Pars extends DefaultHandler {

	public static void main(String[] args) {
		
		/*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
				
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		
		File f = new File("src/new.xml");
		try {
			doc = builder.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = doc.getDocumentElement();
		System.out.println(root.getTagName());*/
		
		
		
		
	/*	try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			Pars pars = new Pars();
			reader.setContentHandler(pars);
			reader.parse("src/new.xml");
			
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void startDocument() {
	System.out.println("Parsing started");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) {
	String s = localName;
	
	for (int i = 0; i < attrs.getLength(); i++) {
	s += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
	}
	System.out.print(s.trim());
	}
	@Override
	public void characters(char[ ] ch, int start, int length) {
	System.out.print(new String(ch, start, length));
	}
	@Override
	public void endElement(String uri, String localName, String qName) {
	System.out.print(localName);
	}
	@Override
	public void endDocument() {
	System.out.println("\nParsing ended");
	}*/
		boolean isFirstName = false;
		boolean isLastName = false;
		boolean isAge = false;
		boolean isFaculty = false;
		
		try {
		XMLInputFactory factory = XMLInputFactory.newFactory();
		   
    XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("src/new.xml"));
	while(reader.hasNext()){
	 int res = reader.next();
	 if(res == reader.START_ELEMENT){
	 if(reader.getLocalName().equals("firstName"))
		 isFirstName = true;
	 else if(reader.getLocalName().equals("lastName"))
	 isLastName = true;
	 else if(reader.getLocalName().equals("age"))
	 isAge = true;
	 else if(reader.getLocalName().equals("faculty"))
		 isFaculty = true;
	 }
	 else if(res == reader.CHARACTERS){
	 if(isFirstName){
	 System.out.println("firstName:" + reader.getText());
	 isFirstName = false;
	 }
	 else if(isLastName){
	 System.out.println("lastName:" + reader.getText());
	 isLastName = false;
	 }
	 else if(isAge){
	 System.out.println("Age:" + reader.getText());
	 isAge = false;
	 }
	 else if(isFaculty){
		 System.out.println("Faculty:" + reader.getText());
		 isFaculty = false;
	 }
	 }
	 }
	} catch (XMLStreamException | FileNotFoundException e) {
	 e.printStackTrace();}
		}
	}

