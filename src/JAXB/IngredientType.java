//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.14 at 11:57:54 PM EEST 
//


package JAXB;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;




@XmlEnum
public enum IngredientType {

    @XmlEnumValue("water")
    WATER("water"),
    @XmlEnumValue("sugar")
    SUGAR("sugar"),
    @XmlEnumValue("vanilla")
    VANILLA("vanilla"),
    @XmlEnumValue("treacle")
    TREACLE("treacle"),
    @XmlEnumValue("stabilizer")
    STABILIZER("stabilizer");
    private final String value;

    IngredientType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IngredientType fromValue(String v) {
        for (IngredientType c: IngredientType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}