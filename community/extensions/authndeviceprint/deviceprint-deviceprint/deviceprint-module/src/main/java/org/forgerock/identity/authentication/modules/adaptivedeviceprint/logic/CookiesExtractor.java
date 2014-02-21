/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2009 Sun Microsystems Inc. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * https://opensso.dev.java.net/public/CDDLv1.0.html or
 * opensso/legal/CDDLv1.0.txt
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at opensso/legal/CDDLv1.0.txt.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 */

package org.forgerock.identity.authentication.modules.adaptivedeviceprint.logic;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.forgerock.identity.authentication.modules.adaptivedeviceprint.model.DevicePrint;

public class CookiesExtractor implements ExtractorIface {
	
	private static final String ADAPTIVE_DEVICE_PRINT_COOKIE_NAME = "AdaptiveDevicePrintCookie";
	
	@Override
	public void extractData(DevicePrint devicePrint, HttpServletRequest request) {
		for(Cookie cookie : request.getCookies()) {
			if( cookie.getName().equals(ADAPTIVE_DEVICE_PRINT_COOKIE_NAME) ) {
				devicePrint.setPersistentCookie(cookie.getValue());
			}
		}
	}

}