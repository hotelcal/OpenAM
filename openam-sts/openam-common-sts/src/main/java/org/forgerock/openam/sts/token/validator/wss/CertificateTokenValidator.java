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
 * information: "Portions Copyrighted [year] [name of copyright owner]".
 *
 * Copyright 2013-2014 ForgeRock AS. All rights reserved.
 */

package org.forgerock.openam.sts.token.validator.wss;

import com.google.inject.Inject;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.handler.RequestData;
import org.apache.ws.security.validate.Credential;
import org.apache.ws.security.validate.SignatureTrustValidator;

import java.security.cert.X509Certificate;
import org.slf4j.Logger;

/**
 * This class extends the Apache WSS4j TokenValidator deployed by Apache CXF to validate x509 tokens presented as part
 * of consuming an STS instance protected by SecurityPolicy bindings specifying an x509 ProtectionToken. This class will
 * integrate this validation with OpenAM by consuming the OpenAM REST authN functionality.
 *
 * This validation functionality will only augment the existing CXF validation functionality to determine whether the
 * included certs are present in the OpenAM LDAP certificate store.
 *
 * TODO: It may make sense to move this to a soap-specific package. The rest-sts CertificateTokenValidator will only
 * be consumed via in a two-way tls case, and will consume the OpenAM Cert LoginModule only to do the additional (OCSP, CRL, LDAP)
 * checks. On the other hand, in the soap-sts, the validity of the caller asserting its identity via presenting a x509 cert
 * (SecurityPolicyExamples 2.2.1 and 2.2.2) will be insured because messages sent to the caller will be encrypted using the
 * caller's public key. In this case, only trust needs to be established - something which this class, by virtue of
 * extending the SignatureTrustValidator, provides. In the rest-sts case, this trust has already been established by
 * two-way tls. Thus the rest-sts incarnation of this class (in the rest-sts module), will only invoke the AuthenticationHandler
 * to dispatch the request to the OpenAM rest authN context. This class should probably be moved into the soap-sts package.
 */
public class CertificateTokenValidator extends SignatureTrustValidator {
    private final AuthenticationHandler<X509Certificate[]> authenticationHandler;
    private final Logger logger;

    @Inject
    public CertificateTokenValidator(Logger logger, AuthenticationHandler<X509Certificate[]> authenticationHandler) {
        this.logger = logger;
        this.authenticationHandler = authenticationHandler;
    }

    @Override
    public Credential validate(Credential credential, RequestData data) throws WSSecurityException {
        /*
        Call the super method not to lose existing functionality.
        TODO: need to determine when to call the authenticationHandler below - if it is just a trust question, then
        don't call - if we want to hit AM authN functionality, then do call. The question is, how to distinguish these
        cases? Could we add method to AuthenticationRegistry to consult the AuthTargetMapping to see if there is an
        entry for x509Certificate, and only dispatch if this is the case?
         */
        Credential localCredential = super.validate(credential, data);
        try {
            authenticationHandler.authenticate(data, credential.getCertificates());
            return credential;
        } catch (Exception e) {
            logger.error("Exception caught authenticating X509Certificate with OpenAM: " + e, e);
            throw new WSSecurityException(WSSecurityException.FAILED_AUTHENTICATION, e.getMessage());
        }
    }
}
