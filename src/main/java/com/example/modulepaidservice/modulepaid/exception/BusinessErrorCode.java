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

        public static final ErrorResponse MODULE_PAID_CLIENT_TIN_EXISTED = new ErrorResponse("000002",
                "ClientTin existed in system, please check input data",
                HttpStatus.BAD_REQUEST);

        public static final ErrorResponse MODULE_PAID_GET_ERROR = new ErrorResponse("000003",
                "Get module paid error, please check again",
                HttpStatus.BAD_REQUEST);

        public static final ErrorResponse MODULE_PAID_NOT_FOUND_ERROR = new ErrorResponse("000004",
                "Data not found",
                HttpStatus.BAD_REQUEST);


        public static final ErrorResponse MODULE_PAID_SEARCH_ERROR = new ErrorResponse("000005",
                "Search module paid error, please check again",
                HttpStatus.BAD_REQUEST);
    }
}
