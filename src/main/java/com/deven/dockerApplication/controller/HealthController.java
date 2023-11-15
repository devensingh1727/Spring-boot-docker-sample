package com.deven.dockerApplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.deven.dockerApplication.constant.AppConstant.ApiConstant.HEALTH_OK_MESSAGE;
import static com.deven.dockerApplication.constant.AppConstant.ApiEndPoints.HEALTH_CHECK_URL_END_POINT;

@Slf4j
@RestController
public class HealthController {

    @GetMapping(value = HEALTH_CHECK_URL_END_POINT)
    public ResponseEntity<Object> checkHealth() {
        log.info("health is Ok.");
        return new ResponseEntity<>(HEALTH_OK_MESSAGE, HttpStatus.OK);
    }

}
