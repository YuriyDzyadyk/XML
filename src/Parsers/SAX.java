package Parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Sweets.Candy;
import Sweets.Candy.Energy;
import Sweets.Candy.Ingredients;
import Sweets.Candy.Values;

public class SAX {

	public static void main(String[] args) throws Exception {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(new File("Sweets.xml"), handler);
		// parser.parse(ClassLoader.getSystemResourceAsStream("Sweets.xml"),
		// handler);

		// Printing the list of employees obtained from XML
		for (Candy candy : handler.candyList) {
			System.out.println(candy);
		}
	}
}

/**
 * The Handler for SAX Events.
 */
class SAXHandler extends DefaultHandler {

	List<Candy> candyList = new ArrayList<>();
	Candy candy = null;
	Energy energy = null;
	String content = null;
	Ingredients ingredient = null;
	Values value = null;

	@Override
	// Triggered when the start of tag is found.
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {
		// Create a new Candy object when the start tag is found
		case "candy":
			candy = new Candy();
			break;
		case "energy":
			energy = new Energy();
			candy.setEnergy(energy);
			candy.getEnergy().setUnit(attributes.getValue("unit"));
			candy.getEnergy().setAmount(Integer.parseInt(attributes.getValue("amount")));
			break;
		case "ingredient":
			ingredient = new Ingredients();
			candy.setIngredients(ingredient);
			candy.getIngredients().setName(attributes.getValue("name"));
			candy.getIngredients().setUnit(attributes.getValue("unit"));
			candy.getIngredients().setAmount(Integer.parseInt(attributes.getValue("amount")));

			break;
		case "value":
			value = new Values();
			candy.setValues(value);
			candy.getValues().setName(attributes.getValue("name"));
			candy.getValues().setUnit(attributes.getValue("unit"));
			candy.getValues().setAmount(Integer.parseInt(attributes.getValue("amount")));

			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		// Add the candy to list once end tag is found
		case "candy":
			candyList.add(candy);
			break;
		// For all other end tags the employee has to be updated.
		case "name":
			candy.setName(content);
			break;
		case "type":
			candy.setType(content);
			break;
		case "prodaction":
			candy.setProdaction(content);

		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}
