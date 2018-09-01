package org.mule.consulting.totp.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.mule.consulting.totp.api.TotpException;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class TotpOperations {

	/**
	 * Use to generate a totp.
	 * 
	 * @throws TotpException
	 */
	@MediaType(value = ANY, strict = false)
	public String generate(String key) throws TotpException {

		if (key == null || key.isEmpty()) {
			throw new TotpException("key property must contain the shared secret value");
		}
		String normalizedBase32Key = key.replace(" ", "").toUpperCase();
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(normalizedBase32Key);
		String hexKey = Hex.encodeHexString(bytes);

		long time = (System.currentTimeMillis() / 1000) / 30;
		String hexTime = Long.toHexString(time);
		return TOTP.generateTOTP(hexKey, hexTime, "6");
	}

	/**
	 * Use to validate a totp.
	 * 
	 * @throws TotpException
	 */
	@MediaType(value = ANY, strict = false)
	public void validate(String key, boolean enabled, String inbound_totp) throws TotpException {

		if (enabled == false) {
			return;
		}
		if (key == null || key.isEmpty()) {
			throw new TotpException("Empty key");
		}
		String normalizedBase32Key = key.replace(" ", "").toUpperCase();
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(normalizedBase32Key);
		String hexKey = Hex.encodeHexString(bytes);

		long time = (System.currentTimeMillis() / 1000) / 30;
		String hexTime = Long.toHexString(time);
		String totp = TOTP.generateTOTP(hexKey, hexTime, "6");
		if (inbound_totp == null || inbound_totp.isEmpty()) {
			throw new TotpException("Empty token");
		}
		
		if (totp.equals(inbound_totp)) {
			return;
		} else {
			throw new TotpException("Invalid token");
		}
	}

}
