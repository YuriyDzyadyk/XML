package JAXB;

import javax.xml.bind.JAXBException;

public class Main {
	public static void main(String[] args) throws JAXBException {

		
		MyMarshaller m = new MyMarshaller();
	//	m.Marshallizer();
		MyUnMurshaller um = new MyUnMurshaller();
		um.MyUnMurshallerizer();
	}

}
