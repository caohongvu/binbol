package com.binbol.message;

import java.util.Collection;

/**
 * Ecoe Webservice Subsystem Messages G W S M
 */
public enum EWSMessage {
	OK("0", "SUCCESS", 200), RESOURCE_NOT_FOUND("ERR_ECOE_001", "This resource doesn't exist in DB", 404),
	RESOURCE_CONFLICT("ERR_ECOE_002", "This resource exist in DB", 409),
	EMPTY_COLUMN("ERR_ECOE_003", "Empty column(s): %s", 400),
	INVALID_REQUEST_PARAMETER("ERR_ECOE_004", "Invalid parameter(s): %s", 400),
	MISSING_REQUEST_PARAMETER("ERR_ECOE_005", "Required parameter(s): %s", 400),
	RESOURCE_CREATED_FAILURE("ERR_ECOE_006", "Can not create this user", 409),
	RESOURCE_UPDATE_FAILURE("ERR_ECOE_007", "Can not update this user", 409),
	UPDATE_PASSWORD_FAILURE("ERR_ECOE_008", "Can not update password", 409),
	INVALID_OTP("ERR_ECOE_011", "The otp does not exist", 409),
	SMS_FAILURE("ERR_ECOE_012", "Can't send sms!", 409),
	WRONG_PASSWORD("ERR_ECOE_009", "Incorrect password", 409),
	UNACTIVE("ERR_ECOE_010", "This user unactive", 403);
	public static final String ERROR_SEPARATOR = ", ";
	String code;

	String message;
	int httpCode;

	EWSMessage(String code, String message, int httpCode) {
		this.code = code;
		this.message = message;
		this.httpCode = httpCode;
	}

	public String getCode() {
		return code;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public String getMessage(Collection<String> errorValues) {
		return String.format(message, String.join(ERROR_SEPARATOR, errorValues));
	}

	public String getMessage(String... args) {
		return String.format(message, (Object[]) args);
	}
}
