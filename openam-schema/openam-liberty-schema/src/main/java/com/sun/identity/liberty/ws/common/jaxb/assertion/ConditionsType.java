//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.6-b27-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.11 at 10:33:54 AM PDT 
//


package com.sun.identity.liberty.ws.common.jaxb.assertion;


/**
 * Java content class for ConditionsType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/Users/allan/A-SVN/trunk/opensso/products/federation/library/xsd/liberty/cs-sstc-schema-assertion-01.xsd line 75)
 * <p>
 * <pre>
 * &lt;complexType name="ConditionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{urn:oasis:names:tc:SAML:1.0:assertion}AudienceRestrictionCondition"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:1.0:assertion}DoNotCacheCondition"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:1.0:assertion}Condition"/>
 *       &lt;/choice>
 *       &lt;attribute name="NotBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="NotOnOrAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface ConditionsType {


    /**
     * Gets the value of the notBefore property.
     * 
     * @return
     *     possible object is
     *     {@link java.util.Calendar}
     */
    java.util.Calendar getNotBefore();

    /**
     * Sets the value of the notBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.util.Calendar}
     */
    void setNotBefore(java.util.Calendar value);

    /**
     * Gets the value of the AudienceRestrictionConditionOrDoNotCacheConditionOrCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the AudienceRestrictionConditionOrDoNotCacheConditionOrCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAudienceRestrictionConditionOrDoNotCacheConditionOrCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link com.sun.identity.liberty.ws.common.jaxb.assertion.AudienceRestrictionConditionElement}
     * {@link com.sun.identity.liberty.ws.common.jaxb.assertion.ConditionElement}
     * {@link com.sun.identity.liberty.ws.common.jaxb.assertion.DoNotCacheConditionElement}
     * 
     */
    java.util.List getAudienceRestrictionConditionOrDoNotCacheConditionOrCondition();

    /**
     * Gets the value of the notOnOrAfter property.
     * 
     * @return
     *     possible object is
     *     {@link java.util.Calendar}
     */
    java.util.Calendar getNotOnOrAfter();

    /**
     * Sets the value of the notOnOrAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.util.Calendar}
     */
    void setNotOnOrAfter(java.util.Calendar value);

}