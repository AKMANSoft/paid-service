package com.example.modulepaidservice.modulepaid.exception;

import com.example.modulepaidservice.modulepaid.response.ErrorResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

/**
 * All business error code will be defined here.
 */
public final class BusinessErrorCode {

    private BusinessErrorCode() {
        throw new IllegalStateException("Utility class");
    }

    @UtilityClass
    public static final class ModulePaidErrorCode {

        public static final ErrorResponse MODULE_PAID_CREATE_ERROR = new ErrorResponse("000001",
            "Create module paid error, please check again",
            HttpStatus.BAD_REQUEST);
    }
}
