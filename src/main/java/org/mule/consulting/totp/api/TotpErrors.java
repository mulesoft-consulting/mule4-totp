package org.mule.consulting.totp.api;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public enum TotpErrors implements ErrorTypeDefinition<TotpErrors> {
	EMPTY_TOKEN,
	EMPTY_KEY,
	INVALID_TOKEN
}
