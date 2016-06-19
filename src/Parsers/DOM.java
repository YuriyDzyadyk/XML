package Parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Sweets.Candy;
import Sweets.Candy.*;

public class DOM {

	public static void main(String[] args) throws Exception {
		// Get the DOM Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load and Parse the XML document
		// document contains the complete XML as a Tree.
		//Document document = builder.parse(ClassLoader.getSystemResourceAsStream("xml/Sweets.xml"));
		Document document = builder.parse(new File("Sweets.xml"));
	      document.getDocumentElement().normalize();
		
		List<Candy> candies = new ArrayList<>();

		// Iterating through the nodes and extracting the data.
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		// Create new Candy Object
		Candy candy = new Candy();
		for (int i = 0; i < nodeList.getLength(); i++) {
			// We have encountered an <candy> tag.
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
			switch (node.getNodeName()) {
				case "name":
				candy.setName(eElement.getTextContent());
				break;
				case "type":
				candy.setType(eElement.getTextContent());
				break;
				case "prodaction":
				candy.setProdaction(eElement.getTextContent());
				}
			}

			if (node instanceof Element) {
				switch (node.getNodeName()) {
				case "energy":
					Energy energy = new Energy();
					candy.setEnergy(energy);
					candy.getEnergy().setUnit(((Element) node).getAttribute("unit"));
					candy.getEnergy().setAmount(Integer.parseInt(((Element) node).getAttribute("amount")));
				break;
				}
				

				NodeList childNodes = node.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = childNodes.item(j);
					// Identifying the child tag of employee encountered.
					if (cNode instanceof Element) {
						switch (cNode.getNodeName()) {
						case "ingredient":
							Ingredients ingredients = new Ingredients();
							candy.setIngredients(ingredients);
							candy.getIngredients().setName(((Element) cNode).getAttribute("name"));
							candy.getIngredients().setUnit(((Element) cNode).getAttribute("unit"));
							candy.getIngredients().setAmount(Integer.parseInt(((Element) cNode).getAttribute("amount")));

							break;
						case "value":
							Values values = new Values();
							candy.setValues(values);
							candy.getValues().setName(((Element) cNode).getAttribute("name"));
							candy.getValues().setUnit(((Element) cNode).getAttribute("unit"));
							candy.getValues().setAmount(Integer.parseInt(((Element) cNode).getAttribute("amount")));

							break;
						}
					}
				}
			}

		}
		candies.add(candy);

		// Printing the Candy list populated.
		for (Candy emp : candies) {
			System.out.println(emp);
		}

	}
}


