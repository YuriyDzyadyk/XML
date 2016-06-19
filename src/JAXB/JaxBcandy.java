
package JAXB;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement (name="candy")
public class JaxBcandy {

    @XmlElement
    protected String name;
    @XmlElement
    protected JaxBcandy.Energy energy;
    @XmlElement
    protected String type;
    @XmlElementWrapper(name="ingredients")
    @XmlElement(name="ingredient")
    protected List<Ingredients> ingredients = new ArrayList<>();
    @XmlElementWrapper(name="values")
    @XmlElement(name = "value")
    protected List<Values> values = new ArrayList<>();
    @XmlElement
    protected String prodaction;

    public String getName() {
        return name;
    }

  
    public void setName(String value) {
        this.name = value;
    }

   
    public JaxBcandy.Energy getEnergy() {
        return energy;
    }

   
    public void setEnergy(JaxBcandy.Energy value) {
        this.energy = value;
    }

    
    public List<JaxBcandy.Ingredients> getIngredients() {
		return ingredients;
	}


	


	public List<JaxBcandy.Values> getValues() {
		return values;
	}


	public String getType() {
        return type;
    }

   
    public void setType(String value) {
        this.type = value;
    }
    
    public String getProdaction() {
        return prodaction;
    }


    public void setProdaction(String value) {
        this.prodaction = value;
    }


      @XmlAccessorType(XmlAccessType.NONE)
      public static class Energy {

        @XmlAttribute
        private String unit;
        @XmlAttribute
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
    
     public static class Ingredients {

    	@XmlAttribute
        protected IngredientType name;
        @XmlAttribute(name = "amount")
        protected double amount;
        @XmlAttribute(name = "unit")
        protected String unit;

  
        public IngredientType getName() {
            return name;
        }

  
        public void setName(IngredientType value) {
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


    @XmlAccessorType(XmlAccessType.NONE)
     public static class Values {

        @XmlAttribute
        protected ValueType name;
        @XmlAttribute
        protected double amount;
        @XmlAttribute
        protected String unit;

       
         public ValueType getName() {
            return name;
        }

      
        public void setName(ValueType value) {
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
