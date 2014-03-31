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

package org.forgerock.openam.noauth2.wrappers;

import com.sun.identity.idm.AMIdentity;
import org.forgerock.oauth2.core.ClientRegistration;
import org.forgerock.oauth2.core.ClientRegistrationStore;
import org.forgerock.openam.oauth2.model.impl.ClientApplicationImpl;

/**
 * @since 12.0.0
 */
public class OpenAMClientRegistrationStore implements ClientRegistrationStore<AMIdentity> {

    public ClientRegistration get(AMIdentity id) {
        return new ClientApplicationImpl(id);
    }
}