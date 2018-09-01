package org.mule.consulting.totp.api;

public class TotpException extends Exception {

    public TotpException(String message) {
        super(message);
    }

    public TotpException(String message, Throwable cause) {
        super(message, cause);
    }

    public TotpException(Throwable cause) {
        super(cause);
    }

    public TotpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
