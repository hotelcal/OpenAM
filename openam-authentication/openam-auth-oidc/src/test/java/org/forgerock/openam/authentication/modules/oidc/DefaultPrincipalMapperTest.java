/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2014 ForgeRock AS.
 */

package org.forgerock.openam.authentication.modules.oidc;

import org.forgerock.json.jose.jwt.JwtClaimsSet;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class DefaultPrincipalMapperTest {
    private static final String SUB = "sub";
    private static final String ID = "id";
    private static final String ISS = "iss";
    private static final String SUBJECT = "112403712094132422537";
    private static final String ISSUER = "accounts.google.com";
    private Map<String, Object> jwtMappings;
    private Map<String, String> attributeMappings;

    @BeforeTest
    public void initialize() {
        jwtMappings = new HashMap<String, Object>();
        jwtMappings.put(SUB, SUBJECT);
        jwtMappings.put(ISS, ISSUER);

        attributeMappings = new HashMap<String, String>();
        attributeMappings.put(ID, SUB);


    }

    @Test
    public void testBasicJwtMapping() {
        final JwtClaimsSet claimsSet = new JwtClaimsSet(jwtMappings);
        final DefaultPrincipalMapper defaultPrincipalMapper = new DefaultPrincipalMapper();
        final Map<String, Set<String>> attrs =
                defaultPrincipalMapper.getAttributesForPrincipalLookup(attributeMappings, null, claimsSet, null);
        assertTrue(SUBJECT.equals(attrs.get(ID).iterator().next()));
    }
}