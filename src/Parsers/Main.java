package Parsers;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import JAXB.MyMarshaller;

public class Main {
	public static void main(String[] args) throws JAXBException {
		XMLvalidator validator = new XMLvalidator();
		
//		String xsdPath="SweetsXMLSchema.xsd";
//		String xmlPath="Sweets.xml";
//		System.out.println(validator.validateXMLSchema(xsdPath, xmlPath));
//		 
//		try{
//			TransformerFactory tff = TransformerFactory.newInstance();
//		Transformer tf = tff.newTransformer(new StreamSource(new File("Sweets.xsl")));
//		StreamSource ss = new StreamSource(new File("Sweets.xml"));
//		StreamResult sr = new StreamResult(new File("Sweets.html"));
//		tf.transform(ss, sr);
//		System.out.println("Done");
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
		
		
	}

}
