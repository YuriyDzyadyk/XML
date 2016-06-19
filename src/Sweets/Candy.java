
package Sweets;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "energy",
    "type",
    "ingredients",
    "values",
    "prodaction"
})
@XmlRootElement(name = "candy")
public class Candy {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected Candy.Energy energy;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected /*List<Candy.Ingredients>*/Candy.Ingredients ingredients;
    @XmlElement(required = true)
    protected /*List<Candy.Values>*/Candy.Values values;
    @XmlElement(required = true)
    protected String prodaction;

    public String getName() {
        return name;
    }

  
    public void setName(String value) {
        this.name = value;
    }

   
    public Candy.Energy getEnergy() {
        return energy;
    }

   
    public void setEnergy(Candy.Energy value) {
        this.energy = value;
    }

    
    public String getType() {
        return type;
    }

   
    public void setType(String value) {
        this.type = value;
    }

    
    public Candy.Ingredients getIngredients() {
        return ingredients;
    }

    
    public void setIngredients(Candy.Ingredients value) {
        this.ingredients = value;
    }

  
    public Candy.Values getValues() {
        return values;
    }

   
    public void setValues(Candy.Values value) {
        this.values = value;
    }

    
    
    public String getProdaction() {
        return prodaction;
    }


    public void setProdaction(String value) {
        this.prodaction = value;
    }


      @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Energy {

        @XmlAttribute(name = "unit")
        private String unit;
        @XmlAttribute(name = "amount")
        private int amount;

    
        public String getUnit() {
            if (unit == null) {
                return "Kkal";
            } else {
                return unit;
            }
        }

     
        public void setUnit(String value) {
            this.unit = value;
        }

      
        public int getAmount() {
            return amount;
        }

      
        public void setAmount(int value) {
            this.amount = value;
        }


		@Override
		public String toString() {
			return "Energy [unit=" + unit + ", amount=" + amount + "]";
		}
        
        

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ingredient"
    })
    public static class Ingredients {

        @XmlElement(required = true)
        protected List<Object> ingredient;
        @XmlAttribute(name = "name")
        protected /*IngredientType*/String name;
        @XmlAttribute(name = "amount")
        protected double amount;
        @XmlAttribute(name = "unit")
        protected String unit;

  
        public List<Object> getIngredient() {
            if (ingredient == null) {
                ingredient = new ArrayList<Object>();
            }
            return this.ingredient;
        }

 
        public /*IngredientType*/String getName() {
            return name;
        }

  
        public void setName(/*IngredientType*/String value) {
            this.name = value;
        }

   
        public double getAmount() {
            return amount;
        }

             public void setAmount(double value) {
            this.amount = value;
        }

     
        public String getUnit() {
            if (unit == null) {
                return "mg";
            } else {
                return unit;
            }
        }

     
        public void setUnit(String value) {
            this.unit = value;
        }


		@Override
		public String toString() {
			return "Ingredients [name=" + name + ", amount=" + amount + ", unit=" + unit
					+ "]";
		}
        
        

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Values {

        @XmlElement(required = true)
        protected List<Object> value;
        @XmlAttribute(name = "name")
        protected /*IngredientType*/String name;
        @XmlAttribute(name = "amount")
        protected double amount;
        @XmlAttribute(name = "unit")
        protected String unit;

       
        public List<Object> getValue() {
            if (value == null) {
                value = new ArrayList<Object>();
            }
            return this.value;
        }

     
        public /*IngredientType*/String getName() {
            return name;
        }

      
        public void setName(/*IngredientType*/String value) {
            this.name = value;
        }

              public double getAmount() {
            return amount;
        }

     
        public void setAmount(double value) {
            this.amount = value;
        }

             public String getUnit() {
            if (unit == null) {
                return "g";
            } else {
                return unit;
            }
        }

      
        public void setUnit(String value) {
            this.unit = value;
        }


		@Override
		public String toString() {
			return "Values [ name=" + name + ", amount=" + amount + ", unit=" + unit + "]";
		}
        
        

    }


	@Override
	public String toString() {
		return "Candy [name=" + name + ", energy=" + energy + ", type=" + type + ", ingredients=" + ingredients
				+ ", values=" + values + ", prodaction=" + prodaction + "]";
	}
    

}
