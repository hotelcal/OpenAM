/**
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2013 ForgeRock AS. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://forgerock.org/license/CDDLv1.0.html
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://forgerock.org/license/CDDLv1.0.html
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-661 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.21 at 10:40:04 AM PST 
//


package com.sun.identity.entitlement.xacml3.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Decision"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Status" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Obligations" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AssociatedAdvice" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Attributes" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}PolicyIdentifierList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultType", propOrder = {
    "decision",
    "status",
    "obligations",
    "associatedAdvice",
    "attributes",
    "policyIdentifierList"
})
public class Result implements XACMLRootElement {

    @XmlElement(name = "Decision", required = true)
    protected DecisionType decision;
    @XmlElement(name = "Status")
    protected Status status;
    @XmlElement(name = "Obligations")
    protected Obligations obligations;
    @XmlElement(name = "AssociatedAdvice")
    protected AssociatedAdvice associatedAdvice;
    @XmlElement(name = "Attributes")
    protected List<Attributes> attributes;
    @XmlElement(name = "PolicyIdentifierList")
    protected PolicyIdentifierList policyIdentifierList;

    /**
     * Gets the value of the decision property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionType }
     *     
     */
    public DecisionType getDecision() {
        return decision;
    }

    /**
     * Sets the value of the decision property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionType }
     *     
     */
    public void setDecision(DecisionType value) {
        this.decision = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the obligations property.
     * 
     * @return
     *     possible object is
     *     {@link Obligations }
     *     
     */
    public Obligations getObligations() {
        return obligations;
    }

    /**
     * Sets the value of the obligations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obligations }
     *     
     */
    public void setObligations(Obligations value) {
        this.obligations = value;
    }

    /**
     * Gets the value of the associatedAdvice property.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedAdvice }
     *     
     */
    public AssociatedAdvice getAssociatedAdvice() {
        return associatedAdvice;
    }

    /**
     * Sets the value of the associatedAdvice property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedAdvice }
     *     
     */
    public void setAssociatedAdvice(AssociatedAdvice value) {
        this.associatedAdvice = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attributes }
     * 
     * 
     */
    public List<Attributes> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<Attributes>();
        }
        return this.attributes;
    }

    /**
     * Gets the value of the policyIdentifierList property.
     * 
     * @return
     *     possible object is
     *     {@link PolicyIdentifierList }
     *     
     */
    public PolicyIdentifierList getPolicyIdentifierList() {
        return policyIdentifierList;
    }

    /**
     * Sets the value of the policyIdentifierList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyIdentifierList }
     *     
     */
    public void setPolicyIdentifierList(PolicyIdentifierList value) {
        this.policyIdentifierList = value;
    }

    /**
     * Default toXML Method to Marshal Object into XML.
     * @return String - Marshaled Results into XML String.
     */
    public String toXML() {
        StringBuilder stringBuilder = new StringBuilder();
        // Begin Result Node.
        stringBuilder.append("<Result>");
        // Begin Decision
        stringBuilder.append("<Decision>"); // Required.
        if (this.getDecision() != null) {
            stringBuilder.append(this.getDecision().value());
        } else {
            stringBuilder.append(DecisionType.INDETERMINATE.value());
        }
        // End Decision
        stringBuilder.append("</Decision>");

        // Begin Status Marshaling, if Applicable
        if (this.getStatus() != null) {
            stringBuilder.append(this.getStatus().toXML());
        }

        // Begin Obligations Marshaling, if Applicable
        if (this.getObligations() != null) {
            stringBuilder.append(this.getObligations().toXML());
        }

        // Begin Associated Advice Marshaling, if Applicable
        if (this.getAssociatedAdvice() != null) {
            stringBuilder.append(this.getAssociatedAdvice().toXML());
        }

        // Begin Attributes Marshaling, if Applicable
        if ( (this.getAttributes() != null) && (this.getAttributes().size() > 0) ) {
            stringBuilder.append("<Attributes>");
            // ************************************************
            // Iterate over the Response Object to Marshal
            // into XML.
            Iterator<Attributes> attributesIterator =  this.getAttributes().iterator();
            while(attributesIterator.hasNext()) {
                Attributes innerAttributes = attributesIterator.next();
                if (innerAttributes != null) {
                    stringBuilder.append(innerAttributes.toXML());
                }
            } // End of Loop for Embedded Results.
            stringBuilder.append("</Attributes>");
        }

        // Begin Policy Identifier List Marshaling, if Applicable
        if (this.getPolicyIdentifierList() != null) {
            stringBuilder.append(this.getPolicyIdentifierList().toXML());
        }

        // Finalize Result Node.
        stringBuilder.append("</Result>");
        // Return Marshaled Data.
        return stringBuilder.toString();
    }

}