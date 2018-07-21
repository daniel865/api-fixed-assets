package com.co.intrasoft.fixedassets.exceptions;

public class InconsistentDataException extends RuntimeException {

    public InconsistentDataException() {
        super();
    }

    public InconsistentDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InconsistentDataException(String message) {
        super(message);
    }

    public InconsistentDataException(Throwable cause)  {
        super(cause);
    }

}
