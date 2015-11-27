import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
/**
 * StAX parser
 * @author Ilya
 *
 */
public class StaxFactory implements AllParse {
	@Override
	public void parse(File file) {
		boolean isFirstName = false;
		boolean isLastName = false;
		boolean isAge = false;
		boolean isFaculty = false;

		try {
			XMLInputFactory factory = XMLInputFactory.newFactory();

			XMLStreamReader reader = factory
					.createXMLStreamReader(new FileInputStream(file));
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == reader.START_ELEMENT) {
					if (reader.getLocalName().equals("firstName"))
						isFirstName = true;
					else if (reader.getLocalName().equals("lastName"))
						isLastName = true;
					else if (reader.getLocalName().equals("age"))
						isAge = true;
					else if (reader.getLocalName().equals("faculty"))
						isFaculty = true;
				} else if (res == reader.CHARACTERS) {
					if (isFirstName) {
						System.out.println("firstName:" + reader.getText());
						isFirstName = false;
					} else if (isLastName) {
						System.out.println("lastName:" + reader.getText());
						isLastName = false;
					} else if (isAge) {
						System.out.println("Age:" + reader.getText());
						isAge = false;
					} else if (isFaculty) {
						System.out.println("Faculty:" + reader.getText());
						isFaculty = false;
					}
				}
			}
		} catch (XMLStreamException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
