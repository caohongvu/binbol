package com.binbol.exception;

import com.binbol.message.EWSMessage;


public class BinbolRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public String errorID;
    public int httpStatus;


    public BinbolRuntimeException(String errorID, String message) {
        super(message);
        this.errorID = errorID;
    }

    public BinbolRuntimeException(String errorID, String message, int httpStatus) {
        super(message);
        this.errorID = errorID;
        this.httpStatus = httpStatus;
    }

    public BinbolRuntimeException(EWSMessage errorMsg) {
        this(errorMsg.getCode(), errorMsg.getMessage(), errorMsg.getHttpCode());
    }
}
