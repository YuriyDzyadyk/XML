package JAXB;

import java.io.File;
import javax.xml.bind.*;


public class MyUnMurshaller {

	public void MyUnMurshallerizer() throws JAXBException{
	
	JAXBContext jaxbContext = JAXBContext.newInstance(JaxBcandy.class);
	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	JaxBcandy sweets = (JaxBcandy) jaxbUnmarshaller.unmarshal(new File("Sweets.xml"));
	System.out.println(sweets);
	}
}
