package JAXB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import JAXB.JaxBcandy.Energy;
import JAXB.JaxBcandy.Ingredients;
import JAXB.JaxBcandy.Values;


public class MyMarshaller {

	
	
	public void Marshallizer() throws JAXBException{
	JaxBcandy candy = new JaxBcandy();
	
	List<JaxBcandy> candyList = new ArrayList<>();
	Energy energy = null;
	Ingredients ingredient= null;
	Values value = new Values();
	
	
	candy.setName("Mak");
	candy.setType("Caramel");
	candy.setProdaction("Svitoch");
	
	energy = new Energy();
	candy.setEnergy(energy);
	candy.getEnergy().setUnit("Kkal");
	candy.getEnergy().setAmount(300);

	
	ingredient= new Ingredients();
	ingredient.setName(IngredientType.WATER);
	ingredient.setUnit("mg");
	ingredient.setAmount(25);
	candy.getIngredients().add(ingredient);
	
	value = new Values();
	value.setName(ValueType.CARBOHYDRATES);
	value.setUnit("mg");
	value.setAmount(30);
	candy.getValues().add(value);
	candyList.add(candy);

// if("candies".equals(reader.getLocalName())){
// candyList = new ArrayList<>();
// }





	JAXBContext jaxbContext = JAXBContext.newInstance( JaxBcandy.class );
	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

	jaxbMarshaller.marshal( candy, new File( "F:\\Y\\MySweets.xml" ) );
	jaxbMarshaller.marshal( candy, System.out );
	
	}}
