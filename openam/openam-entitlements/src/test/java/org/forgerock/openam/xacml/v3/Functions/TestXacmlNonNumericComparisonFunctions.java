/**
 *
 ~ DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 ~
 ~ Copyright (c) 2011-2013 ForgeRock AS. All Rights Reserved
 ~
 ~ The contents of this file are subject to the terms
 ~ of the Common Development and Distribution License
 ~ (the License). You may not use this file except in
 ~ compliance with the License.
 ~
 ~ You can obtain a copy of the License at
 ~ http://forgerock.org/license/CDDLv1.0.html
 ~ See the License for the specific language governing
 ~ permission and limitations under the License.
 ~
 ~ When distributing Covered Code, include this CDDL
 ~ Header Notice in each file and include the License file
 ~ at http://forgerock.org/license/CDDLv1.0.html
 ~ If applicable, add the following below the CDDL Header,
 ~ with the fields enclosed by brackets [] replaced by
 ~ your own identifying information:
 ~ "Portions Copyrighted [year] [name of copyright owner]"
 *
 */
package org.forgerock.openam.xacml.v3.Functions;

import org.forgerock.openam.xacml.v3.model.DataType;
import org.forgerock.openam.xacml.v3.model.DataValue;
import org.forgerock.openam.xacml.v3.model.FunctionArgument;
import org.forgerock.openam.xacml.v3.model.XACML3EntitlementException;
import org.forgerock.openam.xacml.v3.model.XACML3PrivilegeUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * A.3.8 Non-numeric comparison functions
 These functions perform comparison operations on two arguments of non-numerical types.

 urn:oasis:names:tc:xacml:1.0:function:string-greater-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#string”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is lexicographically strictly greater than the second
 argument.  Otherwise, it SHALL return “False”.
 The comparison SHALL use Unicode codepoint collation, as defined for the identifier
 http://www.w3.org/2005/xpath-functions/collation/codepoint by [XF].

 urn:oasis:names:tc:xacml:1.0:function:string-greater-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#string”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is lexicographically greater than or equal to the second
 argument.  Otherwise, it SHALL return “False”.
 The comparison SHALL use Unicode codepoint collation, as defined for the identifier
 http://www.w3.org/2005/xpath-functions/collation/codepoint by [XF].

 urn:oasis:names:tc:xacml:1.0:function:string-less-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#string”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only the first argument is lexigraphically strictly less than the second argument.
 Otherwise, it SHALL return “False”. The comparison SHALL use Unicode codepoint collation,
 as defined for the identifier http://www.w3.org/2005/xpath-functions/collation/codepoint by [XF].

 urn:oasis:names:tc:xacml:1.0:function:string-less-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#string”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only the first argument is lexigraphically less than or equal to the second argument.
 Otherwise, it SHALL return “False”. The comparison SHALL use Unicode codepoint collation,
 as defined for the identifier http://www.w3.org/2005/xpath-functions/collation/codepoint by [XF].

 urn:oasis:names:tc:xacml:1.0:function:time-greater-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#time”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is greater than the second argument according to
 the order relation specified for “http://www.w3.org/2001/XMLSchema#time” [XS] Section 3.2.8.
 Otherwise, it SHALL return “False”.
 Note: it is illegal to compare a time that includes a time-zone value with one that does not.
 In such cases, the time-in-range function should be used.

 urn:oasis:names:tc:xacml:1.0:function:time-greater-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#time”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is greater than or equal to the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#time” [XS] Section 3.2.8.
 Otherwise, it SHALL return “False”.  Note: it is illegal to compare a time that includes a
 time-zone value with one that does not.  In such cases, the time-in-range function should be used.

 urn:oasis:names:tc:xacml:1.0:function:time-less-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#time”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is less than the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#time” [XS] Section 3.2.8.
 Otherwise, it SHALL return “False”.  Note: it is illegal to compare a time that includes a
 time-zone value with one that does not.  In such cases, the time-in-range function should be used.

 urn:oasis:names:tc:xacml:1.0:function:time-less-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#time”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is less than or equal to the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#time” [XS] Section 3.2.8.
 Otherwise, it SHALL return “False”.  Note: it is illegal to compare a time that includes a
 time-zone value with one that does not.  In such cases, the time-in-range function should be used.

 urn:oasis:names:tc:xacml:2.0:function:time-in-range
 This function SHALL take three arguments of data-type “http://www.w3.org/2001/XMLSchema#time”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if the first argument falls in the range defined inclusively by the second and third arguments.
 Otherwise, it SHALL return “False”.  Regardless of its value, the third argument SHALL be interpreted
 as a time that is equal to, or later than by less than twenty-four hours, the second argument.
 If no time zone is provided for the first argument, it SHALL use the default time zone at the context handler.
 If no time zone is provided for the second or third arguments, then they SHALL use the time zone from the first argument.

 urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#dateTime”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is greater than the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#dateTime” by [XS] part 2, section 3.2.7.
 Otherwise, it SHALL return “False”.  Note: if a dateTime value does not include a
 time-zone value, then an implicit time-zone value SHALL be assigned, as described in [XS].

 urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#dateTime”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is greater than or equal to the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#dateTime” by [XS] part 2, section 3.2.7.
 Otherwise, it SHALL return “False”.  Note: if a dateTime value does not include a time-zone value,
 then an implicit time-zone value SHALL be assigned, as described in [XS].

 urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#dateTime”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is less than the second argument according to the order
 relation specified for “http://www.w3.org/2001/XMLSchema#dateTime” by [XS, part 2, section 3.2.7].
 Otherwise, it SHALL return “False”.  Note: if a dateTime value does not include a time-zone value,
 then an implicit time-zone value SHALL be assigned, as described in [XS].

 urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema# dateTime”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is less than or equal to the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#dateTime” by [XS] part 2, section 3.2.7.
 Otherwise, it SHALL return “False”.  Note: if a dateTime value does not include a time-zone value,
 then an implicit time-zone value SHALL be assigned, as described in [XS].

 urn:oasis:names:tc:xacml:1.0:function:date-greater-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#date”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is greater than the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#date” by [XS] part 2, section 3.2.9.
 Otherwise, it SHALL return “False”.  Note: if a date value does not include a time-zone value,
 then an implicit time-zone value SHALL be assigned, as described in [XS].

 urn:oasis:names:tc:xacml:1.0:function:date-greater-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#date”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is greater than or equal to the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#date” by [XS] part 2, section 3.2.9.
 Otherwise, it SHALL return “False”.  Note: if a date value does not include a time-zone value,
 then an implicit time-zone value SHALL be assigned, as described in [XS].

 urn:oasis:names:tc:xacml:1.0:function:date-less-than
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#date”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is less than the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#date” by [XS] part 2, section 3.2.9.
 Otherwise, it SHALL return “False”.  Note: if a date value does not include a time-zone value,
 then an implicit time-zone value SHALL be assigned, as described in [XS].

 urn:oasis:names:tc:xacml:1.0:function:date-less-than-or-equal
 This function SHALL take two arguments of data-type “http://www.w3.org/2001/XMLSchema#date”
 and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.
 It SHALL return "True" if and only if the first argument is less than or equal to the second argument
 according to the order relation specified for “http://www.w3.org/2001/XMLSchema#date” by [XS] part 2, section 3.2.9.
 Otherwise, it SHALL return “False”.  Note: if a date value does not include a time-zone value,
 then an implicit time-zone value SHALL be assigned, as described in [XS].

 */

