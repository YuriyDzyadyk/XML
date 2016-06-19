package Parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import Sweets.Candy;
import Sweets.Candy.Energy;
import Sweets.Candy.Ingredients;
import Sweets.Candy.Values;

public class StAX {
	public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
		List<Candy> candyList = new ArrayList<>();
		Candy candy = null;
		String tagContent = null;
		Energy energy = null;
		Values value = null;
		Ingredients ingredient = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory
				.createXMLStreamReader(new InputStreamReader(new FileInputStream("Sweets.xml")));
		// factory.createXMLStreamReader(
		// ClassLoader.getSystemResourceAsStream("Sweets.xml"));

		while (reader.hasNext()) {
			int event = reader.next();

			switch (event) {
			case XMLStreamConstants.START_ELEMENT:
				if ("candy".equals(reader.getLocalName())) {
					candy = new Candy();
				}
				if ("energy".equals(reader.getLocalName())) {

					// candy.id = reader.getAttributeValue(0);

					energy = new Energy();
					candy.setEnergy(energy);
					candy.getEnergy().setUnit(reader.getAttributeValue(1));
					candy.getEnergy().setAmount(Integer.parseInt(reader.getAttributeValue(0)));
				}
				if ("ingredient".equals(reader.getLocalName())) {
					ingredient = new Ingredients();
					candy.setIngredients(ingredient);
					candy.getIngredients().setName(reader.getAttributeValue(0));
					candy.getIngredients().setUnit(reader.getAttributeValue(2));
					candy.getIngredients().setAmount(Integer.parseInt(reader.getAttributeValue(1)));
				}
				if ("value".equals(reader.getLocalName())) {

					value = new Values();
					candy.setValues(value);
					candy.getValues().setName(reader.getAttributeValue(0));
					candy.getValues().setUnit(reader.getAttributeValue(2));
					candy.getValues().setAmount(Integer.parseInt(reader.getAttributeValue(1)));
				}
				// if("candies".equals(reader.getLocalName())){
				// candyList = new ArrayList<>();
				// }
				break;

			case XMLStreamConstants.CHARACTERS:
				tagContent = reader.getText().trim();
				break;

			case XMLStreamConstants.END_ELEMENT:
				switch (reader.getLocalName()) {
				case "candy":
					candyList.add(candy);
					break;
				// For all other end tags the employee has to be updated.
				case "name":
					candy.setName(tagContent);
					break;
				case "type":
					candy.setType(tagContent);
					break;
				case "prodaction":
					candy.setProdaction(tagContent);
				}
				break;

			case XMLStreamConstants.START_DOCUMENT:
				candyList = new ArrayList<>();
				break;
			}

		}

		// Print the candy list populated from XML
		for (Candy can : candyList) {
			System.out.println(can);
		}

	}
}

// class Candy{
// String id;
// String firstName;
// String lastName;
// String location;
//
// @Override
// public String toString(){
// return firstName+" "+lastName+"("+id+") "+location;
// }
//
// }
