package Parsers;
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLvalidator {

	public boolean validateXMLSchema(String xsdPath, String xmlPath) {

		try {
			// parse an XML document into a DOM tree
			// DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			// Document document = parser.parse(new File("instance.xml"));

			// create a SchemaFactory capable of understanding WXS schemas
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			// load a WXS schema, represented by a Schema instance
			// Source schemaFile = new StreamSource(new File("mySchema.xsd"));
			// Schema schema = factory.newSchema(schemaFile);
			Schema schema = factory.newSchema(new StreamSource(new File(xsdPath)));

			// create a Validator instance, which can be used to validate an
			// instance document
			Validator validator = schema.newValidator();

			// validate the DOM tree

			// if use DocumentBuilder above
			// validator.validate(new DOMSource(document));
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		} catch (SAXException e1) {
			System.out.println("SAX Exception: " + e1.getMessage());
			return false;
		}
		return true;

	}
}