/**
 * XACML Non-Numeric Comparison Functions
 * <p/>
 * Testing Functions as specified by OASIS XACML v3 Core specification.
 *
 * @author Jeff.Schenk@ForgeRock.com
 */
public class TestXacmlNonNumericComparisonFunctions {

    static final FunctionArgument trueObject = new DataValue(DataType.XACMLBOOLEAN, "true");
    static final FunctionArgument falseObject = new DataValue(DataType.XACMLBOOLEAN, "false");

    static final FunctionArgument string1 = new DataValue(DataType.XACMLSTRING, "Hello World!");
    static final FunctionArgument string2 = new DataValue(DataType.XACMLSTRING, "HELLO WORLD!");
    static final FunctionArgument string3 = new DataValue(DataType.XACMLSTRING, "Hello");
    static final FunctionArgument string4 = new DataValue(DataType.XACMLSTRING, "HELLO WORLD!");
    static final FunctionArgument stringAlphaUpper = new DataValue(DataType.XACMLSTRING, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    static final FunctionArgument stringAlphaLower = new DataValue(DataType.XACMLSTRING, "abcdefghijklmnopqrstuvwxyz");

    static final Date time1 = XACML3PrivilegeUtils.stringToDateTime(
            XACML3PrivilegeUtils.HOUR_MINUTE_SECOND_MILLISECONDS,  "01:45:30.126");
    static final FunctionArgument timeObject1 = new DataValue(DataType.XACMLTIME, time1, true);

    static final Date time2 = XACML3PrivilegeUtils.stringToDateTime(
            XACML3PrivilegeUtils.HOUR_MINUTE_SECOND_MILLISECONDS, "02:45:30.126");
    static final FunctionArgument timeObject2 = new DataValue(DataType.XACMLTIME, time2, true);

    static final Date time3 = XACML3PrivilegeUtils.stringToDateTime(
            XACML3PrivilegeUtils.HOUR_MINUTE_SECOND_MILLISECONDS, "01:45:30.126");
    static final FunctionArgument timeObject3 = new DataValue(DataType.XACMLTIME, time3, true);

    static final Date time4 = XACML3PrivilegeUtils.stringToDateTime(
            XACML3PrivilegeUtils.HOUR_MINUTE_SECOND_MILLISECONDS, "01:45:30.127");
    static final FunctionArgument timeObject4 = new DataValue(DataType.XACMLTIME, time4, true);

    static final Date time5 = XACML3PrivilegeUtils.stringToDateTime(
            XACML3PrivilegeUtils.HOUR_MINUTE_SECOND_MILLISECONDS, "03:00:00.000");
    static final FunctionArgument timeObject5 = new DataValue(DataType.XACMLTIME, time5, true);


    @BeforeClass
    public void before() throws Exception {
    }

    @AfterClass
    public void after() throws Exception {
    }

    /**
     *  urn:oasis:names:tc:xacml:1.0:function:string-greater-than
     */
    @Test
    public void testStringGreaterThan() throws XACML3EntitlementException {

        StringGreaterThan stringGreaterThan = new StringGreaterThan();
        // Place Objects in Argument stack for comparison.
        stringGreaterThan.addArgument(stringAlphaLower);
        stringGreaterThan.addArgument(stringAlphaUpper);
        FunctionArgument result = stringGreaterThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringGreaterThan = new StringGreaterThan();
        // Place Objects in Argument stack for comparison.
        stringGreaterThan.addArgument(string1);
        stringGreaterThan.addArgument(string2);
        result = stringGreaterThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringGreaterThan = new StringGreaterThan();
        // Place Objects in Argument stack for comparison.
        stringGreaterThan.addArgument(string2);
        stringGreaterThan.addArgument(string4);
        result = stringGreaterThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isFalse());
    }

