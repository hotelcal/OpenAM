//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.6-b27-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.11 at 10:33:54 AM PDT 
//


package com.sun.identity.liberty.ws.meta.jaxb.impl;

public class OrganizationTypeImpl implements com.sun.identity.liberty.ws.meta.jaxb.OrganizationType, com.sun.xml.bind.JAXBObject, com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallableObject, com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializable, com.sun.identity.federation.jaxb.entityconfig.impl.runtime.ValidatableObject
{

    protected com.sun.identity.liberty.ws.meta.jaxb.ExtensionType _Extension;
    protected com.sun.xml.bind.util.ListImpl _OrganizationDisplayName;
    protected com.sun.xml.bind.util.ListImpl _OrganizationURL;
    protected com.sun.xml.bind.util.ListImpl _OrganizationName;
    public final static java.lang.Class version = (com.sun.identity.liberty.ws.meta.jaxb.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.sun.identity.liberty.ws.meta.jaxb.OrganizationType.class);
    }

    public com.sun.identity.liberty.ws.meta.jaxb.ExtensionType getExtension() {
        return _Extension;
    }

    public void setExtension(com.sun.identity.liberty.ws.meta.jaxb.ExtensionType value) {
        _Extension = value;
    }

    protected com.sun.xml.bind.util.ListImpl _getOrganizationDisplayName() {
        if (_OrganizationDisplayName == null) {
            _OrganizationDisplayName = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
        }
        return _OrganizationDisplayName;
    }

    public java.util.List getOrganizationDisplayName() {
        return _getOrganizationDisplayName();
    }

    protected com.sun.xml.bind.util.ListImpl _getOrganizationURL() {
        if (_OrganizationURL == null) {
            _OrganizationURL = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
        }
        return _OrganizationURL;
    }

    public java.util.List getOrganizationURL() {
        return _getOrganizationURL();
    }

    protected com.sun.xml.bind.util.ListImpl _getOrganizationName() {
        if (_OrganizationName == null) {
            _OrganizationName = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
        }
        return _OrganizationName;
    }

    public java.util.List getOrganizationName() {
        return _getOrganizationName();
    }

    public com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingContext context) {
        return new com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx2 = 0;
        final int len2 = ((_OrganizationDisplayName == null)? 0 :_OrganizationDisplayName.size());
        int idx3 = 0;
        final int len3 = ((_OrganizationURL == null)? 0 :_OrganizationURL.size());
        int idx4 = 0;
        final int len4 = ((_OrganizationName == null)? 0 :_OrganizationName.size());
        while (idx4 != len4) {
            context.startElement("urn:liberty:metadata:2003-08", "OrganizationName");
            int idx_0 = idx4;
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _OrganizationName.get(idx_0 ++)), "OrganizationName");
            context.endNamespaceDecls();
            int idx_1 = idx4;
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _OrganizationName.get(idx_1 ++)), "OrganizationName");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _OrganizationName.get(idx4 ++)), "OrganizationName");
            context.endElement();
        }
        while (idx2 != len2) {
            context.startElement("urn:liberty:metadata:2003-08", "OrganizationDisplayName");
            int idx_2 = idx2;
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _OrganizationDisplayName.get(idx_2 ++)), "OrganizationDisplayName");
            context.endNamespaceDecls();
            int idx_3 = idx2;
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _OrganizationDisplayName.get(idx_3 ++)), "OrganizationDisplayName");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _OrganizationDisplayName.get(idx2 ++)), "OrganizationDisplayName");
            context.endElement();
        }
        while (idx3 != len3) {
            context.startElement("urn:liberty:metadata:2003-08", "OrganizationURL");
            int idx_4 = idx3;
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _OrganizationURL.get(idx_4 ++)), "OrganizationURL");
            context.endNamespaceDecls();
            int idx_5 = idx3;
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _OrganizationURL.get(idx_5 ++)), "OrganizationURL");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _OrganizationURL.get(idx3 ++)), "OrganizationURL");
            context.endElement();
        }
        if (_Extension!= null) {
            if (_Extension instanceof javax.xml.bind.Element) {
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _Extension), "Extension");
            } else {
                context.startElement("urn:liberty:metadata:2003-08", "Extension");
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Extension), "Extension");
                context.endNamespaceDecls();
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Extension), "Extension");
                context.endAttributes();
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _Extension), "Extension");
                context.endElement();
            }
        }
    }

    public void serializeAttributes(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx2 = 0;
        final int len2 = ((_OrganizationDisplayName == null)? 0 :_OrganizationDisplayName.size());
        int idx3 = 0;
        final int len3 = ((_OrganizationURL == null)? 0 :_OrganizationURL.size());
        int idx4 = 0;
        final int len4 = ((_OrganizationName == null)? 0 :_OrganizationName.size());
        while (idx4 != len4) {
            idx4 += 1;
        }
        while (idx2 != len2) {
            idx2 += 1;
        }
        while (idx3 != len3) {
            idx3 += 1;
        }
        if (_Extension!= null) {
            if (_Extension instanceof javax.xml.bind.Element) {
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Extension), "Extension");
            }
        }
    }

    public void serializeURIs(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx2 = 0;
        final int len2 = ((_OrganizationDisplayName == null)? 0 :_OrganizationDisplayName.size());
        int idx3 = 0;
        final int len3 = ((_OrganizationURL == null)? 0 :_OrganizationURL.size());
        int idx4 = 0;
        final int len4 = ((_OrganizationName == null)? 0 :_OrganizationName.size());
        while (idx4 != len4) {
            idx4 += 1;
        }
        while (idx2 != len2) {
            idx2 += 1;
        }
        while (idx3 != len3) {
            idx3 += 1;
        }
        if (_Extension!= null) {
            if (_Extension instanceof javax.xml.bind.Element) {
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Extension), "Extension");
            }
        }
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.sun.identity.liberty.ws.meta.jaxb.OrganizationType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
+"n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
+"mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
+"on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
+"expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsr\u0000 com.sun.msv.grammar."
+"OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003ppsr\u0000\'com.sun.msv.grammar.trex.Elemen"
+"tPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameC"
+"lass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreU"
+"ndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003pp\u0000sq\u0000~\u0000\u0000ppsq\u0000~"
+"\u0000\u000bpp\u0000sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsq\u0000"
+"~\u0000\bsr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000 com.sun.m"
+"sv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~"
+"\u0000\fxq\u0000~\u0000\u0003q\u0000~\u0000\u0015psr\u00002com.sun.msv.grammar.Expression$AnyStringEx"
+"pression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000\u0014\u0001q\u0000~\u0000\u0019sr\u0000 com.sun.msv.grammar"
+".AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expression$EpsilonExpressi"
+"on\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003q\u0000~\u0000\u001aq\u0000~\u0000\u001fsr\u0000#com.sun.msv.grammar.SimpleN"
+"ameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnames"
+"paceURIq\u0000~\u0000!xq\u0000~\u0000\u001ct\u0000:com.sun.identity.liberty.ws.meta.jaxb.O"
+"rganizationNameTypet\u0000+http://java.sun.com/jaxb/xjc/dummy-ele"
+"mentssq\u0000~\u0000\u0011ppsq\u0000~\u0000\u0016q\u0000~\u0000\u0015psr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002"
+"L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0003q\u0000~\u0000\u0015psr\u0000\"com.s"
+"un.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000*com.sun.msv.data"
+"type.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatyp"
+"e.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XS"
+"DatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUriq\u0000~\u0000!L\u0000\btypeNameq\u0000~\u0000!L"
+"\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor"
+";xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0005QNamesr\u00005com.sun.ms"
+"v.datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,co"
+"m.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000c"
+"om.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq"
+"\u0000~\u0000\u0003q\u0000~\u0000\u0015psr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocal"
+"Nameq\u0000~\u0000!L\u0000\fnamespaceURIq\u0000~\u0000!xpq\u0000~\u00002q\u0000~\u00001sq\u0000~\u0000 t\u0000\u0004typet\u0000)htt"
+"p://www.w3.org/2001/XMLSchema-instanceq\u0000~\u0000\u001fsq\u0000~\u0000 t\u0000\u0010Organiza"
+"tionNamet\u0000\u001curn:liberty:metadata:2003-08sq\u0000~\u0000\bppsq\u0000~\u0000\u000bpp\u0000sq\u0000~"
+"\u0000\u0000ppsq\u0000~\u0000\u000bpp\u0000sq\u0000~\u0000\u0011ppsq\u0000~\u0000\bq\u0000~\u0000\u0015psq\u0000~\u0000\u0016q\u0000~\u0000\u0015pq\u0000~\u0000\u0019q\u0000~\u0000\u001dq\u0000~\u0000\u001f"
+"sq\u0000~\u0000 t\u0000Acom.sun.identity.liberty.ws.meta.jaxb.OrganizationD"
+"isplayNameTypeq\u0000~\u0000$sq\u0000~\u0000\u0011ppsq\u0000~\u0000\u0016q\u0000~\u0000\u0015pq\u0000~\u0000*q\u0000~\u0000:q\u0000~\u0000\u001fsq\u0000~\u0000 "
+"t\u0000\u0017OrganizationDisplayNameq\u0000~\u0000?sq\u0000~\u0000\bppsq\u0000~\u0000\u000bpp\u0000sq\u0000~\u0000\u0000ppsq\u0000~"
+"\u0000\u000bpp\u0000sq\u0000~\u0000\u0011ppsq\u0000~\u0000\bq\u0000~\u0000\u0015psq\u0000~\u0000\u0016q\u0000~\u0000\u0015pq\u0000~\u0000\u0019q\u0000~\u0000\u001dq\u0000~\u0000\u001fsq\u0000~\u0000 t\u0000"
+"6com.sun.identity.liberty.ws.meta.jaxb.LocalizedURITypeq\u0000~\u0000$"
+"sq\u0000~\u0000\u0011ppsq\u0000~\u0000\u0016q\u0000~\u0000\u0015pq\u0000~\u0000*q\u0000~\u0000:q\u0000~\u0000\u001fsq\u0000~\u0000 t\u0000\u000fOrganizationURLq"
+"\u0000~\u0000?sq\u0000~\u0000\u0011ppsq\u0000~\u0000\u0011q\u0000~\u0000\u0015psq\u0000~\u0000\u000bq\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0011ppsq\u0000~\u0000\bq\u0000~\u0000\u0015psq\u0000"
+"~\u0000\u0016q\u0000~\u0000\u0015pq\u0000~\u0000\u0019q\u0000~\u0000\u001dq\u0000~\u0000\u001fsq\u0000~\u0000 t\u00006com.sun.identity.liberty.ws"
+".meta.jaxb.ExtensionElementq\u0000~\u0000$sq\u0000~\u0000\u000bq\u0000~\u0000\u0015p\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\u000bp"
+"p\u0000sq\u0000~\u0000\u0011ppsq\u0000~\u0000\bq\u0000~\u0000\u0015psq\u0000~\u0000\u0016q\u0000~\u0000\u0015pq\u0000~\u0000\u0019q\u0000~\u0000\u001dq\u0000~\u0000\u001fsq\u0000~\u0000 t\u00003co"
+"m.sun.identity.liberty.ws.meta.jaxb.ExtensionTypeq\u0000~\u0000$sq\u0000~\u0000\u0011"
+"ppsq\u0000~\u0000\u0016q\u0000~\u0000\u0015pq\u0000~\u0000*q\u0000~\u0000:q\u0000~\u0000\u001fsq\u0000~\u0000 t\u0000\tExtensionq\u0000~\u0000?q\u0000~\u0000\u001fsr\u0000"
+"\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/"
+"Lcom/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun"
+".msv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\r"
+"streamVersionL\u0000\u0006parentt\u0000$Lcom/sun/msv/grammar/ExpressionPool"
+";xp\u0000\u0000\u0000\u001a\u0001pq\u0000~\u0000\u0006q\u0000~\u0000\u0013q\u0000~\u0000Eq\u0000~\u0000Rq\u0000~\u0000^q\u0000~\u0000fq\u0000~\u0000\u0007q\u0000~\u0000\u0005q\u0000~\u0000\nq\u0000~\u0000@q"
+"\u0000~\u0000Mq\u0000~\u0000\u0012q\u0000~\u0000Dq\u0000~\u0000Qq\u0000~\u0000]q\u0000~\u0000eq\u0000~\u0000\u000fq\u0000~\u0000Bq\u0000~\u0000Oq\u0000~\u0000cq\u0000~\u0000Zq\u0000~\u0000%q"
+"\u0000~\u0000Iq\u0000~\u0000Vq\u0000~\u0000jq\u0000~\u0000[x"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.sun.identity.federation.jaxb.entityconfig.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingContext context) {
            super(context, "-------------");
        }

        protected Unmarshaller(com.sun.identity.federation.jaxb.entityconfig.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  1 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        break;
                    case  11 :
                        if (!(("" == ___uri)||("urn:liberty:metadata:2003-08" == ___uri))) {
                            _Extension = ((com.sun.identity.liberty.ws.meta.jaxb.impl.ExtensionTypeImpl) spawnChildFromEnterElement((com.sun.identity.liberty.ws.meta.jaxb.impl.ExtensionTypeImpl.class), 12, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        break;
                    case  4 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        break;
                    case  9 :
                        if (("OrganizationURL" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 7;
                            return ;
                        }
                        if (("Extension" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            _Extension = ((com.sun.identity.liberty.ws.meta.jaxb.impl.ExtensionElementImpl) spawnChildFromEnterElement((com.sun.identity.liberty.ws.meta.jaxb.impl.ExtensionElementImpl.class), 10, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        if (("Extension" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 11;
                            return ;
                        }
                        state = 10;
                        continue outer;
                    case  6 :
                        if (("OrganizationDisplayName" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 4;
                            return ;
                        }
                        if (("OrganizationURL" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 7;
                            return ;
                        }
                        break;
                    case  7 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        break;
                    case  10 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  0 :
                        if (("OrganizationName" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        break;
                    case  3 :
                        if (("OrganizationName" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        if (("OrganizationDisplayName" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 4;
                            return ;
                        }
                        break;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  1 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  4 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  9 :
                        state = 10;
                        continue outer;
                    case  8 :
                        if (("OrganizationURL" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.popAttributes();
                            state = 9;
                            return ;
                        }
                        break;
                    case  7 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  10 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  12 :
                        if (("Extension" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.popAttributes();
                            state = 10;
                            return ;
                        }
                        break;
                    case  5 :
                        if (("OrganizationDisplayName" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.popAttributes();
                            state = 6;
                            return ;
                        }
                        break;
                    case  2 :
                        if (("OrganizationName" == ___local)&&("urn:liberty:metadata:2003-08" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  1 :
                        if (("lang" == ___local)&&("http://www.w3.org/XML/1998/namespace" == ___uri)) {
                            _getOrganizationName().add(((com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationNameTypeImpl) spawnChildFromEnterAttribute((com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationNameTypeImpl.class), 2, ___uri, ___local, ___qname)));
                            return ;
                        }
                        break;
                    case  4 :
                        if (("lang" == ___local)&&("http://www.w3.org/XML/1998/namespace" == ___uri)) {
                            _getOrganizationDisplayName().add(((com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationDisplayNameTypeImpl) spawnChildFromEnterAttribute((com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationDisplayNameTypeImpl.class), 5, ___uri, ___local, ___qname)));
                            return ;
                        }
                        break;
                    case  9 :
                        state = 10;
                        continue outer;
                    case  7 :
                        if (("lang" == ___local)&&("http://www.w3.org/XML/1998/namespace" == ___uri)) {
                            _getOrganizationURL().add(((com.sun.identity.liberty.ws.meta.jaxb.impl.LocalizedURITypeImpl) spawnChildFromEnterAttribute((com.sun.identity.liberty.ws.meta.jaxb.impl.LocalizedURITypeImpl.class), 8, ___uri, ___local, ___qname)));
                            return ;
                        }
                        break;
                    case  10 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  1 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  4 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  9 :
                        state = 10;
                        continue outer;
                    case  7 :
                        attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        break;
                    case  10 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  1 :
                            attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            _getOrganizationName().add(((com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationNameTypeImpl) spawnChildFromText((com.sun.identity.liberty.ws.meta.jaxb.impl.OrganizationNameTypeImpl.class), 2, value)));
                            return ;
                        case  4 :
                            attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            break;
                        case  9 :
                            state = 10;
                            continue outer;
                        case  7 :
                            attIdx = context.getAttribute("http://www.w3.org/XML/1998/namespace", "lang");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            break;
                        case  10 :
                            revertToParentFromText(value);
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}