package org.mule.consulting.totp.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;

import org.mule.consulting.totp.api.TotpErrors;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "totp")
@Extension(name = "Totp")
@ErrorTypes(TotpErrors.class)
@Configurations(TotpConfiguration.class)
public class TotpExtension {

}