    /**
     *  urn:oasis:names:tc:xacml:1.0:function:string-greater-than-or-equal
     */
    @Test
    public void testStringGreaterThanOrEqual() throws XACML3EntitlementException {
        StringGreaterThanOrEqual stringGreaterThanOrEqual = new StringGreaterThanOrEqual();
        // Place Objects in Argument stack for comparison.
        stringGreaterThanOrEqual.addArgument(stringAlphaLower);
        stringGreaterThanOrEqual.addArgument(stringAlphaUpper);
        FunctionArgument result = stringGreaterThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringGreaterThanOrEqual = new StringGreaterThanOrEqual();
        // Place Objects in Argument stack for comparison.
        stringGreaterThanOrEqual.addArgument(string1);
        stringGreaterThanOrEqual.addArgument(string2);
        result = stringGreaterThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringGreaterThanOrEqual = new StringGreaterThanOrEqual();
        // Place Objects in Argument stack for comparison.
        stringGreaterThanOrEqual.addArgument(string2);
        stringGreaterThanOrEqual.addArgument(string4);
        result = stringGreaterThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());
    }

    /**
     *  urn:oasis:names:tc:xacml:1.0:function:string-less-than
     */
    @Test
    public void testStringLessThan() throws XACML3EntitlementException {

        StringLessThan stringLessThan = new StringLessThan();
        // Place Objects in Argument stack for comparison.
        stringLessThan.addArgument(stringAlphaUpper);
        stringLessThan.addArgument(stringAlphaLower);
        FunctionArgument result = stringLessThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringLessThan = new StringLessThan();
        // Place Objects in Argument stack for comparison.
        stringLessThan.addArgument(string2);
        stringLessThan.addArgument(string1);
        result = stringLessThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringLessThan = new StringLessThan();
        // Place Objects in Argument stack for comparison.
        stringLessThan.addArgument(string2);
        stringLessThan.addArgument(string4);
        result = stringLessThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isFalse());
    }

    /**
     *  urn:oasis:names:tc:xacml:1.0:function:string-less-than-or-equal
     */
    @Test
    public void testStringLessThanOrEqual() throws XACML3EntitlementException {

        StringLessThanOrEqual stringLessThanOrEqual = new StringLessThanOrEqual();
        // Place Objects in Argument stack for comparison.
        stringLessThanOrEqual.addArgument(stringAlphaUpper);
        stringLessThanOrEqual.addArgument(stringAlphaLower);
        FunctionArgument result = stringLessThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringLessThanOrEqual = new StringLessThanOrEqual();
        // Place Objects in Argument stack for comparison.
        stringLessThanOrEqual.addArgument(string2);
        stringLessThanOrEqual.addArgument(string1);
        result = stringLessThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        stringLessThanOrEqual = new StringLessThanOrEqual();
        // Place Objects in Argument stack for comparison.
        stringLessThanOrEqual.addArgument(string2);
        stringLessThanOrEqual.addArgument(string4);
        result = stringLessThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());
    }

    /**
     * urn:oasis:names:tc:xacml:1.0:function:time-greater-than
     */
    @Test
    public void testTimeGreaterThan() throws XACML3EntitlementException {

        TimeGreaterThan timeGreaterThan = new TimeGreaterThan();
        timeGreaterThan.addArgument(timeObject1);
        timeGreaterThan.addArgument(timeObject2);

        FunctionArgument result = timeGreaterThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isFalse());

        timeGreaterThan = new TimeGreaterThan();
        timeGreaterThan.addArgument(timeObject2);
        timeGreaterThan.addArgument(timeObject3);

        result = timeGreaterThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        timeGreaterThan = new TimeGreaterThan();
        timeGreaterThan.addArgument(timeObject4);
        timeGreaterThan.addArgument(timeObject3);

        result = timeGreaterThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());
    }

    /**
     * urn:oasis:names:tc:xacml:1.0:function:time-greater-than-or-equal
     */
    @Test
    public void testTimeGreaterThanOrEqual() throws XACML3EntitlementException {

        TimeGreaterThanOrEqual timeGreaterThanOrEqual = new TimeGreaterThanOrEqual();
        timeGreaterThanOrEqual.addArgument(timeObject1);
        timeGreaterThanOrEqual.addArgument(timeObject2);

        FunctionArgument result = timeGreaterThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isFalse());

        timeGreaterThanOrEqual = new TimeGreaterThanOrEqual();
        timeGreaterThanOrEqual.addArgument(timeObject2);
        timeGreaterThanOrEqual.addArgument(timeObject3);

        result = timeGreaterThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        timeGreaterThanOrEqual = new TimeGreaterThanOrEqual();
        timeGreaterThanOrEqual.addArgument(timeObject4);
        timeGreaterThanOrEqual.addArgument(timeObject3);

        result = timeGreaterThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());
    }

    /**
     *  urn:oasis:names:tc:xacml:1.0:function:time-less-than
     */
    @Test
    public void testTimeLessThan() throws XACML3EntitlementException {

        TimeLessThan timeLessThan = new TimeLessThan();
        timeLessThan.addArgument(timeObject1);
        timeLessThan.addArgument(timeObject2);

        FunctionArgument result = timeLessThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        timeLessThan = new TimeLessThan();
        timeLessThan.addArgument(timeObject2);
        timeLessThan.addArgument(timeObject3);

        result = timeLessThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isFalse());

        timeLessThan = new TimeLessThan();
        timeLessThan.addArgument(timeObject3);
        timeLessThan.addArgument(timeObject4);

        result = timeLessThan.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());
    }

    /**
     *  urn:oasis:names:tc:xacml:1.0:function:time-less-than-or-equal
     */
    @Test
    public void testTimeLessThanOrEqual() throws XACML3EntitlementException {
        TimeLessThanOrEqual timeLessThanOrEqual = new TimeLessThanOrEqual();
        timeLessThanOrEqual.addArgument(timeObject1);
        timeLessThanOrEqual.addArgument(timeObject2);

        FunctionArgument result = timeLessThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

        timeLessThanOrEqual = new TimeLessThanOrEqual();
        timeLessThanOrEqual.addArgument(timeObject2);
        timeLessThanOrEqual.addArgument(timeObject3);

        result = timeLessThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isFalse());

        timeLessThanOrEqual = new TimeLessThanOrEqual();
        timeLessThanOrEqual.addArgument(timeObject3);
        timeLessThanOrEqual.addArgument(timeObject4);

        result = timeLessThanOrEqual.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());
    }

    /**
     * urn:oasis:names:tc:xacml:2.0:function:time-in-range
     *
     This function SHALL take three arguments of data-type “http://www.w3.org/2001/XMLSchema#time”
     and SHALL return an “http://www.w3.org/2001/XMLSchema#boolean”.

     It SHALL return "True" if the first argument falls in the range defined inclusively by the second and third arguments.
     Otherwise, it SHALL return “False”.  Regardless of its value, the third argument SHALL be interpreted
     as a time that is equal to, or later than by less than twenty-four hours, the second argument.
     If no time zone is provided for the first argument, it SHALL use the default time zone at the context handler.
     If no time zone is provided for the second or third arguments, then they SHALL use the time zone from the first argument.

     * @throws XACML3EntitlementException
     */
    @Test
    public void testTimeInRange() throws XACML3EntitlementException {
        TimeInRange timeinRange = new TimeInRange();
        timeinRange.addArgument(timeObject1);  // To be In Range.
        timeinRange.addArgument(timeObject3);  // In Range Start.
        timeinRange.addArgument(timeObject5);  // In Range End.

        FunctionArgument result = timeinRange.evaluate(null);
        assertNotNull(result);
        assertTrue(result.isTrue());

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than
     */
    @Test
    public void testDateTimeGreaterThanOrEqual() throws XACML3EntitlementException {

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than-or-equal
     */
    @Test
    public void testDateTimeGreaterThanOrEqualOrEqual() throws XACML3EntitlementException {

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than
     */
    @Test
    public void testDateTimeLessThan() throws XACML3EntitlementException {

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than-or-equal
     */
    @Test
    public void testDateTimeLessThanOrEqual() throws XACML3EntitlementException {

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:date-greater-than
     */
    @Test
    public void testDateGreaterThan() throws XACML3EntitlementException {

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:date-greater-than-or-equal
     */
    @Test
    public void testDateGreaterThanOrEqual() throws XACML3EntitlementException {

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:date-less-than
     */
    @Test
    public void testDateLessThan() throws XACML3EntitlementException {

    }

    /**
     *   urn:oasis:names:tc:xacml:1.0:function:date-less-than-or-equal
     */
    @Test
    public void testDateLessThanOrEqual() throws XACML3EntitlementException {

    }

}
