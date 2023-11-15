package com.deven.dockerApplication.constant;

public interface AppConstant {

    interface ApiConstant {
        String HEALTH_OK_MESSAGE = "Health is OK.";
    }

    interface ApiEndPoints {
        String HEALTH_CHECK_URL_END_POINT = "health/check";
    }

    interface ErrorCode {
        String ERR_500 = "E-500";
        String ERR_404 = "E-404";
        String ERR_400 = "E-400";
    }

    interface ApiHeader {
        String CORRELATION_ID = "correlation_id";
    }

    interface ErrorMessage {
        String GENERIC_ERROR_MESSAGE = "Something went wrong. Please try again.";
    }
}
