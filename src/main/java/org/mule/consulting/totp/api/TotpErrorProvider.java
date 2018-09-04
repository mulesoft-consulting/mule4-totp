package org.mule.consulting.totp.api;

import java.util.HashSet;
import java.util.Set;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public class TotpErrorProvider implements ErrorTypeProvider {

	@SuppressWarnings("rawtypes")
	@Override
	public Set<ErrorTypeDefinition> getErrorTypes() {
        HashSet<ErrorTypeDefinition> errors = new HashSet<>();
        errors.add(TotpErrors.EMPTY_KEY);
        errors.add(TotpErrors.EMPTY_TOKEN);
        errors.add(TotpErrors.INVALID_TOKEN);
        return errors;
	}

}
